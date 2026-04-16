package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class LightAttackAction implements CombatAction {

    @Override
    public String name() {
        return "Attaque légère";
    }

    @Override
    public int enduranceCost() {
        return 15;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        int dmg = hero.attaquer(); // base weapon

        monster.takeDamage(dmg);

        System.out.println("⚔ Attaque légère !");
        System.out.println("💥 -" + dmg + " HP");
    }
}
