package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Gwen extends Boss {

    public Gwen() {
        super("Gwen, Lord of Cinder", 70000, 1.0);

        getVitalite().addBonus(5000);
        getForce().addBonus(150);
        getResistance().addBonus(100);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Great Lord Sword", 160, "Greatsword", 60, 20, 10, 6),
                new Consumable("Lord Soul of Cinder")
        );
    }
}