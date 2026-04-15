package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;

import java.util.List;

public class Hydre extends Monsters {
    public Hydre(String nom, int amesReward, double dropChance) {
        super(nom, amesReward, dropChance);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }
}
