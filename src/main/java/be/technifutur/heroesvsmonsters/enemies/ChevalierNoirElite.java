package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.items.Titanites;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;

public class ChevalierNoirElite extends Monsters {

    public ChevalierNoirElite() {
        super("Chevalier Noir Elite", 800, 0.7);

        getVitalite().addBonus(300);
        getForce().addBonus(60);
        getResistance().addBonus(40);
    }

        @Override
        protected List<Item> getPossibleDrops() {
            return List.of(

                    // ⚔️ Black Knight Greatsword (Espadon)
                    new Armes(
                            "Black Knight Greatsword",
                            140,        // dégâts élevés
                            "Greatsword",
                            45,         // force
                            18,         // dex
                            0,
                            6           // endurance
                    ),

                    // ⚔️ Black Knight Sword (épée classique)
                    new Armes(
                            "Black Knight Sword",
                            120,
                            "Sword",
                            35,
                            18,
                            0,
                            4
                    ),

                    // 🪓 Black Knight Greataxe
                    new Armes(
                            "Black Knight Greataxe",
                            150,
                            "Greataxe",
                            50,
                            12,
                            0,
                            8
                    ),

                    // 🔱 Black Knight Halberd (très forte en early game)
                    new Armes(
                            "Black Knight Halberd",
                            130,
                            "Halberd",
                            32,
                            22,
                            0,
                            5
                    ),

                    // 🛡 Black Knight Shield
                    new Armes(
                            "Black Knight Shield",
                            0,          // pas de dégâts
                            "Shield",
                            0,
                            16,
                            0,
                            12          // bonus endurance élevé (blocage)
                    ),


                new Titanites("Red Titanite Chunk", 2),
                    new Titanites("Titanite Chunk", 3)
        );
    }
}