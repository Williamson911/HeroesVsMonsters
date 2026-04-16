package be.technifutur.heroesvsmonsters.utils;

public class SpriteLibrary {

    // ── API ───────────────────────────────────────────────────────

    public static void printEnemy(String name) {
        System.out.println(Cinematic.WHITE);
        display(enemySprite(name));
        System.out.println(Cinematic.RESET);
        Cinematic.pause(200);
    }

    public static void printZone(String name) {
        System.out.println(Cinematic.DIM + Cinematic.GREY);
        display(zoneSprite(name));
        System.out.println(Cinematic.RESET);
        Cinematic.pause(300);
    }

    private static void display(String sprite) {
        for (String line : sprite.split("\n")) {
            System.out.println("      " + line);
        }
    }

    // ── ROUTING ENNEMIS ───────────────────────────────────────────

    private static String enemySprite(String name) {
        return switch (name) {
            case "Zombie"                                    -> ZOMBIE;
            case "Squelette"                                 -> SQUELETTE;
            case "Spectre"                                   -> SPECTRE;
            case "Rat"                                       -> RAT;
            case "Rat Géant", "RatGeant"                    -> RAT_GEANT;
            case "Ent"                                       -> ENT;
            case "Drake"                                     -> DRAKE;
            case "Démon"                                     -> DEMON;
            case "Lave Slime", "LaveSlime"                  -> LAVE_SLIME;
            case "Démon Titanite", "DemonTitanite"          -> DEMON_TITANITE;
            case "Chevalier Noir", "ChevalierNoir"          -> CHEVALIER_NOIR;
            case "Chevalier en Armure", "ChevalierEnArmure" -> CHEVALIER_ARMURE;
            case "Chevalier Tombe", "ChevalierTomb"         -> CHEVALIER_TOMB;
            case "Chevalier Noir Elite", "ChevalierNoirElite" -> CHEVALIER_NOIR_ELITE;
            case "Arbalétrier Argent", "ArbaletrierArgent"  -> ARBALETRIER;
            case "Virevent"                                  -> VIREVENT;
            // BOSSES
            case "Démon du Refuge"                          -> BOSS_DEMON_REFUGE;
            case "Démon Taureau"                            -> BOSS_DEMON_TAUREAU;
            case "Gargouille Cloche", "GargouilleCloche"   -> BOSS_GARGOUILLEE;
            case "Dragon Béant", "DragonBeant"             -> BOSS_DRAGON_BEANT;
            case "Quelaag"                                   -> BOSS_QUELAAG;
            case "Golem de Fer", "GolemDeFer"              -> BOSS_GOLEM_FER;
            case "Ornstein & Smough", "OrnsteinSmough"     -> BOSS_ORNSTEIN_SMOUGH;
            case "Gwendoline", "Gwen"                       -> BOSS_GWEN;
            case "Nito"                                      -> BOSS_NITO;
            case "Priscilla"                                 -> BOSS_PRISCILLA;
            case "Seath", "Seath le Sans-Écailles"         -> BOSS_SEATH;
            case "Quatre Rois", "QuatreRois"               -> BOSS_QUATRE_ROIS;
            case "Sif"                                       -> BOSS_SIF;
            case "Hydre"                                     -> BOSS_HYDRE;
            case "Foyer du Chaos", "FoyerDuChaos"          -> BOSS_FOYER_CHAOS;
            case "Démon Capra", "DemonCapra"               -> BOSS_DEMON_CAPRA;
            case "Démon Centipède", "DemonCentipede"       -> BOSS_DEMON_CENTIPEDE;
            default                                          -> UNKNOWN;
        };
    }

    // ── ROUTING ZONES ─────────────────────────────────────────────

