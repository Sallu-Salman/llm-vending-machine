package entitiy;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class ItemStack {
    @Getter
    private List<Item> items;
    @Getter
    private int size;
    @Getter
    private int code;

    public ItemStack(int code, int size) {
        this.items = new ArrayList<>();
        this.size = size;
        this.code = code;
    }

    public void refill(Item item, int numberOfItems) {
        for (int i = 0; i < numberOfItems; i++) {
            this.items.add(item);
        }
    }
}
