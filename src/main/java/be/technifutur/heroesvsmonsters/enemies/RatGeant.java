package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;

import java.util.List;

public class RatGeant extends Boss {

    public RatGeant() {
        super("Giant Rat", 1200, 0.7);

        getVitalite().addBonus(500);
        getForce().addBonus(30);
        getResistance().addBonus(20);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Humanity")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }
}
