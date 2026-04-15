package be.technifutur.heroesvsmonsters.enemies;
import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;
public class Seath extends Boss {

    public Seath() {
        super("Seath le Scaleless", 60000, 0.65);

        getVitalite().addBonus(4500);
        getForce().addBonus(110);
        getResistance().addBonus(90);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Lord Soul"),
                new Consumable("Âme de Seath")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Moonlight Greatsword", 140, "Greatsword", 10, 60, 40, 4),
                new Titanites("Blue Titanite Slab", 1)
        );
    }
}