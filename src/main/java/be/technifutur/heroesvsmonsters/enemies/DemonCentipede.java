package be.technifutur.heroesvsmonsters.enemies;
import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;

import java.util.List;
public class DemonCentipede extends Boss {

    public DemonCentipede() {
        super("Démon Centipède", 20000, 0.65);

        getVitalite().addBonus(2100);
        getForce().addBonus(90);
        getResistance().addBonus(55);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Anneau de Lave")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Red Titanite Chunk", 3)
        );
    }
}