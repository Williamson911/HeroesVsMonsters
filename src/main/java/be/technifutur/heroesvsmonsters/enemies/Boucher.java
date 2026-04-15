package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Boucher extends Boss {

    public Boucher() {
        super("Boucher", 1800, 0.6);

        getVitalite().addBonus(700);
        getForce().addBonus(55);
        getResistance().addBonus(30);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Butcher Sack")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Butcher Knife", 120, "Greataxe", 40, 10, 0, 6)
        );
    }
}