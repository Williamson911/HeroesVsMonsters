package be.technifutur.heroesvsmonsters.enemies;
import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class FoyerDuChaos extends Boss {

    public FoyerDuChaos() {
        super("Foyer du Chaos", 60000, 0.5);

        getVitalite().addBonus(5000);
        getForce().addBonus(120);
        getResistance().addBonus(80);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Lord Soul"),
                new Consumable("Âme du Foyer du Chaos")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Red Titanite Slab", 1)
        );
    }
}