package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;

import java.util.List;

public class GrandFelin extends Boss {

    public GrandFelin() {
        super("Great Feline", 1500, 0.6);

        getVitalite().addBonus(600);
        getForce().addBonus(40);
        getDexterite().addBonus(35);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Consumable("Humanity")
        );
    }
}