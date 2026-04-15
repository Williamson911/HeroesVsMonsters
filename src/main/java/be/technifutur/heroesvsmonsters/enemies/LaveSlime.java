package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class LaveSlime extends Monsters {

    public LaveSlime() {
        super("Slime de Lave", 150, 0.5);

        getVitalite().addBonus(100);
        getForce().addBonus(20);
        getResistance().addBonus(40);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Red Titanite", 1)
        );
    }
}