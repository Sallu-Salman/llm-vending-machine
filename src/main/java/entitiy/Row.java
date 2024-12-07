package entitiy;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class Row {
    @Getter
    private List<ItemStack> itemStacks;

    public Row() {
        this.itemStacks = new ArrayList<>();
    }

    public ItemStack getItemStack(int code) {
        for (ItemStack itemStack : this.itemStacks) {
            if (itemStack.getCode() == code) {
                return itemStack;
            }
        }
        return null;
    }
}
