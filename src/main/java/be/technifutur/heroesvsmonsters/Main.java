package be.technifutur.heroesvsmonsters;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.combat.CombatEngine;
import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.utils.InputUtils;
import be.technifutur.heroesvsmonsters.world.WorldFactory;
import be.technifutur.heroesvsmonsters.world.WorldMap;
import be.technifutur.heroesvsmonsters.world.Zone;

public class Main {

    public static void main(String[] args) {

        Heroes hero = (Heroes) CharacterCreator.createCharacter();

        WorldMap world = WorldFactory.createWorld();

        CombatEngine engine = new CombatEngine();

        while (hero.isAlive()) {

            Zone zone = world.getCurrentZone();
            hero.recupererAmes(zone.getName());

            System.out.println("\n🌍 Zone : " + zone.getName());

            System.out.println("""
                    1. Avancer
                    2. Reculer
                    3. Explorer
                    4. Quitter
                    """);

            int choice = InputUtils.readIntInRange(1, 4, "Action : ");

            switch (choice) {

                case 1 -> {
                    if (world.moveNextZone()) {
                        System.out.println("➡ Avancement");
                    } else {
                        System.out.println("🚪 Fin du monde");
                    }
                }

                case 2 -> {
                    if (world.movePreviousZone()) {
                        System.out.println("⬅ Retour");
                    }
                }

                case 3 -> explore(hero, zone, engine);

                case 4 -> {
                    System.out.println("👋 Quitter");
                    return;
                }
            }
        }
    }

    private static void explore(Heroes hero, Zone zone, CombatEngine engine) {

        System.out.println("🔍 Exploration...");

        if (zone.hasEncounter()) {

            Monsters monster = zone.randomMonster();

            System.out.println("⚔ Rencontre : " + monster.getNom());

            engine.start(hero, monster, zone.getName());

        } else {
            System.out.println("🌿 Rien trouvé");
        }
    }

}