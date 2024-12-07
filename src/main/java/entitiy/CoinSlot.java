package entitiy;

import lombok.Getter;
import lombok.Setter;

public class CoinSlot {
    @Getter
    @Setter
    private double coinSlotWallet;

    public CoinSlot() {
        this.coinSlotWallet = 0;
    }
}
