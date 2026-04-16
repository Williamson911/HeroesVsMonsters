package be.technifutur.heroesvsmonsters.stats;

public class Vitalite {

    private int valeur;
    private int max;

    public Vitalite(int valeur) {
        this.valeur = valeur;
        this.max = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public int getMax() {
        return max;
    }

    public void reduire(int degats) {
        valeur = Math.max(0, valeur - degats);
    }

    public void augmenter(int soin) {
        valeur = Math.min(max, valeur + soin);
    }

    public void setValeur(int valeur) {
        this.valeur = Math.max(0, Math.min(valeur, max));
    }

    public void addBonus(int bonus) {
        this.max += bonus;
        this.valeur += bonus; // option : heal en même temps
    }
    public void reset() {
        this.valeur = this.max;
    }
}