    private static String zoneSprite(String name) {
        return switch (name) {
            case "Refuge Nord"             -> ZONE_REFUGE_NORD;
            case "Sanctuaire de Lige-feu"  -> ZONE_SANCTUAIRE;
            case "Village Mort-vivants"    -> ZONE_VILLAGE;
            case "Paroisse"               -> ZONE_PAROISSE;
            case "Darkroot Garden"         -> ZONE_DARKROOT_GARDEN;
            case "Darkroot Basin"          -> ZONE_DARKROOT_BASIN;
            case "Profondeurs"             -> ZONE_PROFONDEURS;
            case "Forteresse de Sen"       -> ZONE_FORTERESSE_SEN;
            case "Anor Londo"              -> ZONE_ANOR_LONDO;
            case "New Londo Ruins"         -> ZONE_NEW_LONDO;
            case "Abysses"                 -> ZONE_ABYSSES;
            case "Catacombes"             -> ZONE_CATACOMBES;
            case "Tombe des Géants"        -> ZONE_TOMBE_GEANTS;
            case "Ruines Démoniaques"      -> ZONE_RUINES_DEMONIAQUES;
            case "Izalith"                 -> ZONE_IZALITH;
            case "Archives du Duc"         -> ZONE_ARCHIVES;
            case "Crystal Cave"            -> ZONE_CRYSTAL_CAVE;
            case "Kiln"                    -> ZONE_KILN;
            default                        -> ZONE_UNKNOWN;
        };
    }

    // ═══════════════════════════════════════════════════════════════
    //  SPRITES — ENNEMIS NORMAUX
    // ═══════════════════════════════════════════════════════════════

    private static final String ZOMBIE = join(
        "   ,---.   ",
        "  ( x x )  ",
        "   `---'   ",
        "    |~|    ",
        "   /| |\\  ",
        "  / | | \\ ",
        " /  |_|  \\"
    );

    private static final String SQUELETTE = join(
        "    .-.    ",
        "   (o o)   ",
        "    )-(    ",
        "    |_|    ",
        "    | |    ",
        "   / | \\  ",
        "  /  |  \\ "
    );

    private static final String SPECTRE = join(
        "    ___    ",
        "   /   \\  ",
        "  | * * |  ",
        "   \\___/  ",
        "   /~~~\\  ",
        "  /~~~~~\\ ",
        " /~~~~~~~\\"
    );

    private static final String RAT = join(
        "  /\\  .   ",
        " (  )--'  ",
        " (oo)     ",
        "  \\/      ",
        "  /\\      ",
        " /  \\     "
    );

    private static final String RAT_GEANT = join(
        " /\\/\\  .  ",
        "(    )--'  ",
        "(oo  )     ",
        " \\--/      ",
        " /  \\      ",
        "/    \\     "
    );

    private static final String ENT = join(
        "   _/Y\\_  ",
        "  / | | \\ ",
        " | _| |_ |",
        "  \\| | |/ ",
        "   _| |_  ",
        "  / | | \\ ",
        " /  | |  \\"
    );

    private static final String DRAKE = join(
        "   /\\/\\   ",
        "  ( oo )  ",
        "  / -- \\  ",
        "  \\    /  ",
        "   \\__/   ",
        "   /  \\   ",
        "  /    \\  "
    );

    private static final String DEMON = join(
        "  /\\/\\    ",
        " / oo \\   ",
        "( /--\\ )  ",
        " \\    /   ",
        "  \\--/    ",
        "  /  \\    ",
        " /    \\   "
    );

    private static final String LAVE_SLIME = join(
        "  ______   ",
        " /  **  \\  ",
        "| * ~~ * | ",
        " \\  **  /  ",
        "  \\/--\\/  "
    );

    private static final String DEMON_TITANITE = join(
        "  /\\  /\\  ",
        " / *  * \\ ",
        "( /----\\ )",
        " \\      / ",
        "  \\____/  ",
        "  /|  |\\  ",
        " /_|__|_\\ "
    );

    private static final String CHEVALIER_NOIR = join(
        "    [_]    ",
        "   /| |\\  ",
        "  (|o o|)  ",
        "   |===|   ",
        "   |___|   ",
        "   /| |\\  ",
        "  /_|_|_\\ "
    );

    private static final String CHEVALIER_ARMURE = join(
        "   [###]   ",
        "   |   |   ",
        "  (|+ +|)  ",
        "   |===|   ",
        "   |___|   ",
        "   /| |\\  ",
        "  / |_| \\ "
    );

