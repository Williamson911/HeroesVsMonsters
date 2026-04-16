package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.characters.Personnage;
import be.technifutur.heroesvsmonsters.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monsters extends Personnage {

    private final int amesReward;
    private final double dropChance;

    private static final Random random = new Random();

    public Monsters(String nom, int amesReward, double dropChance) {
        super(nom);
        this.amesReward = amesReward;
        this.dropChance = dropChance;
    }

    public int getAmesReward() {
        return amesReward;
    }

    public List<Item> generateLoot() {
        List<Item> drops = new ArrayList<>();

        for (Item item : getPossibleDrops()) {
            if (random.nextDouble() <= dropChance) {
                drops.add(item);
            }
        }

        return drops;
    }

    protected abstract List<Item> getPossibleDrops();

    // ✔ CLEAN API
    public void takeDamage(int dmg) {
        super.takeDamage(dmg);
    }

    public int calculateDamage(Heroes hero) {
        return getForceValue();
    }
    private boolean escaped = false;

    public void escape() {
        this.escaped = true;
    }

    public boolean hasEscaped() {
        return escaped;
    }
    private int posture = 0;
    private int maxPosture = 100;

    public void addPosture(int value) {
        posture += value;
    }

    public boolean isStaggered() {
        return posture >= maxPosture;
    }

    public void resetPosture() {
        posture = 0;
    }
}