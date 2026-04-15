package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class DemonDuRefuge extends Boss {

    public DemonDuRefuge() {
        super("Démon du Refuge", 2000, 1.0);

        getVitalite().addBonus(600);
        getForce().addBonus(40);
        getResistance().addBonus(20);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of();
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Armes("Demon Great Hammer", 90, "Great Hammer", 30, 0, 5, 4)
        );
    }
}