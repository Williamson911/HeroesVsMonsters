package be.technifutur.heroesvsmonsters.skills;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

public interface Skill {

    String name();

    int manaCost();

    int cooldown();

    void execute(Heroes hero, Monsters monster);

}