    private static final String CHEVALIER_TOMB = join(
        "   [###]   ",
        "  /|   |\\  ",
        " ( | X | ) ",
        "   |---|   ",
        "   |___|   ",
        "   /| |\\  ",
        "  /_|_|_\\ "
    );

    private static final String CHEVALIER_NOIR_ELITE = join(
        "   _[H]_   ",
        "  /|   |\\  ",
        " ( |o o| ) ",
        "   |===|   ",
        "   |___|   ",
        "   /| |\\  ",
        "  /_|_|_\\ "
    );

    private static final String ARBALETRIER = join(
        "  _[_]_    ",
        "  |   |    ",
        " (| o |)   ",
        "  |___|    ",
        "  /|=|\\   ",
        " / |_| \\  "
    );

    private static final String VIREVENT = join(
        "  /~~~~~\\  ",
        " / * * * \\ ",
        "|  (   )  | ",
        " \\ * * * / ",
        "  \\_____/  ",
        "    |||     ",
        "   /|||\\   "
    );

    private static final String UNKNOWN = join(
        "  .-----.  ",
        "  | ? ? |  ",
        "  '-----'  ",
        "    | |    ",
        "   / | \\  "
    );

    // ═══════════════════════════════════════════════════════════════
    //  SPRITES — BOSS
    // ═══════════════════════════════════════════════════════════════

    private static final String BOSS_DEMON_REFUGE = join(
        "  /\\    /\\  ",
        " /  \\  /  \\ ",
        "| /oo\\/oo\\ |",
        "( \\      / )",
        " | [####] | ",
        "  \\______/  ",
        "  /|    |\\  ",
        " / |____| \\ "
    );

    private static final String BOSS_DEMON_TAUREAU = join(
        "  ) || (    ",
        "  /\\oo/\\   ",
        " / \\--/ \\   ",
        " \\      /   ",
        "  \\____/    ",
        "   |  |     ",
        "  /|  |\\   ",
        " /_|__|_\\  "
    );

    private static final String BOSS_GARGOUILLEE = join(
        "  /\\    /\\  ",
        " /  \\__/  \\ ",
        "( ->oo<-  ) ",
        " \\  --  /   ",
        "  \\ /\\ /   ",
        "   |  |     ",
        "  /|  |\\   ",
        " / |__| \\  "
    );

    private static final String BOSS_DRAGON_BEANT = join(
        "  _________  ",
        " /  o    o  \\",
        "/  /------\\  \\",
        "| |  [   ]  ||",
        " \\          / ",
        "  |   __   |  ",
        "  |__/  \\__|  ",
        "     |  |     "
    );

    private static final String BOSS_QUELAAG = join(
        "    .---.    ",
        "   ( * * )   ",
        "    '---'    ",
        "   /|   |\\  ",
        "  / |___| \\  ",
        " / /     \\ \\ ",
        "/  \\_____/  \\"
    );

    private static final String BOSS_GOLEM_FER = join(
        "  .-------.  ",
        "  |[#####]|  ",
        "  |o     o|  ",
        "  |-------|  ",
        "  |  [ ]  |  ",
        "  |       |  ",
        " /|       |\\ ",
        "/ |_______| \\"
    );

    private static final String BOSS_ORNSTEIN_SMOUGH = join(
        "  /\\    /\\   ",
        " /><\\  /><\\  ",
        "(|oo|  |oo|) ",
        " \\--/  \\--/  ",
        "  |      |   ",
        "  |  /\\  |   ",
        " /| /  \\ |\\ "
    );

    private static final String BOSS_GWEN = join(
        "     [^]     ",
        "    /   \\   ",
        "   /o   o\\  ",
        "  / \\   / \\ ",
        "  |  ---  |  ",
        "  |_______|  ",
        "   /|   |\\  ",
        "  / |___| \\ "
    );

    private static final String BOSS_NITO = join(
        "   .---.     ",
        "  ( X X )    ",
        "   '---'     ",
        "   \\|||/     ",
        "   (   )     ",
        "  /|   |\\   ",
        " ///     \\\\\\  "
    );

