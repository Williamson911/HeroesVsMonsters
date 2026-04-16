package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class ParryAction implements CombatAction {

    @Override
    public String name() {
        return "Parry";
    }

    @Override
    public int enduranceCost() {
        return 15;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        if (!hero.getEndurance().hasEnough(enduranceCost())) {
            System.out.println("❌ Pas assez de stamina !");
            return;
        }

        hero.getEndurance().consume(enduranceCost());

        hero.setParryWindow(true);

        System.out.println("🛡 Parry stance active !");
    }
}