package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class GolemDeFer extends Boss {

    public GolemDeFer() {
        super("Golem de Fer", 40000, 1.0);

        getVitalite().addBonus(2500);
        getForce().addBonus(90);
        getResistance().addBonus(60);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Golem Axe", 130, "Great Axe", 50, 0, 10, 6)
        );
    }
}