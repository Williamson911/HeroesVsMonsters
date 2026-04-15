package be.technifutur.heroesvsmonsters.skills;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class FireBallSkill implements Skill {

    @Override
    public String name() {
        return "Fireball";
    }

    @Override
    public int manaCost() {
        return 15;
    }

    @Override
    public int cooldown() {
        return 2;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        int dmg = hero.getIntelligence().getValeur() * 2;

        monster.takeDamage(dmg);

        System.out.println("🔥 Fireball inflige " + dmg + " dégâts !");
    }
}