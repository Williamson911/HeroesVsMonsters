package be.technifutur.heroesvsmonsters.items;

import be.technifutur.heroesvsmonsters.characters.Heroes;

public class Titanites extends Item {

    private final String nom;
    private final int bonusUpgrade; // bonus qu'elle apporte à l'amélioration d'arme

    // Constructeur sans argument → Titanite standard
    public Titanites() {
        this("Titanite Ordinaire", 1);
    }

    // Constructeur avec nom → pour les drops spéciaux
    public Titanites(String nom) {
        this(nom, 2);
    }

    public Titanites(String nom, int bonusUpgrade) {
        super(nom);
        this.nom = nom;
        this.bonusUpgrade = bonusUpgrade;
    }

    @Override
    public String getNom() { return nom; }

    public int getBonusUpgrade() { return bonusUpgrade; }

    @Override
    public int utiliser(Heroes hero) {
        // Les Titanites ne s'utilisent pas en combat
        System.out.println("Les Titanites servent à améliorer les armes, pas à utiliser en combat !");
        return 0;
    }
}