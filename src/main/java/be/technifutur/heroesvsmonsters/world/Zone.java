package be.technifutur.heroesvsmonsters.world;

import be.technifutur.heroesvsmonsters.enemies.Monsters;

import java.util.List;
import java.util.Random;

public class Zone {


    private final String name;
    private final List<Monsters> monsters;
    private final Monsters boss;
    private final double encounterChance;

    private final Random random = new Random();

    public Zone(String name, List<Monsters> monsters, Monsters boss, double encounterChance) {
        this.name = name;
        this.monsters = monsters;
        this.boss = boss;
        this.encounterChance = encounterChance;
    }

    public String getName() {
        return name;
    }

    public Monsters randomMonster() {
        return monsters.get(random.nextInt(monsters.size()));
    }

    public boolean hasEncounter() {
        return random.nextDouble() < 0.7; // 70% encounter rate
    }

    public boolean isBoss(Monsters monster) {
        return monster.getNom().equals(boss.getNom());
    }

    public Monsters getBoss() {
        return boss;
    }
}