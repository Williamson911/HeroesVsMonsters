package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import java.util.List;

public abstract class Boss extends Monsters {

    private boolean phase2 = false;

    public Boss(String nom, int souls, double dropChance) {
        super(nom, souls, dropChance);
    }

    // override optionnel
    public void onPhaseChange() {
        // phase 2 logic
    }

    public boolean isPhase2() {
        return phase2;
    }

    public void triggerPhase2() {
        this.phase2 = true;
        onPhaseChange();
    }

    @Override
    public void takeDamage(int dmg) {
        super.takeDamage(dmg);

        // exemple: phase 2 à 50% HP
        if (!phase2 && getVitalite().getValeur() < 0.5 * getMaxHp()) {
            triggerPhase2();
        }
    }

    private double getMaxHp() {
        return 0;
    }

    protected abstract List<Item> getGuaranteedDrops();
}