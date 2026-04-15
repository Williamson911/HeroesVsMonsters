package be.technifutur.heroesvsmonsters.world;

import be.technifutur.heroesvsmonsters.enemies.*;

import java.util.List;

public class WorldBuilder {

    public static WorldMap createWorld() {

        // 💀 Cimetière → Squelettes basiques
        Zone graveyard = new Zone(
                "Cimetière",
                List.of(new Squelette(), new Squelette()),
                null,
                0.7
        );

        Zone catacombs = new Zone(
                "Catacombes",
                List.of(new Squelette()),
                null,
                0.8
        );

        return new WorldMap(List.of(graveyard, catacombs));
    }
}