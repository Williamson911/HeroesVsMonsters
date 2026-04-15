package be.technifutur.heroesvsmonsters.enemies;

import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.weapons.Armes;

import java.util.List;
public class DemonTaureau extends Boss {

        public DemonTaureau() {
            super("Démon Taureau", 3000, 1.0);

            getVitalite().addBonus(800);
            getForce().addBonus(55);
            getResistance().addBonus(25);
        }

        @Override
        protected List<Item> getPossibleDrops() {
            return List.of();
        }

        @Override
        protected List<Item> getGuaranteedDrops() {
            return List.of(
                    new Armes("Taurus Axe", 100, "Axe", 35, 5, 0, 5)
            );
        }
    }