package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;

import java.util.List;

public class Rat extends Monsters {

    public Rat() {
        super("Rat", 50, 0.4);

        getVitalite().addBonus(40);
        getForce().addBonus(6);
        getResistance().addBonus(2);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Consumable("Humanité")
        );
    }
}
