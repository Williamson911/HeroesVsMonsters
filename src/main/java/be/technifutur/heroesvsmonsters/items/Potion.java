package be.technifutur.heroesvsmonsters.items;

import be.technifutur.heroesvsmonsters.characters.Heroes;

public abstract class Potion extends Item {

    public Potion(String nom) {
        super(nom);
    }

    @Override
    public abstract int utiliser(Heroes hero);
}