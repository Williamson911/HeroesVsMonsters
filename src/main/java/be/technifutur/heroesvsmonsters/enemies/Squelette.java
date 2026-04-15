package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class Squelette extends Monsters {

    public Squelette() {
        super("Squelette", 120, 0.3);

        getVitalite().addBonus(60);
        getForce().addBonus(8);
        getResistance().addBonus(3);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Titanite Shard", 1)
        );
    }
}