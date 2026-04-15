package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class ArbaletrierArgent extends Monsters {

    public ArbaletrierArgent() {
        super("Arbalétrier Argent", 250, 0.5);

        getVitalite().addBonus(90);
        getForce().addBonus(25);
        getResistance().addBonus(10);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Arbalète Argent", 70, "Crossbow", 20, 15, 0, 2)
        );
    }
}