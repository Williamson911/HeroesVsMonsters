package be.technifutur.heroesvsmonsters.characters;

import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.skills.Skill;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public abstract class Heroes extends Personnage {
    private final Map<String, Integer> cooldowns = new HashMap<>();
    private final List<Item> inventaire = new ArrayList<>();
    private int ames = 0;

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

    // ── Loot ─────────────────────────────

    public void looter(Monsters monstre) {

        System.out.println("\n══ LOOT ══");

        gagnerAmes(monstre.getAmesReward());

        for (Item drop : monstre.generateLoot()) {
            inventaire.add(drop);
            System.out.println("Obtenu : " + drop.getNom());
        }
    }

    // ── Inventaire ───────────────────────

    public List<Item> getInventaire() {
        return Collections.unmodifiableList(inventaire);
    }

    public void ajouterItem(Item item) {
        inventaire.add(item);
    }

    // ── Équipement ───────────────────────

    public Armes getArmeEquipee() {
        return armeEquipee;
    }

    public void equiper(Armes arme) {

        if (!inventaire.contains(arme)) {
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
}