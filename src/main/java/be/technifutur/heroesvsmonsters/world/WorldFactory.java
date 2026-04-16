package be.technifutur.heroesvsmonsters.world;

import be.technifutur.heroesvsmonsters.enemies.*;

import java.util.ArrayList;
import java.util.List;

public class WorldFactory {

    public static WorldMap createWorld() {

        List<Zone> zones = new ArrayList<>();

        zones.add(new Zone("Refuge Nord",
                List.of(new Zombie()),
                new DemonDuRefuge(),
                0.7));

        zones.add(new Zone("Sanctuaire de Lige-feu",
                List.of(),
                null,
                0.0,
                true)); // hub + bonfire

        zones.add(new Zone("Village Mort-vivants",
                List.of(new Zombie(), new Rat()),
                new DemonTaureau(),
                0.75));

        zones.add(new Zone("Paroisse",
                List.of(new Squelette(), new ChevalierNoir()),
                new GargouilleCloche(),
                0.8));

        zones.add(new Zone("Darkroot Garden",
                List.of(new Ent(), new Squelette()),
                new Sif(),
                0.85));

        zones.add(new Zone("Darkroot Basin",
                List.of(new Ent()),
                new Hydre(), // 🔥 ajouté
                0.85));

        zones.add(new Zone("Profondeurs",
                List.of(new Rat(), new Zombie(), new RatGeant()),
                new DragonBeant(),
                0.85));

        zones.add(new Zone("Forteresse de Sen",
                List.of(new ChevalierEnArmure(), new DemonTitanite()),
                new GolemDeFer(),
                0.9));

        zones.add(new Zone("Anor Londo",
                List.of(new ChevalierNoir(), new ArbaletrierArgent()),
                new OrnsteinSmough(),
                0.9));

        zones.add(new Zone("New Londo Ruins",
                List.of(new Spectre()),
                null,
                0.9));

        zones.add(new Zone("Abysses",
                List.of(new Spectre()),
                new QuatreRois(),
                0.95));

        zones.add(new Zone("Catacombes",
                List.of(new Squelette()),
                null,
                0.9));

        zones.add(new Zone("Tombe des Géants",
                List.of(new ChevalierTomb()),
                new Nito(),
                0.95));

        zones.add(new Zone("Ruines Démoniaques",
                List.of(new Demon(), new LaveSlime()),
                new DemonCentipede(),
                0.9));

        zones.add(new Zone("Izalith",
                List.of(new Demon()),
                new FoyerDuChaos(),
                0.95));

        zones.add(new Zone("Archives du Duc",
                List.of(new ChevalierEnArmure()),
                null,
                0.9));

        zones.add(new Zone("Crystal Cave",
                List.of(),
                new Seath(),
                0.95));

        zones.add(new Zone("Kiln",
                List.of(new ChevalierNoirElite()),
                new Gwen(),
                1.0));

        return new WorldMap(zones);
    }
}