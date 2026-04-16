package be.technifutur.heroesvsmonsters.utils;

import java.util.List;
import java.util.Random;

/**
 * Moteur d'affichage Dark Souls : slow-print, animations, écrans dramatiques.
 */
public class Cinematic {

    // ── ANSI ─────────────────────────────────────────────────────
    public static final String RED      = "\u001B[31m";
    public static final String GOLD     = "\u001B[33m";
    public static final String GREY     = "\u001B[90m";
    public static final String WHITE    = "\u001B[97m";
    public static final String BOLD     = "\u001B[1m";
    public static final String DIM      = "\u001B[2m";
    public static final String RESET    = "\u001B[0m";

    private static final Random random = new Random();
    private static final int    WIDTH  = 56;

    // ── UTILITAIRES ───────────────────────────────────────────────

    public static void pause(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    /** Affiche texte caractère par caractère. */
    public static void slowPrint(String text, int charDelayMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            if (c != ' ') pause(charDelayMs);
        }
        System.out.println();
    }

    /** Texte centré dans WIDTH colonnes. */
    private static void centered(String text) {
        int pad = Math.max(0, (WIDTH - text.length()) / 2);
        System.out.println(" ".repeat(pad) + text);
    }

    // ── INTRO D'OUVERTURE ─────────────────────────────────────────

    public static void openingIntro() {
        System.out.println("\n\n");
        pause(500);

        System.out.print(GREY);
        lore("Au commencement...", 50);
        pause(700);
        lore("", 0);
        lore("L'obscurité régnait.", 40);
        pause(500);
        lore("", 0);
        lore("Puis vint la Flamme.", 40);
        pause(400);
        lore("Et avec la Flamme, la Disparité.", 30);
        lore("La chaleur et le froid.  La vie et la mort.", 25);
        lore("La lumière... et les ténèbres.", 30);
        pause(700);
        lore("", 0);
        lore("Mais surtout...", 45);
        pause(500);
        System.out.print(RESET + GOLD + BOLD);
        slowPrint("          Les Âmes.", 60);
        System.out.print(RESET + GREY);
        pause(1000);
        lore("", 0);

        lore("Dans ces âges révolus, les Morts-vivants furent marqués", 22);
        lore("de la Marque Sombre.", 22);
        pause(300);
        lore("Condamnés à errer, à perdre leur raison,", 22);
        lore("à devenir... Creux.", 28);
        pause(600);
        lore("", 0);
        lore("Tu es l'un d'eux.", 40);
        pause(500);
        System.out.print(RESET + WHITE);
        slowPrint("          Et pourtant... tu te relèves encore.", 35);
        System.out.print(RESET);
        pause(1200);
        System.out.println("\n");
    }

    private static void lore(String text, int delay) {
        if (text.isEmpty()) { System.out.println(); return; }
        slowPrint("  " + text, delay);
    }

    // ── AREA NAME CARD ────────────────────────────────────────────

    public static void areaNameCard(String name) {
        System.out.println("\n\n");
        pause(500);
        System.out.print(GOLD + BOLD);
        centered("══════════════════════════════════════");
        pause(250);
        centered(name.toUpperCase());
        pause(250);
        centered("══════════════════════════════════════");
        System.out.println(RESET);
        pause(900);
    }

    // ── FOG GATE → BOSS ───────────────────────────────────────────

