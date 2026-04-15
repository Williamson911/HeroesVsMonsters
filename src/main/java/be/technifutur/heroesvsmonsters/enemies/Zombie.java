package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;

public class Zombie extends Monsters {

    public Zombie() {
        super("Zombie", 80, 0.3);

        getForce().addBonus(5);
        getVitalite().addBonus(40);
        getResistance().addBonus(2);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Titanite Shard", 1),
                new Consumable("Soul fragment")
        );
    }
}