package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Priscilla extends Boss {

    public Priscilla() {
        super("Priscilla", 30000, 1.0);

        getVitalite().addBonus(1800);
        getForce().addBonus(75);
        getResistance().addBonus(50);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Lifehunt Scythe", 115, "Scythe", 35, 25, 10, 4)
        );
    }
}