package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.combat.CombatAction;
import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.utils.InputUtils;

import java.util.List;

public class ItemAction implements CombatAction {

    @Override
    public String name() {
        return "Utiliser un item";
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        List<Item> items = hero.getInventaire();

        if (items.isEmpty()) {
            System.out.println("Aucun item.");
            return;
        }

        System.out.println("\n══ INVENTAIRE ══");

        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, items.get(i).getNom());
        }

        int choice = InputUtils.readIntInRange(
                1,
                items.size(),
                "Choisissez un item : "
        ) - 1;

        Item item = items.get(choice);

        int heal = item.utiliser(hero);
        hero.heal(heal);

        System.out.println("+" + heal + " PV");
    }
}