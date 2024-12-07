package state;

import entitiy.VendingMachine;

public class ItemSelectionState implements VMState{
    @Override
    public void startTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't start transaction in ItemSelectionState");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't select item in ItemSelectionState");
    }

    @Override
    public void getItem(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVmState(new ProcessingState());
        vendingMachine.getItem();
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVmState(new IdleState());
        vendingMachine.returnMoney();
    }
}
