package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.combat.CombatAction;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public class QuickUsePotionAction implements CombatAction {

    @Override
    public String name() {
        return "Potion rapide";
    }

    @Override
    public int enduranceCost() {
        return 0;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        boolean used = hero.quickUsePotion();

        if (!used) {
            System.out.println("❌ Aucune potion disponible !");
        }
    }
}