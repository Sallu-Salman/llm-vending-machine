package state;

import entitiy.VendingMachine;

public class CollectMoneyState implements VMState {
    @Override
    public void startTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't start transaction in CollectMoneyState");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine) {
        vendingMachine.setTotalMoneyCollected(vendingMachine.getCoinSlot().getCoinSlotWallet());
        vendingMachine.setVmState(new ItemSelectionState());
        System.out.println("Money collected: " + vendingMachine.getTotalMoneyCollected());
    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) {
        vendingMachine.setVmState(new IdleState());
        vendingMachine.returnMoney();
    }

    @Override
    public void getItem(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't get item in CollectMoneyState");
    }
}
