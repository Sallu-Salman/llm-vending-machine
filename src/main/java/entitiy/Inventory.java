package entitiy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class Inventory {
    @Getter
    private List<Row> rows;
    @Getter
    private Map<Integer, Item> items;

    public Inventory() {
        this.rows = new ArrayList<>();
        this.items = new HashMap<>();
    }

    public void refill(int stackCode, Item item, int numberOfItems) {
        for (Row row : this.rows) {
            ItemStack itemStack = row.getItemStack(stackCode);
            if (itemStack != null) {
                itemStack.refill(item, numberOfItems);
                this.items.put(item.getId(), item);
            }
        }
    }

    public ItemStack getItemStack(int stackCode) {
        for (Row row : this.rows) {
            ItemStack itemStack = row.getItemStack(stackCode);
            if (itemStack != null) {
                return itemStack;
            }
        }
        return null;
    }

    public Item getItemById(int itemId) {
        return this.items.get(itemId);
    }

    public void addItem(Item item) {
        this.items.put(item.getId(), item);
    }
}
