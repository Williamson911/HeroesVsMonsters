package be.technifutur.heroesvsmonsters.enemies;
import be.technifutur.heroesvsmonsters.items.Consumable;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;
public class PapillonClairDeLune extends Boss {
    public PapillonClairDeLune(String nom, int souls, double dropChance) {
        super("Papillon Clair de Lune", 10000, 0.7);
        getVitalite().addBonus(900);
        getForce().addBonus(60);
        getResistance().addBonus(30);
    }

    @Override
    protected List<Item> getGuaranteedDrops() {
        return List.of(
                new Consumable("Âme du Papillon")
        );
    }

    @Override
    protected List<Item> getPossibleDrops() {
        return List.of(
                new Titanites("Blue Titanite Chunk", 2),
                new Armes("Divine Ember", 0, "Upgrade", 0, 40, 10, 1)
        );
    }
}
