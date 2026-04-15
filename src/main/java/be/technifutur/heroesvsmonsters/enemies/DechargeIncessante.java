package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DechargeIncessante extends Boss {

    public DechargeIncessante() {
        super("Décharge Incessante", 20000, 0.7);

        getVitalite().addBonus(2000);
        getForce().addBonus(85);
        getResistance().addBonus(50);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Âme de la Décharge Incessante")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Large Titanite", 5),
                new Armes("Gold-Hemmed Set", 0, "Armor", 0, 10, 40, 1)
        );
    }
}
