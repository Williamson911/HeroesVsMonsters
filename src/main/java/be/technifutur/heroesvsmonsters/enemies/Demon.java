package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class Demon extends Monsters {

    public Demon() {
        super("Démon", 400, 0.6);

        getVitalite().addBonus(200);
        getForce().addBonus(45);
        getResistance().addBonus(30);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Demon Titanite", 1)
        );
    }
}
