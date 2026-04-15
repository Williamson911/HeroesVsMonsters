package be.technifutur.heroesvsmonsters.skills;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class HealSkill implements Skill {

    @Override
    public String name() {
        return "Heal";
    }

    @Override
    public int manaCost() {
        return 10;
    }

    @Override
    public int cooldown() {
        return 3;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        int heal = hero.getIntelligence().getValeur();

        hero.heal(heal);

        System.out.println("💚 Heal +" + heal + " PV");
    }
}