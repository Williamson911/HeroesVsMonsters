package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;
public class Virevent extends Boss {

    public Virevent() {
        super("Virevent", 15000, 1.0);

        getVitalite().addBonus(1200);
        getForce().addBonus(60);
        getResistance().addBonus(30);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Lord Soul Fragment")
        );
    }
}