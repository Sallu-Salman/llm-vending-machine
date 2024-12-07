package button;

import entitiy.VendingMachine;

public class CancelButton implements Button{
    @Override
    public void press(VendingMachine vendingMachine) throws Exception {
        vendingMachine.getVmState().cancelTransaction(vendingMachine);
    }
}
