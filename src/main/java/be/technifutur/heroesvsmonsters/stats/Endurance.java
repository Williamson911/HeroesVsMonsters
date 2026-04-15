package be.technifutur.heroesvsmonsters.stats;

public class Endurance extends Stat {

    public Endurance(int baseValue) {
        super(baseValue);
    }

    public void consommer(int cost) {
        reduire(cost);
    }

    public void regenerer(int value) {
        augmenter(value);
    }
}