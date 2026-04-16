package be.technifutur.heroesvsmonsters;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.combat.CombatEngine;
import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.utils.BonfireMenu;
import be.technifutur.heroesvsmonsters.utils.Cinematic;
import be.technifutur.heroesvsmonsters.utils.InputUtils;
import be.technifutur.heroesvsmonsters.utils.SpriteLibrary;
import be.technifutur.heroesvsmonsters.world.WorldFactory;
import be.technifutur.heroesvsmonsters.world.WorldMap;
import be.technifutur.heroesvsmonsters.world.Zone;

public class Main {

    public static void main(String[] args) {

        Cinematic.openingIntro();

        Heroes hero = (Heroes) CharacterCreator.createCharacter();

        WorldMap world = WorldFactory.createWorld();

        CombatEngine engine = new CombatEngine();

        while (hero.isAlive()) {

            Zone zone = world.getCurrentZone();

            // Narration à la première visite
            if (!zone.isVisited()) {
                Cinematic.areaNameCard(zone.getName());
                SpriteLibrary.printZone(zone.getName());
                Cinematic.describeZoneEntry(zone.getName());
                zone.markVisited();
            }

            hero.recupererAmes(zone.getName());

            System.out.println("\n🌍 Zone : " + zone.getName());

            boolean hasBoss = zone.getBoss() != null && !zone.isBossDefeated();
            boolean hasBonfire = zone.isBonfire();

            // Construire le menu dynamiquement
            int option = 1;
            System.out.println();
            System.out.println(option++ + ". Avancer");
            System.out.println(option++ + ". Reculer");
            System.out.println(option++ + ". Explorer");
            int bossOption    = hasBoss    ? option++ : -1;
            if (hasBoss)    System.out.println(bossOption    + ". Affronter le Boss (" + zone.getBoss().getNom() + ")");
            int bonfireOption = hasBonfire ? option++ : -1;
            if (hasBonfire) System.out.println(bonfireOption + ". 🔥 Feu de lien");
            int quitOption = option;
            System.out.println(quitOption + ". Quitter");

            int choice = InputUtils.readIntInRange(1, quitOption, "Action : ");

            if (choice == 1) {
                if (world.moveNextZone()) {
                    System.out.println("➡ Avancement");
                } else {
                    System.out.println("🚪 Fin du monde");
                }
            } else if (choice == 2) {
                if (world.movePreviousZone()) {
                    System.out.println("⬅ Retour");
                }
            } else if (choice == 3) {
                explore(hero, zone, engine);
            } else if (choice == bossOption) {
                Monsters boss = zone.getBoss();
                System.out.println("\n💀 BOSS : " + boss.getNom());
                boolean won = engine.start(hero, boss, zone.getName());
                if (won) zone.defeatBoss();
            } else if (choice == bonfireOption) {
                BonfireMenu.open(hero);
            } else if (choice == quitOption) {
                System.out.println("👋 Quitter");
                return;
            }
        }
    }

    private static void explore(Heroes hero, Zone zone, CombatEngine engine) {

        Cinematic.explorationText(zone.getName());

        if (zone.hasEncounter()) {

            Monsters monster = zone.randomMonster();

            System.out.println(Cinematic.GREY + "  Une présence hostile se rapproche..." + Cinematic.RESET);
            Cinematic.pause(400);
            System.out.println("\n⚔  " + monster.getNom().toUpperCase() + " apparaît !\n");

            engine.start(hero, monster, zone.getName());

        } else {
            System.out.println(Cinematic.DIM + Cinematic.GREY + "  ...Rien. Pour l'instant." + Cinematic.RESET);
            Cinematic.pause(300);
        }
    }

}