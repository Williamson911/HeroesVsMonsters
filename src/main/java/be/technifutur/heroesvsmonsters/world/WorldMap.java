package be.technifutur.heroesvsmonsters.world;

import java.util.ArrayList;
import java.util.List;

public class WorldMap {

    private final List<Zone> zones;
    private int index = 0;

    // constructeur principal
    public WorldMap(List<Zone> zones) {
        this.zones = new ArrayList<>(zones);
    }

    // accès zone actuelle
    public Zone getCurrentZone() {
        return zones.get(index);
    }

    // avancer
    public boolean moveNextZone() {
        if (index < zones.size() - 1) {
            index++;
            return true;
        }
        return false;
    }

    // reculer
    public boolean movePreviousZone() {
        if (index > 0) {
            index--;
            return true;
        }
        return false;
    }

    // option debug (si tu veux builder progressivement)
    public void addZone(Zone zone) {
        zones.add(zone);
    }
}