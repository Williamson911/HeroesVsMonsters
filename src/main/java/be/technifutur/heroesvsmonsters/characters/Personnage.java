package be.technifutur.heroesvsmonsters.characters;

import be.technifutur.heroesvsmonsters.stats.*;

public abstract class Personnage {

    private String nom;

    private Vitalite vitalite;
    private Endurance endurance;
    private Force force;
    private Dexterite dexterite;
    private Intelligence intelligence;
    private Resistance resistance;

    public Personnage(String nom) {
        this.nom = nom;
    }

    public void setStats(Vitalite v, Endurance e, Force f,
                         Dexterite d, Intelligence i, Resistance r) {

        this.vitalite = v;
        this.endurance = e;
        this.force = f;
        this.dexterite = d;
        this.intelligence = i;
        this.resistance = r;

        applyClassBonus();
    }

    protected void applyClassBonus() {}

    // ── GETTERS ─────────────────────────────

    public String getNom() { return nom; }

    public Vitalite getVitalite() { return vitalite; }

    public Endurance getEndurance() { return endurance; }

    public Force getForce() { return force; }

    public Dexterite getDexterite() { return dexterite; }

    public Intelligence getIntelligence() { return intelligence; }

    public Resistance getResistance() { return resistance; }
    public void heal(int amount) {
        if (vitalite != null) {
            vitalite.augmenter(amount);
        }
    }

    public void takeDamage(int amount) {
        if (vitalite != null) {
            vitalite.reduire(amount);
        }
    }

    public boolean isAlive() {
        return vitalite != null && vitalite.getValeur() > 0;
    }
    protected int getForceValue() {
        return force != null ? force.getValeur() : 0;
    }
}