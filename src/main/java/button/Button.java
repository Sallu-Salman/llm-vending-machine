package button;

import entitiy.VendingMachine;

public interface Button {
    void press(VendingMachine vendingMachine) throws Exception;
}
