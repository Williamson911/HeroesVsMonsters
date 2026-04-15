package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class DefendAction implements CombatAction {

    @Override
    public String name() {
        return "Défendre";
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {
        hero.setDefending(true);
        System.out.println("Vous vous mettez en garde...");
    }
}
