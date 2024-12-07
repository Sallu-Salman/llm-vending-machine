package entitiy;

import button.*;
import lombok.Getter;
import lombok.Setter;
import state.CollectMoneyState;
import state.IdleState;
import state.VMState;

public class VendingMachine {
    @Getter
    @Setter
    private VMState vmState;
    @Getter
    private double vmWallet;
    @Getter
    @Setter
    private double totalMoneyCollected;
    @Getter
    private CoinSlot coinSlot;
    @Getter
    private NumberPad numberPad;
    @Getter
    private Inventory inventory;
    @Getter
    private Button startTransactionButton;
    @Getter
    private Button selectItemButton;
    @Getter
    private Button getItemButton;
    @Getter
    private Button cancelTransactionButton;

    public VendingMachine() {
        this.vmState = new IdleState();
        this.vmWallet = 0;
        this.totalMoneyCollected = 0;
        this.coinSlot = new CoinSlot();
        this.inventory = new Inventory();
        this.numberPad = new NumberPad();
        this.startTransactionButton = new StartTransactionButton();
        this.selectItemButton = new SelectItemButton();
        this.getItemButton = new GetItemButton();
        this.cancelTransactionButton = new CancelButton();
    }

    public void pressStartTransactionButton() throws Exception {
        this.startTransactionButton.press(this);
    }

    public void pressSelectItemButton() throws Exception {
        this.selectItemButton.press(this);
    }

    public void pressGetItemButton() throws Exception {
        this.getItemButton.press(this);
    }

    public void pressCancelTransactionButton() throws Exception {
        this.cancelTransactionButton.press(this);
    }

    public void insertCoin(double coin) {
        this.coinSlot.setCoinSlotWallet(this.coinSlot.getCoinSlotWallet() + coin);
    }

    public void returnMoney() {
        System.out.println("Returning money: " + (this.totalMoneyCollected + this.coinSlot.getCoinSlotWallet()));
        this.totalMoneyCollected = 0;
        this.coinSlot.setCoinSlotWallet(0);
    }

    public void getItem() {
        int stackCode = this.numberPad.getNumber();
        ItemStack itemStack = this.inventory.getItemStack(stackCode);
        if (itemStack == null) {
            System.out.println("Invalid stack code");
            returnMoney();
            this.setVmState(new IdleState());
            return;
        }

        if (itemStack.getItems().isEmpty()) {
            System.out.println("Item stack is empty");
            returnMoney();
            this.setVmState(new IdleState());
            return;
        }

        if (itemStack.getItems().get(0).getPrice() > this.totalMoneyCollected) {
            System.out.println("Insufficient funds");
            returnMoney();
            this.setVmState(new IdleState());
            return;
        }

        Item item = itemStack.getItems().remove(0);
        System.out.println("Dispensing item: " + item.getName());
        this.totalMoneyCollected -= item.getPrice();
        returnMoney();
        this.setVmState(new IdleState());
    }

    public void refillItem() {
        System.out.println("Stack code");
        int stackCode = this.numberPad.getNumber();
        System.out.println("Item Id");
        int itemId = this.numberPad.getNumber();
        Item item = this.inventory.getItemById(itemId);
        if (item == null) {
            System.out.println("Invalid item id");
            return;
        }
        System.out.println("Number of items to refill");
        int numberOfItems = this.numberPad.getNumber();
        this.inventory.refill(stackCode, item, numberOfItems);
    }

    public void addItem() {
        System.out.println("Enter item id: ");
        int itemId = this.numberPad.getNumber();
        System.out.println("Enter item name");
        String itemName = this.numberPad.getString();
        System.out.println("Enter item price");
        double itemPrice = this.numberPad.getNumber();
        this.inventory.addItem(new Item(itemId, itemName, itemPrice));
    }

}
