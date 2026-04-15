package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DemonErrant extends Boss {

    public DemonErrant() {
        super("Démon Errant", 20000, 0.6);

        getVitalite().addBonus(1800);
        getForce().addBonus(75);
        getResistance().addBonus(45);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Âme du Démon Errant")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Demon Catalyst", 95, "Catalyst", 0, 30, 25, 2),
                new Titanites("Demon Titanite", 2)
        );
    }
}
