package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;
public class DemonPyrosage extends Boss {

    public DemonPyrosage() {
        super("Démon Pyrosage", 20000, 0.6);

        getVitalite().addBonus(1900);
        getForce().addBonus(80);
        getResistance().addBonus(45);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Âme du Démon Pyrosage")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Demon Catalyst", 100, "Catalyst", 0, 35, 30, 2),
                new Titanites("Demon Titanite", 2)
        );
    }
}