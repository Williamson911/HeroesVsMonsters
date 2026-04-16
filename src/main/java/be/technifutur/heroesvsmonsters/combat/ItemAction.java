package be.technifutur.heroesvsmonsters.combat;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.combat.CombatAction;
import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.items.Item;
import be.technifutur.heroesvsmonsters.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemAction implements CombatAction {

    @Override
    public String name() {
        return "Utiliser un item";
    }

    @Override
    public int enduranceCost() {
        return 0;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        Map<Item, Integer> items = hero.getInventaire();

        if (items.isEmpty()) {
            System.out.println("❌ Aucun item");
            return;
        }

        List<Item> list = new ArrayList<>(items.keySet());

        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            int qty = items.get(item);
            System.out.println((i + 1) + ". " + item.getNom() + " x" + qty);
        }

        int choice = InputUtils.readIntInRange(1, list.size(), "Choix : ") - 1;

        Item item = list.get(choice);

        int value = item.utiliser(hero);

        System.out.println("✨ " + item.getNom() + " utilisé (" + value + ")");

        hero.removeItem(item);
    }
}