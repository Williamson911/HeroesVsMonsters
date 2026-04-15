package be.technifutur.heroesvsmonsters.items;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {

    private final List<Item> items = new ArrayList<>();

    public void ajouter(Item item) {
        items.add(item);
        System.out.println(item.getNom() + " ajouté à l'inventaire.");
    }

    public void afficher() {
        if(items.isEmpty()) {
            System.out.println("Inventaire vide.");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getNom());
        }
    }

    public Item get(int index) {
        return items.get(index);
    }

    public List<Item> getItems() {
        return items;
    }
}