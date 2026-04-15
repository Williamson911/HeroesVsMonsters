package be.technifutur.heroesvsmonsters.weapons;

public enum Scaling {
    NONE(0.0),
    E(0.1),
    D(0.2),
    C(0.4),
    B(0.6),
    A(0.8),
    S(1.0);

    private final double multiplier;

    Scaling(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }
}