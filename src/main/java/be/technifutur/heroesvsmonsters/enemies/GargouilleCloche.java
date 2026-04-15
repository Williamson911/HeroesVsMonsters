package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class GargouilleCloche extends Boss {

    public GargouilleCloche() {
        super("Gargouilles de la cloche", 10000, 1.0);

        getVitalite().addBonus(900);
        getForce().addBonus(50);
        getResistance().addBonus(30);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Gargoyle Halberd", 85, "Halberd", 25, 10, 5, 3)
        );
    }
}