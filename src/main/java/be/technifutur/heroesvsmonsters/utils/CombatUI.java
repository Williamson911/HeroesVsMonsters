package be.technifutur.heroesvsmonsters.utils;

public class CombatUI {

    // ─────────────────────────────
    // UTIL
    // ─────────────────────────────
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    // ─────────────────────────────
    // ACTION FEEDBACK
    // ─────────────────────────────
    public static void actionFeedback(String actionName) {
        System.out.println("\n⚡ " + actionName + " !");
        sleep(150);
    }

    // ─────────────────────────────
    // HIT EFFECT
    // ─────────────────────────────
    public static void hitEffect(int dmg) {
        System.out.println("\u001B[31m-" + dmg + " HP\u001B[0m");
        sleep(120);
    }

    // ─────────────────────────────
    // BOSS INTRO
    // ─────────────────────────────
    public static void bossIntro(String name) {
        System.out.println("\n........");
        sleep(400);
        System.out.println("💀 " + name.toUpperCase() + " APPARAÎT !");
        sleep(300);
    }

    // ─────────────────────────────
    // VICTORY
    // ─────────────────────────────
    public static void victoryAnimation() {
        Cinematic.victoryAchieved();
    }

    public static void bossVictoryAnimation(String bossName) {
        Cinematic.bossDefeated(bossName);
    }

    // ─────────────────────────────
    // DEATH
    // ─────────────────────────────
    public static void deathAnimation() {
        Cinematic.youDied();
    }

    public static void monsterAttack(String monsterName) {
        System.out.println();
        sleep(150);
        System.out.println("⚠ " + monsterName.toUpperCase() + " attaque !");
        sleep(150);
    }
    public static final String GREY = "\u001B[90m";
    public static final String RESET = "\u001B[0m";
}
