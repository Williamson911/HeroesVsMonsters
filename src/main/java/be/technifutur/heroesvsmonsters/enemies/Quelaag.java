package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Quelaag extends Boss {

    public Quelaag() {
        super("Quelaag", 20000, 1.0);

        getVitalite().addBonus(1800);
        getForce().addBonus(70);
        getResistance().addBonus(30);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Chaos Blade", 110, "Katana", 35, 20, 5, 3)
        );
    }
}
