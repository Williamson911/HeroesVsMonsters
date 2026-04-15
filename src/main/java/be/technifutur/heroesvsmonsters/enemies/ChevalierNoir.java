package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class ChevalierNoir extends Monsters {

    public ChevalierNoir() {
        super("Chevalier Noir", 1200, 0.5);

        getForce().addBonus(25);
        getResistance().addBonus(15);
        getVitalite().addBonus(300);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Black Knight Sword", 80, "Greatsword", 20, 10, 5, 2),
                new Titanites("Titanite Chunk", 5)
        );
    }
}