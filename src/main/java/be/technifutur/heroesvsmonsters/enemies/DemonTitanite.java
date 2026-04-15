package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DemonTitanite extends Boss {

    public DemonTitanite() {
        super("Titanite Demon", 3000, 0.7);

        getVitalite().addBonus(1500);
        getForce().addBonus(85);
        getResistance().addBonus(60);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Titanites("Demon Titanite", 2)
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Titanite Catch Pole", 110, "Polearm", 30, 20, 10, 5)
        );
    }
}
