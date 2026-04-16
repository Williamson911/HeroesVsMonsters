package be.technifutur.heroesvsmonsters.items;

import be.technifutur.heroesvsmonsters.characters.Heroes;

public class PotionSoin extends Potion {

    private final int heal;

    public PotionSoin(int heal) {
        super("Potion de soin");
        this.heal = heal;
    }

    @Override
    public int utiliser(Heroes hero) {

        hero.heal(heal);

        return heal;
    }
}