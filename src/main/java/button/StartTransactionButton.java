package button;

import entitiy.VendingMachine;

public class StartTransactionButton implements Button{
    @Override
    public void press(VendingMachine vendingMachine) throws Exception   {
        vendingMachine.getVmState().startTransaction(vendingMachine);
    }
}