    public static void fogGate(String bossName) {
        System.out.println();
        pause(400);
        System.out.print(GREY + DIM);
        slowPrint("  Un mur de brouillard épais s'étend devant toi.", 28);
        pause(300);
        slowPrint("  Le sol tremble. Une chaleur putride irradie.", 28);
        pause(400);
        slowPrint("  Quelque chose d'immense respire de l'autre côté...", 30);
        System.out.println(RESET);
        pause(700);

        System.out.print(DIM + GREY);
        for (int i = 0; i < 4; i++) {
            System.out.println("  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            pause(140);
        }
        System.out.println(RESET);
        pause(500);

        bossNameCard(bossName);
    }

    // ── BOSS NAME CARD ────────────────────────────────────────────

    public static void bossNameCard(String name) {
        System.out.println(RED + BOLD);
        centered("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        pause(300);
        centered(name.toUpperCase());
        pause(300);
        centered("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(RESET);
        pause(800);
    }

    // ── YOU DIED ──────────────────────────────────────────────────

    public static void youDied() {
        pause(700);
        System.out.println("\n\n");
        System.out.print(RED + BOLD);
        centered("┌─────────────────────────────────────┐");
        pause(120);
        centered("│                                     │");
        pause(120);
        centered("│           Y O U   D I E D           │");
        pause(120);
        centered("│                                     │");
        pause(120);
        centered("└─────────────────────────────────────┘");
        System.out.println(RESET);
        pause(1400);
    }

    // ── BOSS VAINCU ───────────────────────────────────────────────

    public static void bossDefeated(String name) {
        pause(600);
        System.out.println("\n\n");
        System.out.print(GOLD + BOLD);
        for (int i = 0; i < 3; i++) { centered("✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦"); pause(180); }
        System.out.println();
        centered(name.toUpperCase() + "  —  VAINCU");
        System.out.println();
        for (int i = 0; i < 3; i++) { centered("✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦  ✦"); pause(180); }
        System.out.println(RESET);
        pause(1200);
    }

    // ── VICTOIRE (ennemi normal) ───────────────────────────────────

    public static void victoryAchieved() {
        pause(300);
        System.out.print(GOLD + BOLD);
        System.out.println();
        centered("════  ENNEMI TERRASSÉ  ════");
        System.out.println(RESET);
        pause(600);
    }

    // ── NARRATION D'ENTRÉE PAR ZONE ───────────────────────────────

    public static void describeZoneEntry(String zoneName) {
        System.out.println();
        pause(300);
        System.out.print(GREY);

        String desc = switch (zoneName) {
            case "Refuge Nord" -> """
                Les ruines du Refuge Nord s'étendent sous un ciel de cendre.
                Le vent porte l'odeur de la putréfaction et de la pierre brûlée.

                Des silhouettes vacillantes errent entre les décombres.
                Leurs yeux... vides. Leurs pas... mécaniques.

                Des Morts-vivants. Comme toi.
                Mais eux... sont devenus Creux.""";

            case "Sanctuaire de Lige-feu" -> """
                Un feu crépite dans le silence.
                Sa chaleur apaise la Marque Sombre qui brûle sur ta peau.

                Les morts ne s'approchent pas d'ici.
                Pour l'instant, tu es en sécurité.""";

            case "Village Mort-vivants" -> """
                Les ruelles sont jonchées de cadavres errants.
                Des maisons calcinées. Des cris... il y a longtemps.

                Les Creux se déplacent en meutes ici.
                Fais attention à chaque coin de rue.""";

            case "Paroisse" -> """
                Les cloches ne sonnent plus depuis longtemps.
                Mais quelque chose les a remplacées.

                Un gémissement grave et continu résonne dans les pierres.""";

            case "Catacombes" -> """
                L'air se raréfie. Même la lumière semble hésiter.
                Les os des anciens reposent dans ces tunnels.

                Ou plutôt... ils se relèvent.""";

            case "Profondeurs" -> """
                L'humidité colle à la peau. Une odeur de pourriture totale.
                Quelque chose de massive rampe dans l'obscurité.

                Ne reste pas immobile trop longtemps.""";

            case "Kiln" -> """
                La chaleur est insupportable.
                Le sol est fait de cendres... et d'os.

                Tu approches de la fin.
                Ou du commencement.""";

            default -> "Les ténèbres t'accueillent. Quelque chose rôde ici.";
        };

        for (String line : desc.split("\n")) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) { System.out.println(); pause(250); }
            else { slowPrint("  " + trimmed, 20); }
        }

        System.out.println(RESET);
        pause(500);
    }

    // ── TEXTES D'EXPLORATION ALÉATOIRES ──────────────────────────

    private static final List<String> REFUGE_NORD = List.of(
            "Des os craquent sous tes pas. L'air est lourd de pourriture.",
            "Une silhouette s'effondre au loin... puis se relève lentement.",
            "Tu aperçois une flamme vacillante à travers une fenêtre brisée.",
            "Le sol est jonché de cadavres. Certains bougent encore.",
            "Un gémissement s'élève quelque part. Difficile de dire d'où.",
            "Tes pas résonnent trop fort dans ce silence de mort.",
            "Une torche s'éteint dans le vent. L'obscurité avance.",
            "Les murs portent des traces de griffes. Récentes."
    );

    private static final List<String> GENERIC = List.of(
            "L'air pèse lourd ici. Quelque chose te surveille.",
            "Tu avances avec prudence. Rien de bon n'attend dans l'ombre.",
            "Un frisson. Pas de vent. Juste... quelque chose.",
            "La Marque Sombre pulse faiblement sur ta peau.",
            "Le silence ici n'est pas naturel."
    );

    public static void explorationText(String zoneName) {
        List<String> pool = switch (zoneName) {
            case "Refuge Nord" -> REFUGE_NORD;
            default            -> GENERIC;
        };
        System.out.println();
        System.out.print(DIM + GREY);
        slowPrint("  " + pool.get(random.nextInt(pool.size())), 18);
        System.out.println(RESET);
        pause(250);
    }

    // ── ÂMES GAGNÉES ─────────────────────────────────────────────

    public static void soulsGained(int amount) {
        System.out.print(GOLD);
        centered("  +" + amount + " ÂMES");
        System.out.println(RESET);
        pause(350);
    }
}
