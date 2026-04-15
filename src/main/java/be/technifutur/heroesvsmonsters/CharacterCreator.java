package be.technifutur.heroesvsmonsters;

import be.technifutur.heroesvsmonsters.characters.*;
import be.technifutur.heroesvsmonsters.stats.*;
import be.technifutur.heroesvsmonsters.utils.InputUtils;

import java.util.Arrays;
import java.util.Random;

public class CharacterCreator {

    private static final Random random = new Random();

    public static Personnage createCharacter() {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     CRÉATION DE PERSONNAGE RPG       ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // ── Nom ─────────────────────────────
        String name = InputUtils.readString("Entrez le nom de votre personnage : ");

        // ── Classe ──────────────────────────
        Personnage personnage = chooseClass(name);

        // ── Stats ───────────────────────────
        System.out.println("\n══ GÉNÉRATION DES STATISTIQUES ══");
        System.out.println("Méthode : 4d6, on garde les 3 meilleurs\n");

        int vitalite     = rollStat("Vitalité");
        int endurance    = rollStat("Endurance");
        int force        = rollStat("Force");
        int dexterite    = rollStat("Dextérité");
        int intelligence = rollStat("Intelligence");
        int resistance   = rollStat("Résistance");

        personnage.setStats(
                new Vitalite(vitalite),
                new Endurance(endurance),
                new Force(force),
                new Dexterite(dexterite),
                new Intelligence(intelligence),
                new Resistance(resistance)
        );

        printCharacterSheet(personnage);

        return personnage;
    }

    // ─── Lancer de dés ─────────────────────────────

    private static int rollStat(String statName) {

        int[] rolls = new int[4];

        for (int i = 0; i < 4; i++) {
            rolls[i] = random.nextInt(6) + 1;
        }

        Arrays.sort(rolls);

        int total = rolls[1] + rolls[2] + rolls[3];

        System.out.printf(
                "  %-14s: %s → ignore %d → total : %d%n",
                statName,
                Arrays.toString(rolls),
                rolls[0],
                total
        );

        return total;
    }

    // ─── Choix classe ─────────────────────────────

    private static Personnage chooseClass(String name) {

        System.out.println("Choisissez votre classe :");
        System.out.println("  1. Chevalier");
        System.out.println("  2. Guerrier");
        System.out.println("  3. Voleur");
        System.out.println("  4. Samouraï");
        System.out.println("  5. Aventurier");
        System.out.println("  6. Bandit");
        System.out.println("  7. Héros");

        System.out.print("\nVotre choix : ");

        int choice = InputUtils.menu(
                "Choisissez votre classe",
                "Chevalier",
                "Guerrier",
                "Voleur",
                "Samouraï",
                "Aventurier",
                "Bandit",
                "Héros"
        );

        return switch (choice) {
            case 1 -> new Chevalier(name);
            case 2 -> new Guerrier(name);
            case 3 -> new Voleur(name);
            case 4 -> new Samourai(name);
            case 5 -> new Aventurier(name);
            case 6 -> new Bandit(name);
            default -> throw new IllegalStateException("Classe invalide");
        };
    }

    // ─── Fiche personnage ─────────────────────────

    private static void printCharacterSheet(Personnage p) {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.printf("║ %-36s ║%n",
                p.getNom() + " — " + p.getClass().getSimpleName());
        System.out.println("╠══════════════════════════════════════╣");

        System.out.printf("║ Vitalité      : %-19d ║%n", p.getVitalite().getValeur());
        System.out.printf("║ Endurance     : %-19d ║%n", p.getEndurance().getValeur());
        System.out.printf("║ Force         : %-19d ║%n", p.getForce().getValeur());
        System.out.printf("║ Dextérité     : %-19d ║%n", p.getDexterite().getValeur());
        System.out.printf("║ Intelligence  : %-19d ║%n", p.getIntelligence().getValeur());
        System.out.printf("║ Résistance    : %-19d ║%n", p.getResistance().getValeur());

        System.out.println("╚══════════════════════════════════════╝");
    }
}