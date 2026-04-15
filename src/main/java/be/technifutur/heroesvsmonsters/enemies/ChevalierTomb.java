package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class ChevalierTomb extends Monsters {

    public ChevalierTomb() {
        super("Chevalier des Tombes", 300, 0.5);

        getVitalite().addBonus(150);
        getForce().addBonus(35);
        getResistance().addBonus(20);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("White Titanite", 2)
        );
    }
}