package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;

import java.util.List;

public class Havel extends Boss {

    public Havel() {
        super("Havel le Roc", 3000, 0.5);

        getVitalite().addBonus(1000);
        getForce().addBonus(70);
        getResistance().addBonus(80);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Anneau de Havel")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }
}