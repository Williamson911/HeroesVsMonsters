package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public interface CombatAction {
    String name();
    int enduranceCost();
    void execute(Heroes hero, Monsters monster);
}