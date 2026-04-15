package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;

import java.util.List;

public class DragonMortVivant extends Boss {

    public DragonMortVivant() {
        super("Undead Dragon", 3500, 0.6);

        getVitalite().addBonus(1800);
        getForce().addBonus(70);
        getResistance().addBonus(50);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Dragon Scale")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }
}
