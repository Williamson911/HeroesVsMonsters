package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class OrnsteinSmough extends Boss {

    public OrnsteinSmough() {
        super("Ornstein & Smough", 50000, 1.0);

        getVitalite().addBonus(3000);
        getForce().addBonus(100);
        getResistance().addBonus(70);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Dragonslayer Spear", 140, "Spear", 45, 25, 10, 5)
        );
    }
}
