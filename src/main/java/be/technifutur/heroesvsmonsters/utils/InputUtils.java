package be.technifutur.heroesvsmonsters.utils;

import java.util.Scanner;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    // ─────────────────────────────
    // STRING INPUT
    // ─────────────────────────────
    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt + " ");

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("⚠ Entrée vide interdite.");
        }
    }

    // ─────────────────────────────
    // INT INPUT SAFE
    // ─────────────────────────────
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt + " ");

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Veuillez entrer un nombre valide.");
            }
        }
    }

    // ─────────────────────────────
    // INT IN RANGE (RPG CLASSIC)
    // ─────────────────────────────
    public static int readIntInRange(int min, int max, String prompt) {
        while (true) {
            int value = readInt(prompt);

            if (value >= min && value <= max) {
                return value;
            }

            System.out.printf("⚠ Choisissez entre %d et %d%n", min, max);
        }
    }

    // ─────────────────────────────
    // MENU SELECTOR (RPG STYLE)
    // ─────────────────────────────
    public static int menu(String title, String... options) {

        System.out.println("\n══ " + title + " ══");

        for (int i = 0; i < options.length; i++) {
            System.out.printf("  %d. %s%n", i + 1, options[i]);
        }

        return readIntInRange(1, options.length, "Votre choix : ");
    }

    // ─────────────────────────────
    // YES / NO CONFIRMATION
    // ─────────────────────────────
    public static boolean confirm(String question) {

        while (true) {
            System.out.print(question + " (y/n) : ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                return true;
            }

            if (input.equals("n") || input.equals("no")) {
                return false;
            }

            System.out.println("⚠ Répondez par y ou n.");
        }
    }
}