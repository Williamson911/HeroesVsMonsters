package be.technifutur.heroesvsmonsters.weapons;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.items.Item;

public class Armes extends Item {

    private final int degats;
    private final String type;
    private final int forceRequise;
    private final int dexteriteRequise;
    // Scaling : 0 = aucun, 1 = E, 2 = D, 3 = C, 4 = B, 5 = A, 6 = S
    private final int scalingForce;
    private final int scalingDexterite;

    public Armes(String nom, int degats, String type,
                 int forceRequise, int dexteriteRequise,
                 int scalingForce, int scalingDexterite) {
        super(nom);
        this.degats           = degats;
        this.type             = type;
        this.forceRequise     = forceRequise;
        this.dexteriteRequise = dexteriteRequise;
        this.scalingForce     = scalingForce;
        this.scalingDexterite = scalingDexterite;
    }

    /**
     * Dégâts réels = dégâts de base + bonus de scaling selon les stats du héros.
     */
    public int getDegatsReels(Heroes hero) {
        int bonus = 0;
        // Scaling Force
        bonus += (int)(hero.getForce().getValeur() * scalingMultiplier(scalingForce));
        // Scaling Dextérité
        bonus += (int)(hero.getDexterite().getValeur() * scalingMultiplier(scalingDexterite));
        return degats + bonus;
    }

    private double scalingMultiplier(int scaling) {
        return switch (scaling) {
            case 0 -> 0.0;  // aucun
            case 1 -> 0.1;  // E
            case 2 -> 0.2;  // D
            case 3 -> 0.4;  // C
            case 4 -> 0.6;  // B
            case 5 -> 0.8;  // A
            case 6 -> 1.0;  // S
            default -> 0.0;
        };
    }

    public int getDegats()            { return degats; }
    public String getType()           { return type; }
    public int getForceRequise()      { return forceRequise; }
    public int getDexteriteRequise()  { return dexteriteRequise; }

    @Override
    public int utiliser(Heroes hero) {
        return 0;
    }
}