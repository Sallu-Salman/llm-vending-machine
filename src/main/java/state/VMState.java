package state;

import entitiy.VendingMachine;

public interface VMState {
    public void startTransaction(VendingMachine vendingMachine) throws Exception;
    public void selectItem(VendingMachine vendingMachine) throws Exception;
    public void getItem(VendingMachine vendingMachine) throws Exception;
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception;
}
