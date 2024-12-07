package entitiy;

import java.util.Scanner;
public class NumberPad {
    public int getNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a number: ");
            return Integer.parseInt(scanner.nextLine());
        }
    }

    public String getString() {
        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}
