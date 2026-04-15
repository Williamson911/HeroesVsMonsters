package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DragonRouge extends Boss {

    public DragonRouge() {
        super("Dragon Rouge", 5000, 0.4);

        getVitalite().addBonus(1500);
        getForce().addBonus(70);
        getResistance().addBonus(40);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Épée Draconique", 140, "Dragon Sword", 40, 20, 5, 4)
        );
    }

    @Override
    protected void phaseTwo() {
        // rage dragon
        getForce().addBonus(40);
    }
}