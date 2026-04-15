package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Sif extends Boss {

    public Sif() {
        super("Grand Loup Gris Sif", 40000, 0.65);

        // 🐺 Boss agile, rapide, équilibré
        getVitalite().addBonus(2500);
        getForce().addBonus(95);
        getResistance().addBonus(60);
        getDexterite().addBonus(40); // important pour ton système combat
    }

    // 🎯 Loot fixe (toujours)
    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Âme de Sif")
        );
    }

    // 🎲 Loot aléatoire
    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes(
                        "Greatsword of Artorias",
                        130,
                        "Greatsword",
                        40, // force
                        20, // dex
                        20, // int
                        5   // endurance
                ),
                new Armes(
                        "Shield of Artorias",
                        0,
                        "Shield",
                        0,
                        10,
                        30,
                        10
                ),
                new Titanites("Twinkling Titanite", 2)
        );
    }
}