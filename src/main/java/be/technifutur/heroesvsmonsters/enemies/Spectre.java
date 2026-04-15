package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class Spectre extends Monsters {

    public Spectre() {
        super("Spectre", 150, 0.35);

        getVitalite().addBonus(50);
        getForce().addBonus(10);
        getResistance().addBonus(5);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Consumable("Humanity"),
                new Titanites("Large Soul", 2)
        );
    }
}