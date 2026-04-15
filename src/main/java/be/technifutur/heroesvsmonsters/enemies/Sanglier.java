package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;

import java.util.List;

public class Sanglier extends Boss {

    public Sanglier() {
        super("Sanglier Blindé", 1500, 0.6);

        getVitalite().addBonus(600);
        getForce().addBonus(40);
        getResistance().addBonus(50);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Casque Sanglier")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }
}