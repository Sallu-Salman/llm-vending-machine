package entitiy;

import lombok.Getter;

public class Item {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private double price;

    public Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
