package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Sif extends Boss {

    public Sif() {
        super("Sif, le Loup Géant", 2500, 0.6);

        getVitalite().addBonus(800);
        getForce().addBonus(45);
        getResistance().addBonus(25);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes(
                        "Grande Épée de Sif",
                        120,
                        "Ultra Greatsword",
                        30,
                        15,
                        5,
                        3
                )
        );
    }

    @Override
    protected void phaseTwo() {
        // futur : attaque désespérée quand HP < 30%
        getForce().addBonus(20);
    }
}