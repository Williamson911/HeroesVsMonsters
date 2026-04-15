package be.technifutur.heroesvsmonsters.enemies;
import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class GolemCristalDore extends Boss {

    public GolemCristalDore() {
        super("Golden Crystal Golem", 2000, 0.5);

        getVitalite().addBonus(900);
        getForce().addBonus(45);
        getResistance().addBonus(60);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(); // souvent lié à events
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Blue Titanite Chunk", 2)
        );
    }
}