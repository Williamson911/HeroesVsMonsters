package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DemonCapra extends Boss {

    public DemonCapra() {
        super("Démon Capra", 6000, 1.0);

        getVitalite().addBonus(1200);
        getForce().addBonus(65);
        getResistance().addBonus(35);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Capra Blade", 95, "Greatsword", 30, 10, 5, 4)
        );
    }
}