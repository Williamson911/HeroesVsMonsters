package be.technifutur.heroesvsmonsters.stats;

public class Vitalite extends Stat {

    public Vitalite(int baseValue) {
        super(baseValue);
    }

    public void heal(int value) {
        augmenter(value);
    }

    public void takeDamage(int value) {
        reduire(value);
    }
}