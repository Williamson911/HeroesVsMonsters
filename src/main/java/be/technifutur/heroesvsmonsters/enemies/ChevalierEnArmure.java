package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class ChevalierEnArmure extends Monsters {

    public ChevalierEnArmure() {
        super("Chevalier en Armure", 600, 0.4);

        getVitalite().addBonus(180);
        getForce().addBonus(20);
        getResistance().addBonus(15);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Lance de Chevalier", 50, "Spear", 15, 8, 3, 1),
                new Armes("Knight Shield", 20, "Shield", 5, 15, 0, 1),
                new Titanites("Titanite Shard", 1)
        );
    }
}