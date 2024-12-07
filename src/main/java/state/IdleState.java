package state;

import entitiy.VendingMachine;

public class IdleState implements VMState{
    @Override
    public void startTransaction(VendingMachine vendingMachine) throws Exception {
        System.out.println("Welcome, please insert coin");
        vendingMachine.setVmState(new CollectMoneyState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Can't select item in Idle State");
    }

    @Override
    public void getItem(VendingMachine vendingMachine) throws Exception{
        throw new Exception("Can't get Item in Idle State");

    }

    @Override
    public void cancelTransaction(VendingMachine vendingMachine) throws Exception{
        throw new Exception("Can't cancel transaction in Idle State");
    }
}
