package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DragonRouge extends Boss {

    public DragonRouge() {
        super("Dragon Rouge", 5000, 0.6);

        getVitalite().addBonus(2000);
        getForce().addBonus(90);
        getResistance().addBonus(60);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Drake Sword", 110, "Sword", 30, 10, 0, 3)
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }
}