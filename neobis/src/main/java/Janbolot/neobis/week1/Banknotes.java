package Janbolot.neobis.week1;

import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int value = scanner.nextInt();

        int[] banknotes = {100, 50, 20, 10, 5, 2, 1};

        System.out.println(value);

        for (int i = 0; i < banknotes.length; i++) {
            int banknote = banknotes[i];
            int quantity = value / banknote;
            value %= banknote;

            System.out.println(quantity + " nota(s) de R$ " + banknote + ",00");
        }
        scanner.close();
    }
}

