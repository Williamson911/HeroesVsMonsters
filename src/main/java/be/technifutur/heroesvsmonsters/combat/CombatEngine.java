package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Boss;
import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.skills.*;
import be.technifutur.heroesvsmonsters.utils.Cinematic;
import be.technifutur.heroesvsmonsters.utils.CombatUI;
import be.technifutur.heroesvsmonsters.utils.InputUtils;
import be.technifutur.heroesvsmonsters.utils.SpriteLibrary;
import be.technifutur.heroesvsmonsters.utils.UIUtils;

import java.util.List;

public class CombatEngine {

    private final List<CombatAction> actions;

    public CombatEngine() {
        this.actions = List.of(
                new LightAttackAction(),
                new HeavyAttackAction(),
                new DefendAction(),
                new ItemAction(),
                new SkillAction(),
                new FleeAction(),
                new QuickUsePotionAction()

        );
    }

    // ─────────────────────────────────────────────
    // ENTRY POINT
    // ─────────────────────────────────────────────
    public boolean start(Heroes hero, Monsters monster, String zoneName) {

        System.out.println("\n══════════════════════════════");
        System.out.println("⚔ COMBAT ⚔");
        System.out.println(hero.getNom() + " VS " + monster.getNom());
        System.out.println("══════════════════════════════");

        if (monster instanceof Boss) {
            Cinematic.fogGate(monster.getNom());
        }

        SpriteLibrary.printEnemy(monster.getNom());

        hero.resetCombatState();
        hero.getEndurance().reset();

        while (hero.isAlive() && monster.isAlive()) {

            hero.getEndurance().regen(5);

            printStatus(hero, monster);

            playerTurn(hero, monster);

            if (!monster.isAlive()) break;

            monsterTurn(hero, monster);
        }

        return resolve(hero, monster, zoneName);
    }

    // ─────────────────────────────────────────────
    // PLAYER TURN
    // ─────────────────────────────────────────────
    private void playerTurn(Heroes hero, Monsters monster) {

        CombatUI.sleep(100);
        System.out.println("\n══ ACTIONS ══");

        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s (STA: %d)%n",
                    i + 1,
                    actions.get(i).name(),
                    actions.get(i).enduranceCost());
        }
        for (int i = 0; i < actions.size(); i++) {
            CombatAction a = actions.get(i);

            System.out.printf("%d. %s (STA: %d)%n",
                    i + 1,
                    a.name(),
                    a.enduranceCost());
        }
        int choice = InputUtils.readIntInRange(
                1,
                actions.size(),
                "Votre action : "
        ) - 1;

        CombatAction action = actions.get(choice);
        for (int i = 0; i < actions.size(); i++) {

            CombatAction a = actions.get(i);

            boolean canUse = hero.getEndurance().hasEnough(a.enduranceCost());
            String prefix = canUse ? "✔ " : "✖ ";
            String color = canUse ? "" : CombatUI.GREY;
            String reset = CombatUI.RESET;

            System.out.printf("%s%d. %s (STA: %d)%s%n",
                    color,
                    i + 1,
                    a.name(),
                    a.enduranceCost(),
                    reset
            );
        }

        if (!hero.getEndurance().hasEnough(action.enduranceCost())) {
            System.out.println("❌ Pas assez de stamina !");
            return;
        }

        hero.getEndurance().consume(action.enduranceCost());

        CombatUI.sleep(150);
        System.out.println("...chargement...");
        CombatUI.sleep(150);

        action.execute(hero, monster);

        CombatUI.actionFeedback(action.name());
    }

    // ─────────────────────────────────────────────
    // MONSTER TURN
    // ─────────────────────────────────────────────
    private void monsterTurn(Heroes hero, Monsters monster) {
        if (hero.isDefending()) {
            hero.getEndurance().regen(hero.getStaminaRegen());
        } else {
            hero.getEndurance().regen(hero.getStaminaRegen());
        }
        if (hero.isParryWindow()) {

            System.out.println("⚡ PARRY SUCCESS!");

            hero.setParryWindow(false);

            int counterDamage = hero.attaquer() * 2;

            monster.takeDamage(counterDamage);

            CombatUI.hitEffect(counterDamage);

            System.out.println("💥 Counter attack: " + counterDamage);

            return;
        }
        int dmg = monster.calculateDamage(hero);
        if (hero.isDodging()) {
            System.out.println("💨 Dodge réussi !");
            hero.setDodging(false);
            return; // aucun dégâts
        }
        if (hero.isDefending()) {
            dmg /= 2;
            hero.setDefending(false);
        }

        CombatUI.monsterAttack(monster.getNom());
        hero.takeDamage(dmg);
        CombatUI.hitEffect(dmg);

        System.out.println(monster.getNom() + " inflige " + dmg + " dégâts !");
    }

    // ─────────────────────────────────────────────
    // RESOLVE
    // ─────────────────────────────────────────────
    private boolean resolve(Heroes hero, Monsters monster, String zoneName) {

        if (!hero.isAlive()) {
            hero.mourir(zoneName);
            CombatUI.deathAnimation();
            return false;
        }

        hero.looter(monster);

        if (monster instanceof Boss) {
            CombatUI.bossVictoryAnimation(monster.getNom());
        } else {
            CombatUI.victoryAnimation();
        }

        return true;
    }

    // ─────────────────────────────────────────────
    // UI
    // ─────────────────────────────────────────────
    private void printStatus(Heroes hero, Monsters monster) {

        System.out.println("\n────────────────────────────");

        int hp = hero.getVitalite().getValeur();
        int maxHp = hero.getVitalite().getMax();

        int sta = hero.getEndurance().getCurrent();
        int maxSta = hero.getEndurance().getMax();

        System.out.println(hero.getNom());

        System.out.println("❤️ HP  : [" +
                UIUtils.coloredBar(UIUtils.RED, hp, maxHp, 20) +
                "] " + hp + "/" + maxHp);

        System.out.println("⚡ STA : [" +
                UIUtils.coloredBar(UIUtils.GREEN, sta, maxSta, 20) +
                "] " + sta + "/" + maxSta);

        System.out.println(monster.getNom());

        int mHp = monster.getVitalite().getValeur();
        int mMaxHp = monster.getVitalite().getMax();

        System.out.println("HP  : [" +
                UIUtils.coloredBar(UIUtils.RED, mHp, mMaxHp, 20) +
                "] " + mHp + "/" + mMaxHp);

        System.out.println("────────────────────────────");
    }

}