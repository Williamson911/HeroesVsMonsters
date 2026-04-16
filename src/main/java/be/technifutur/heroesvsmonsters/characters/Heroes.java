package be.technifutur.heroesvsmonsters.characters;

import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Potion;
import be.technifutur.heroesvsmonsters.skills.Skill;
import be.technifutur.heroesvsmonsters.weapons.Armes;
import be.technifutur.heroesvsmonsters.world.Bloodstain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public abstract class Heroes extends Personnage {
    private final Map<String, Integer> cooldowns = new HashMap<>();

    private int ames = 0;
    private int level = 1;

    private Armes armeEquipee;

    public Heroes(String nom) {
        super(nom);
    }

    // ── Âmes ─────────────────────────────

    public void gagnerAmes(int montant) {
        this.ames += montant;
        System.out.printf("+%d âmes (Total : %d)%n", montant, ames);
    }

    public int getAmes() {
        return ames;
    }

    // ── Niveau ───────────────────────────

    public int getLevel() {
        return level;
    }

    /** Coût DS : 200 âmes au niveau 1, +100 par niveau supplémentaire */
    public int getLevelUpCost() {
        return 200 + (level - 1) * 100;
    }

    public boolean canLevelUp() {
        return ames >= getLevelUpCost();
    }

    public void increaseLevel() {
        ames -= getLevelUpCost();
        level++;
    }

    // ── Loot ─────────────────────────────
    public void addItem(Item item) {
        inventaire.merge(item, 1, Integer::sum);
    }
    public void removeItem(Item item) {
        int qty = inventaire.getOrDefault(item, 0);

        if (qty <= 1) {
            inventaire.remove(item);
        } else {
            inventaire.put(item, qty - 1);
        }
    }
    public void looter(Monsters monster) {

        int ames = monster.getAmesReward();
        gagnerAmes(ames);

        System.out.println("💰 +" + ames + " âmes");

        for (Item item : monster.generateLoot()) {

            addItem(item);

            System.out.println("🎁 Loot : " + item.getNom());
        }
    }

    // ── Inventaire ───────────────────────

    private Map<Item, Integer> inventaire = new HashMap<>();

    public Map<Item, Integer> getInventaire() {
        return Collections.unmodifiableMap(inventaire);
    }
    public void removeItem(int index) {
        inventaire.remove(index);
    }



    // ── Équipement ───────────────────────

    public Armes getArmeEquipee() {
        return armeEquipee;
    }

    public void equiper(Armes arme) {

        if (!inventaire.containsKey(arme)) {
            System.out.println("Vous ne possédez pas cette arme !");
            return;
        }
        this.armeEquipee = arme;
        System.out.println("Arme équipée : " + arme.getNom());
    }

    // ── Combat ───────────────────────────

    public int attaquer() {

        if (armeEquipee == null) {
            System.out.println("Attaque à mains nues !");
            return 5;
        }

        return armeEquipee.getDegatsReels(this);
    }

    // ── Mort ─────────────────────────────

    public void perdreAmes() {
        System.out.printf("Vous perdez %d âmes...%n", ames);
        ames = 0;
    }
    private boolean defending = false;

    public boolean isDefending() {
        return defending;
    }

    public void setDefending(boolean defending) {
        this.defending = defending;
    }


    public void resetCombatState() {
        defending = false;
    }
    public boolean isSkillAvailable(Skill skill) {
        return cooldowns.getOrDefault(skill.name(), 0) == 0;
    }

    public void setCooldown(Skill skill) {
        cooldowns.put(skill.name(), skill.cooldown());
    }

    public void reduceCooldowns() {
        cooldowns.replaceAll((k, v) -> Math.max(0, v - 1));
    }
    public boolean hasMana(int cost) {
        return getEndurance().getValeur() >= cost;
    }

    public void consumeMana(int cost) {
        getEndurance().reduire(cost);
    }
    private Bloodstain bloodstain;
    public void mourir(String zoneName) {

        if (bloodstain != null) {
            System.out.println("💀 Vous avez perdu définitivement vos anciennes âmes...");
        }

        bloodstain = new Bloodstain(ames, zoneName);

        System.out.printf("💀 Vous perdez %d âmes...%n", ames);

        ames = 0;
    }
    public void recupererAmes(String currentZone) {

        if (bloodstain == null) return;

        if (bloodstain.getZoneName().equals(currentZone)) {

            int recovered = bloodstain.getAmes();

            ames += recovered;

            System.out.println("🩸 Vous récupérez " + recovered + " âmes !");

            bloodstain = null;
        }
    }
    public boolean quickUsePotion() {

        for (Item item : inventaire.keySet()) {

            if (item instanceof Potion potion) {
                potion.utiliser(this);
                removeItem(item);

                System.out.println("⚡ Potion utilisée !");
                return true;
            }
        }

        return false;
    }
    private boolean dodging = false;

    public boolean isDodging() {
        return dodging;
    }

    public void setDodging(boolean dodging) {
        this.dodging = dodging;
    }
    public int getStaminaRegen() {

        if (dodging) return 15;      // reward timing play
        if (defending) return 12;    // passive recovery
        return 10;                    // normal regen
    }
    private boolean parryWindow = false;

    public boolean isParryWindow() {
        return parryWindow;
    }

    public void setParryWindow(boolean parryWindow) {
        this.parryWindow = parryWindow;
    }
}