package be.technifutur.heroesvsmonsters.stats;

public abstract class Stat {

    private int baseValue;
    private int bonus;

    public Stat(int baseValue) {
        this.baseValue = Math.max(0, baseValue);
        this.bonus = 0;
    }

    public int getValeur() {
        return baseValue + bonus;
    }

    public void addBonus(int value) {
        bonus += value;
    }

    public void removeBonus(int value) {
        bonus -= value;
    }

    protected void setBase(int baseValue) {
        this.baseValue = Math.max(0, baseValue);
    }

    public void augmenter(int value) {
        setBase(baseValue + value);
    }

    public void reduire(int value) {
        setBase(baseValue - value);
    }
}