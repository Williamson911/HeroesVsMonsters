package be.technifutur.heroesvsmonsters.world;

import be.technifutur.heroesvsmonsters.enemies.*;

import java.util.ArrayList;
import java.util.List;

public class WorldFactory {

    public static WorldMap createWorld() {

        List<Zone> zones = new ArrayList<>();

        // ─────────────────────────────────────────────
        // 🏚️ 1. Undead Burg (début du jeu)
        // ─────────────────────────────────────────────
        Zone undeadBurg = new Zone(
                "Undead Burg",
                List.of(
                        new Zombie(),
                        new Squelette(),
                        new ChevalierNoir()
                ),
                new DemonTaureau(),   // boss début game
                0.75
        );

        // ─────────────────────────────────────────────
        // 🌉 2. Undead Parish (église + gargouilles)
        // ─────────────────────────────────────────────
        Zone undeadParish = new Zone(
                "Undead Parish",
                List.of(
                        new Squelette(),
                        new ChevalierNoir(),
                        new Zombie()
                ),
                new GargouilleCloche(), // Bell Gargoyles
                0.80
        );

        // ─────────────────────────────────────────────
        // ⚰️ 3. Catacombs
        // ─────────────────────────────────────────────
        Zone catacombs = new Zone(
                "Catacombes",
                List.of(
                        new Squelette(),
                        new Squelette(),
                        new Spectre()
                ),
                new Nito(), // Gravelord Nito (boss des morts-vivants)
                0.85
        );

        // ─────────────────────────────────────────────
        // 🕳️ 4. Depths (égouts / rats / slime)
        // ─────────────────────────────────────────────
        Zone depths = new Zone(
                "Profondeurs",
                List.of(
                        new Rat(),
                        new Zombie(),
                        new Squelette()
                ),
                new GapingDragon(),
                0.85
        );

        // ─────────────────────────────────────────────
        // 🔥 5. Anor Londo
        // ─────────────────────────────────────────────
        Zone anorLondo = new Zone(
                "Anor Londo",
                List.of(
                        new ChevalierNoir(),
                        new ChevalierEnArmure(),
                        new ArbaletrierArgent()
                ),
                new OrnsteinSmough(), // boss iconique
                0.90
        );

        // ─────────────────────────────────────────────
        // 🌑 6. New Londo Ruins
        // ─────────────────────────────────────────────
        Zone newLondo = new Zone(
                "New Londo Ruins",
                List.of(
                        new Spectre(),
                        new Spectre(),
                        new ChevalierTomb()
                ),
                new Quelaag(),
                0.90
        );

        // ─────────────────────────────────────────────
        // 🌲 7. Darkroot Garden
        // ─────────────────────────────────────────────
        Zone darkrootGarden = new Zone(
                "Darkroot Garden",
                List.of(
                        new Ent(),
                        new Squelette()

                ),
                new Sif(),
                0.90
        );
        // ─────────────────────────────────────────────
        // 🌲 7. Darkroot Garden
        // ─────────────────────────────────────────────
        Zone darkrootBassin = new Zone(
                "Darkroot Garden",
                List.of(
                        new Ent(),
                        new ChevalierNoir()

                ),
                new Hydre(),
                0.90
        );

        // ─────────────────────────────────────────────
        // 🔥 8. Demon Ruins
        // ─────────────────────────────────────────────
        Zone demonRuins = new Zone(
                "Demon Ruins",
                List.of(
                        new Demon(),
                        new LaveSlime(),
                        new DemonCapra()
                ),
                new CeaselessDischarge(),
                0.95
        );

        // ─────────────────────────────────────────────
        // 🌋 9. Kiln of the First Flame (fin du jeu)
        // ─────────────────────────────────────────────
        Zone kiln = new Zone(
                "Fourneau de la Première Flamme",
                List.of(
                        new ChevalierNoirElite(),
                        new ChevalierNoir(),
                        new Spectre()
                ),
                new Gwyn(),
                0.95
        );

        zones.add(undeadBurg);
        zones.add(undeadParish);
        zones.add(catacombs);
        zones.add(depths);
        zones.add(anorLondo);
        zones.add(newLondo);
        zones.add(darkrootGarden);
        zones.add(demonRuins);
        zones.add(kiln);

        return new WorldMap(zones);
    }
}