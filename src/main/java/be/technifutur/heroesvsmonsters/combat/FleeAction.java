package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.enemies.Monsters;

import java.util.Random;

public class FleeAction implements CombatAction {

    private static final Random random = new Random();

    @Override
    public String name() {
        return "Fuir";
    }

    @Override
    public int enduranceCost() {
        return 0;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        boolean success = random.nextInt(100) <
                (hero.getDexterite().getValeur() >= 15 ? 70 : 40);

        if (success) {
            System.out.println("Fuite réussie !");
            monster.escape();
        } else {
            System.out.println("Fuite échouée !");
        }
    }
}