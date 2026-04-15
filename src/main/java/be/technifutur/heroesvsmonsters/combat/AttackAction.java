package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class AttackAction implements CombatAction {

    @Override
    public String name() {
        return "Attaquer";
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {
        int dmg = hero.attaquer();
        monster.takeDamage(dmg);
        System.out.println("Vous infligez " + dmg + " dégâts !");
    }
}