    private static final String BOSS_PRISCILLA = join(
        "  *     *    ",
        "   .---.     ",
        "  ( o o )    ",
        "   '---'     ",
        "   /   \\    ",
        "  /  |  \\   ",
        " /~~~~~~~\\  "
    );

    private static final String BOSS_SEATH = join(
        "  /~~~~\\    ",
        " / o  o \\   ",
        "/ /----\\ \\  ",
        "| |  --  | |",
        " \\/      \\/  ",
        "  |      |   ",
        " /|      |\\ "
    );

    private static final String BOSS_QUATRE_ROIS = join(
        " /\\  /\\  /\\  ",
        "/  \\/  \\/  \\ ",
        "\\ *  *  *  / ",
        " X--X--X--X  ",
        "/ *  *  *  \\ ",
        "\\__/\\__/\\__/ "
    );

    private static final String BOSS_SIF = join(
        "  /\\ /\\    ",
        " /  V  \\   ",
        "/ * oo  \\  ",
        "\\___/\\___\\ ",
        "   /    \\  ",
        "  /  /\\  \\ ",
        " /  /  \\  \\"
    );

    private static final String BOSS_HYDRE = join(
        " /\\ /\\ /\\  ",
        " \\/ \\/ \\/  ",
        "  \\  |  /   ",
        "   \\ | /    ",
        "    \\|/     ",
        "    /|\\     ",
        "   / | \\    "
    );

    private static final String BOSS_FOYER_CHAOS = join(
        "    *   *    ",
        "   /|\\ /|\\  ",
        "  / * * * \\  ",
        " /  *   *  \\ ",
        "|  /------\\  |",
        "|_/________\\_|"
    );

    private static final String BOSS_DEMON_CAPRA = join(
        "  ) /\\ (    ",
        "  |( oo)|   ",
        "  | -- |    ",
        "  \\    /    ",
        "   \\--/     ",
        "   |  |     ",
        "  /|  |\\   "
    );

    private static final String BOSS_DEMON_CENTIPEDE = join(
        "   .---.     ",
        "  /o   o\\   ",
        "  \\-----/   ",
        "   )   (     ",
        "  /|   |\\   ",
        "  \\|   |/   ",
        "   \\   /     ",
        "    \\ /      ",
        "     V       "
    );

    // ═══════════════════════════════════════════════════════════════
    //  SPRITES — ZONES
    // ═══════════════════════════════════════════════════════════════

    private static final String ZONE_REFUGE_NORD = join(
        "     ___________     ",
        "    |  ___   ___|    ",
        "    | |   | |        ",
        "    |_|___|_|___     ",
        "    |           |    ",
        "   /|___________|\\  ",
        "  /               \\ "
    );

    private static final String ZONE_SANCTUAIRE = join(
        "          *          ",
        "         \\|/         ",
        "       ---+---       ",
        "         /|\\         ",
        "          |          ",
        "    ______|______    ",
        "   /      |      \\  ",
        "  /________|_______\\ "
    );

    private static final String ZONE_VILLAGE = join(
        "  _  _  _  _  _  ",
        " | || || || || |  ",
        " |_||_||_||_||_|  ",
        "/________________\\ ",
        "|    ________    | ",
        "|___|        |___| "
    );

    private static final String ZONE_PAROISSE = join(
        "         /\\        ",
        "        /  \\       ",
        "       / ++ \\      ",
        "      /______\\     ",
        "     /   ||   \\    ",
        "    /    ||    \\   ",
        "   /_____|______\\  ",
        "   |     ||     |  ",
        "   |_____|_______|  "
    );

    private static final String ZONE_DARKROOT_GARDEN = join(
        "  Y   Y   Y   Y  ",
        " /|\\ /|\\ /|\\ /|\\ ",
        "/   X   X   X   \\ ",
        "|_________________|",
        "|                 |"
    );

    private static final String ZONE_DARKROOT_BASIN = join(
        "  ___________    ",
        " /           \\   ",
        "| ~  ~  ~  ~ |   ",
        "|~ ~  ~  ~ ~ |   ",
        " \\___________/   ",
        "  |         |    "
    );

