package be.technifutur.heroesvsmonsters.utils;

public class UIUtils {

    public static final String RESET = "\u001B[0m";

    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public static String buildBar(int current, int max, int size) {

        int filled = (int) ((double) current / max * size);

        StringBuilder bar = new StringBuilder();

        for (int i = 0; i < size; i++) {
            bar.append(i < filled ? "█" : "░");
        }

        return bar.toString();
    }

    public static String coloredBar(String color, int current, int max, int size) {
        return color + buildBar(current, max, size) + RESET;
    }
}