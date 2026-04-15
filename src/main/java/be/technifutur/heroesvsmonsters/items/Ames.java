package be.technifutur.heroesvsmonsters.items;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.items.Item;

public class Ames extends Item {

    private final int value;

    public Ames(String nom, int value) {
        super(nom);
        this.value = value;
    }

    @Override
    public int utiliser(Heroes hero) {
        hero.gagnerAmes(value);
        return 0; // pas de heal
    }
}