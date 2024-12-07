package state;

import entitiy.VendingMachine;

public class ProcessingState implements VMState{
    @Override
    public void startTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't start transaction in ProcessingState");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't select item in ProcessingState");
    }

    @Override
    public void getItem(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't get item in ProcessingState");
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't cancel transaction in ProcessingState");
    }
}
