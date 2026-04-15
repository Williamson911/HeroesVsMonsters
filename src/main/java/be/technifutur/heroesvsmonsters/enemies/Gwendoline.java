package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;
public class Gwendoline extends Boss {

    public Gwendoline() {
        super("Gwendoline", 40000, 1.0);

        getVitalite().addBonus(2200);
        getForce().addBonus(80);
        getResistance().addBonus(60);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Soul of Light"),
                new Armes("Sun Bow", 100, "Bow", 30, 20, 15, 3)
        );
    }
}