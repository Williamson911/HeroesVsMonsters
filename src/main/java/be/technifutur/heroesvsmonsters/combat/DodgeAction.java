package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class DodgeAction implements CombatAction {

    @Override
    public String name() {
        return "Dodge";
    }

    @Override
    public int enduranceCost() {
        return 20;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        if (!hero.getEndurance().hasEnough(enduranceCost())) {
            System.out.println("❌ Pas assez de stamina pour dodge !");
            return;
        }

        hero.getEndurance().consume(enduranceCost());

        hero.setDodging(true); // à ajouter dans Heroes

        System.out.println("💨 You dodged the next attack!");
    }
}