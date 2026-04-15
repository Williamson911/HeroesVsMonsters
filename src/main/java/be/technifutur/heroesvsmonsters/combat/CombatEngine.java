package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.skills.SkillAction;
import be.technifutur.heroesvsmonsters.utils.InputUtils;

import java.util.List;

public class CombatEngine {

    private final List<CombatAction> actions;

    public CombatEngine() {
        this.actions = List.of(
                new AttackAction(),
                new DefendAction(),
                new ItemAction(),
                new SkillAction(),
                new FleeAction()
        );
    }

    // ─────────────────────────────────────────────
    // ENTRY POINT
    // ─────────────────────────────────────────────
    public boolean start(Heroes hero, Monsters monster) {

        System.out.println("\n⚔ " + hero.getNom() + " VS " + monster.getNom());

        hero.resetCombatState();

        while (hero.isAlive() && monster.isAlive()) {

            printStatus(hero, monster);

            playerTurn(hero, monster);

            if (!monster.isAlive()) break;

            monsterTurn(hero, monster);
        }

        return resolve(hero, monster);
    }

    // ─────────────────────────────────────────────
    // PLAYER TURN
    // ─────────────────────────────────────────────
    private void playerTurn(Heroes hero, Monsters monster) {

        System.out.println("\n══ ACTIONS ══");

        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, actions.get(i).name());
        }

        int choice = InputUtils.readIntInRange(
                1,
                actions.size(),
                "Votre action : "
        ) - 1;

        actions.get(choice).execute(hero, monster);
    }

    // ─────────────────────────────────────────────
    // MONSTER TURN
    // ─────────────────────────────────────────────
    private void monsterTurn(Heroes hero, Monsters monster) {

        int dmg = monster.calculateDamage(hero);

        if (hero.isDefending()) {
            dmg /= 2;
            hero.setDefending(false);
        }

        hero.takeDamage(dmg);

        System.out.println(monster.getNom() + " inflige " + dmg + " dégâts !");
    }

    // ─────────────────────────────────────────────
    // RESOLVE COMBAT
    // ─────────────────────────────────────────────
    private boolean resolve(Heroes hero, Monsters monster) {

        if (!hero.isAlive()) {
            System.out.println("\n💀 Vous êtes mort...");
            hero.perdreAmes();
            return false;
        }

        System.out.println("\n✅ Victoire !");
        hero.looter(monster);

        return true;
    }

    // ─────────────────────────────────────────────
    // UI
    // ─────────────────────────────────────────────
    private void printStatus(Heroes hero, Monsters monster) {

        System.out.println("\n────────────────────────────");

        System.out.println(hero.getNom()
                + " HP: " + hero.getVitalite().getValeur()
                + " | Mana: " + hero.getEndurance());

        System.out.println(monster.getNom()
                + " HP: " + monster.getVitalite().getValeur());

        System.out.println("────────────────────────────");
    }
}