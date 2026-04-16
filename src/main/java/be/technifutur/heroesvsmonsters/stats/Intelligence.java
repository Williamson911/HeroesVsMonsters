package be.technifutur.heroesvsmonsters.stats;

public class Intelligence extends Stat{
    private int current;

    public Intelligence(int base) {
        super(base);
        this.current = base;
    }

    public int getCurrent() { return current; }

    public int getMax() { return getValeur(); }

    public boolean use(int cost) {
        if (current < cost) return false;
        current -= cost;
        return true;
    }

    public void regen(int amount) {
        current = Math.min(getMax(), current + amount);
    }
}
