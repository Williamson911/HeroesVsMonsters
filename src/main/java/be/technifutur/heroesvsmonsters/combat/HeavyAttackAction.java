package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class HeavyAttackAction implements CombatAction {

    @Override
    public String name() {
        return "Attaque lourde";
    }

    @Override
    public int enduranceCost() {
        return 35;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        int base = hero.attaquer();

        int dmg = (int) (base * 1.8); // gros scaling

        monster.takeDamage(dmg);

        System.out.println("💥 ATTAQUE LOURDE !");
        System.out.println("🔥 -" + dmg + " HP");
    }
}