    private static final String ZONE_PROFONDEURS = join(
        "_________________  ",
        "|   |       |   |  ",
        "|   |  ___  |   |  ",
        "|___|_/   \\_|___|  ",
        "    /       \\      ",
        "   |  _____  |     ",
        "   | |     | |     ",
        "   |_|_____|_|     "
    );

    private static final String ZONE_FORTERESSE_SEN = join(
        "  ___________   ",
        " |  /  |  \\  |  ",
        " | /   |   \\ |  ",
        " |/  __|__  \\|  ",
        " |_|       |_|  ",
        "   |  ___  |    ",
        "   |__|_|__|    "
    );

    private static final String ZONE_ANOR_LONDO = join(
        "  _           _   ",
        " / \\  .---.  / \\ ",
        "/   \\/     \\/   \\",
        "\\___|       |___/ ",
        "    |  ___  |     ",
        "   _| |   | |_    ",
        "  / | |   | | \\  ",
        " /__|_|___|_|__\\ "
    );

    private static final String ZONE_NEW_LONDO = join(
        "  . .   . .   ",
        " /|X|\\ /|X|\\ ",
        "/ |_| X |_| \\ ",
        "\\_|_|_X_|_|_/ ",
        "   |       |   ",
        "   |_______|   "
    );

    private static final String ZONE_ABYSSES = join(
        " \\           / ",
        "  \\         /  ",
        "   \\  . .  /   ",
        "    \\(   )/    ",
        "     \\   /     ",
        "      \\ /      ",
        "       V       ",
        "      / \\      ",
        "     /   \\     "
    );

    private static final String ZONE_CATACOMBES = join(
        " _________________  ",
        " |  [ ]    [ ]  |   ",
        " |   |      |   |   ",
        " |___|      |___|   ",
        "    |        |      ",
        "    | .----. |      ",
        "    | |    | |      ",
        "    |_|____|_|      "
    );

    private static final String ZONE_TOMBE_GEANTS = join(
        "  _   _   _   ",
        " ( ) ( ) ( )  ",
        " _|   |   |_  ",
        "/ |   |   | \\ ",
        "\\  \\  |  /   /",
        " \\__\\_|_/__/ "
    );

    private static final String ZONE_RUINES_DEMONIAQUES = join(
        "    *   *   *    ",
        "   /|\\ /|\\ /|\\  ",
        "  / | X | X | \\  ",
        " /__|___|___|__\\ ",
        " |              | ",
        " |   ________   | ",
        " |__|        |__| "
    );

    private static final String ZONE_IZALITH = join(
        "   *       *    ",
        "  /|\\     /|\\  ",
        " / | \\   / | \\ ",
        "/  |  \\ /  |  \\",
        "|  |   X   |   |",
        "|__|  / \\  |__|",
        "    |/   \\|    "
    );

    private static final String ZONE_ARCHIVES = join(
        "   _________    ",
        "  | ||||||| |   ",
        "  | ||||||| |   ",
        "  | |_____| |   ",
        "  |_________|   ",
        "  | |     | |   ",
        "  | |_____| |   ",
        "  |_________|   "
    );

    private static final String ZONE_CRYSTAL_CAVE = join(
        "  /\\    /\\   ",
        " /  \\  /  \\  ",
        "/ *  \\/  * \\ ",
        "\\    /\\    / ",
        " \\  / *\\  /  ",
        "  \\/    \\/   ",
        "  / \\  / \\   "
    );

    private static final String ZONE_KILN = join(
        "    _____     ",
        "   /     \\   ",
        "  /  * *  \\  ",
        " /    *    \\ ",
        "/___________\\",
        "|  |  |  |  |",
        "|  |  |  |  |",
        "|__|__|__|__|"
    );

    private static final String ZONE_UNKNOWN = join(
        "  .-------.  ",
        "  |  ???  |  ",
        "  '-------'  "
    );

    // ── UTILITAIRE ────────────────────────────────────────────────

    private static String join(String... lines) {
        return String.join("\n", lines);
    }
}
