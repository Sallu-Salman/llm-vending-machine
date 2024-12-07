package button;

import entitiy.VendingMachine;

public class GetItemButton implements Button{
    @Override
    public void press(VendingMachine vendingMachine) throws Exception {
        vendingMachine.getVmState().getItem(vendingMachine);
    }
}
