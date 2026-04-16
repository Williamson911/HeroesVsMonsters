package be.technifutur.heroesvsmonsters.items;

import be.technifutur.heroesvsmonsters.characters.Heroes;

public abstract class Item {
    private String nom;

    public Item(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract int utiliser(Heroes hero);
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return nom.equals(item.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}
