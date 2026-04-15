package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class Drake extends Monsters {

    public Drake() {
        super("Drake", 1500, 0.5);

        getVitalite().addBonus(400);
        getForce().addBonus(35);
        getResistance().addBonus(20);
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Armes("Griffe de Drake", 90, "Claw", 25, 15, 4, 3)
        );
    }
}