package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class ChevalierBernice extends Boss {

    public ChevalierBernice() {
        super("Berenike Knight", 2500, 0.7);

        getVitalite().addBonus(1200);
        getForce().addBonus(70);
        getResistance().addBonus(80);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Tower Shield", 0, "Shield", 0, 10, 0, 20)
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Greatsword", 130, "Greatsword", 40, 10, 0, 6),
                new Armes("Greataxe", 140, "Greataxe", 45, 8, 0, 8),
                new Titanites("Titanite Chunk", 3)
        );
    }
}
