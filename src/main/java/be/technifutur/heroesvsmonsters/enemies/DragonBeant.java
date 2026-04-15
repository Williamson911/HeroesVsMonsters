package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DragonBeant extends Boss {

    public DragonBeant() {
        super("Dragon Béant", 25000, 1.0);

        getVitalite().addBonus(2000);
        getForce().addBonus(80);
        getResistance().addBonus(40);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Key of Depths"),
                new Armes("Dragon Fang", 120, "Sword", 40, 15, 5, 5)
        );
    }
}