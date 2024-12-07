import entitiy.VendingMachine;
import state.IdleState;
import java.util.Scanner;

public class VendingMachineApplication {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        while (true) {
            System.out.println("1. Start transaction");
            System.out.println("2. Insert coin");
            System.out.println("3. Choose item");
            System.out.println("4. Get item");
            System.out.println("5. Add item");
            System.out.println("6. Refill item");
            System.out.println("7. Cancel transaction");
            System.out.println("8. Exit");
            System.out.println("Enter a command: ");
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 1:
                    startTransaction(vendingMachine);
                    break;
                case 2:
                    insertCoin(vendingMachine);
                    break;
                case 3:
                    selectItem(vendingMachine);
                    break;
                case 4:
                    getItem(vendingMachine);
                    break;
                case 5:
                    addItem(vendingMachine);
                    break;
                case 6:
                    refillItem(vendingMachine);
                    break;
                case 7:
                    cancelTransaction(vendingMachine);
                    break;
                default:
                    System.out.println("Thank you for using our vending machine");
                    break;
            }
        }
    }

    private static void startTransaction(VendingMachine vendingMachine) {
        try {
            vendingMachine.pressStartTransactionButton();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Enter the amount of coin: ");
        double coin = Double.parseDouble(scanner.nextLine());
        vendingMachine.insertCoin(coin);
    }

    private static void selectItem(VendingMachine vendingMachine) {
        try {
            vendingMachine.pressSelectItemButton();
            System.out.println("Please enter Get Item button");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getItem(VendingMachine vendingMachine) {
        try {
            vendingMachine.pressGetItemButton();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void cancelTransaction(VendingMachine vendingMachine) {
        try {
            vendingMachine.pressCancelTransactionButton();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void refillItem(VendingMachine vendingMachine) {
        vendingMachine.refillItem();
    }

    private static void addItem(VendingMachine vendingMachine) {
        vendingMachine.addItem();
    }
}
