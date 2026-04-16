package be.technifutur.heroesvsmonsters.items;

import be.technifutur.heroesvsmonsters.characters.Heroes;

public class PotionMana extends Potion {

    private final int mana;

    public PotionMana(int mana) {
        super("Potion de mana");
        this.mana = mana;
    }

    @Override
    public int utiliser(Heroes hero) {

        hero.getIntelligence().regen(mana);

        return mana;
    }
}