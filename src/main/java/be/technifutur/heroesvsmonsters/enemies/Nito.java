package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Nito extends Boss {

    public Nito() {
        super("Gravelord Nito", 60000, 1.0);

        getVitalite().addBonus(4000);
        getForce().addBonus(120);
        getResistance().addBonus(80);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Lord Soul of Death"),
                new Armes("Death Scythe", 130, "Scythe", 40, 10, 20, 5)
        );
    }
}