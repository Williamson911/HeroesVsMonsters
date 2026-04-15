package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class Ent extends Monsters {

    public Ent() {
        super("Ent", 200, 0.5);

        getVitalite().addBonus(120);
        getForce().addBonus(20);
        getResistance().addBonus(15);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Green Titanite", 1)
        );
    }
}