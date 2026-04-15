package be.technifutur.heroesvsmonsters.items;

import be.technifutur.heroesvsmonsters.characters.Heroes;

public class Consumable extends Item {

    public Consumable(String nom) {
        super(nom);
    }

    @Override
    public int utiliser(Heroes hero) {
        return 10;
    }
}