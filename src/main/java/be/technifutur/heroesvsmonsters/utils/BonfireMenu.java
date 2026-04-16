package be.technifutur.heroesvsmonsters.utils;

import be.technifutur.heroesvsmonsters.characters.Heroes;

public class BonfireMenu {

    private static final int STAT_GAIN = 5;

    public static void open(Heroes hero) {

        System.out.println("\n🔥════════════════════════════🔥");
        System.out.println("         FEU DE LIEN");
        System.out.println("🔥════════════════════════════🔥");

        boolean staying = true;

        while (staying) {

            System.out.printf("%nNiveau : %d   |   Âmes : %d%n", hero.getLevel(), hero.getAmes());

            int choice = InputUtils.menu("Feu de lien",
                    "Augmenter de niveau (" + hero.getLevelUpCost() + " âmes)",
                    "Se reposer (restaurer HP / Stamina)",
                    "Voir les statistiques",
                    "Quitter le feu"
            );

            switch (choice) {
                case 1 -> levelUp(hero);
                case 2 -> rest(hero);
                case 3 -> showStats(hero);
                case 4 -> staying = false;
            }
        }
    }

    // ─────────────────────────────────────────────
    // LEVEL UP
    // ─────────────────────────────────────────────
    private static void levelUp(Heroes hero) {

        if (!hero.canLevelUp()) {
            System.out.printf("❌ Pas assez d'âmes ! (Requis : %d, possédées : %d)%n",
                    hero.getLevelUpCost(), hero.getAmes());
            return;
        }

        int choice = InputUtils.menu("Quelle statistique augmenter ? (+" + STAT_GAIN + ")",
                "Vitalité       [HP max : "       + hero.getVitalite().getMax()      + "]",
                "Endurance      [Stamina max : "  + hero.getEndurance().getMax()     + "]",
                "Force          ["                + hero.getForce().getValeur()       + "]",
                "Dextérité      ["                + hero.getDexterite().getValeur()   + "]",
                "Intelligence   ["                + hero.getIntelligence().getValeur()+ "]",
                "Résistance     ["                + hero.getResistance().getValeur()  + "]",
                "Annuler"
        );

        if (choice == 7) return;

        hero.increaseLevel();

        switch (choice) {
            case 1 -> hero.getVitalite().addBonus(STAT_GAIN);
            case 2 -> hero.getEndurance().addBonus(STAT_GAIN);
            case 3 -> hero.getForce().addBonus(STAT_GAIN);
            case 4 -> hero.getDexterite().addBonus(STAT_GAIN);
            case 5 -> hero.getIntelligence().addBonus(STAT_GAIN);
            case 6 -> hero.getResistance().addBonus(STAT_GAIN);
        }

        System.out.printf("✨ Niveau %d atteint !%n", hero.getLevel());
    }

    // ─────────────────────────────────────────────
    // REPOS
    // ─────────────────────────────────────────────
    private static void rest(Heroes hero) {
        hero.getVitalite().reset();
        hero.getEndurance().reset();
        System.out.println("💤 Vous vous reposez... HP et Stamina entièrement restaurés.");
    }

    // ─────────────────────────────────────────────
    // STATS
    // ─────────────────────────────────────────────
    private static void showStats(Heroes hero) {

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.printf( "║ %-36s ║%n",
                hero.getNom() + " — Niv." + hero.getLevel());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║ Vitalité      : %-5d / %-12d  ║%n",
                hero.getVitalite().getValeur(), hero.getVitalite().getMax());
        System.out.printf( "║ Endurance     : %-5d / %-12d  ║%n",
                hero.getEndurance().getCurrent(), hero.getEndurance().getMax());
        System.out.printf( "║ Force         : %-19d  ║%n", hero.getForce().getValeur());
        System.out.printf( "║ Dextérité     : %-19d  ║%n", hero.getDexterite().getValeur());
        System.out.printf( "║ Intelligence  : %-19d  ║%n", hero.getIntelligence().getValeur());
        System.out.printf( "║ Résistance    : %-19d  ║%n", hero.getResistance().getValeur());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf( "║ Âmes          : %-19d  ║%n", hero.getAmes());
        System.out.printf( "║ Prochain niv. : %-19d  ║%n", hero.getLevelUpCost());
        System.out.println("╚══════════════════════════════════════╝");
    }
}
