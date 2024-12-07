package button;

import entitiy.VendingMachine;

public class SelectItemButton implements Button{
    @Override
    public void press(VendingMachine vendingMachine) throws Exception {
        vendingMachine.getVmState().selectItem(vendingMachine);
    }
}
