package be.technifutur.heroesvsmonsters.enemies;
import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;
public class QuatreRois extends Boss {
    public QuatreRois() {
        super("Quatre Rois", 60000, 0.6);

        getVitalite().addBonus(4200);
        getForce().addBonus(120);
        getResistance().addBonus(90);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Lord Soul"),
                new Consumable("Âme des Quatre Rois")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Dark Hand", 110, "Fist", 20, 40, 30, 3)
        );
    }
}
