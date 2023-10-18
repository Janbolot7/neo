package Janbolot.neobis.week1;

import java.util.Scanner;

public class Banknotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input integer value
        int value = scanner.nextInt();

        // Define an array to store the banknote values
        int[] banknotes = {100, 50, 20, 10, 5, 2, 1};

        System.out.println(value); // Print the read value

        // Iterate through the banknotes and calculate the quantity of each necessary banknote
        for (int i = 0; i < banknotes.length; i++) {
            int banknote = banknotes[i];
            int quantity = value / banknote; // Calculate the quantity of the current banknote
            value %= banknote; // Update the remaining value

            // Print the quantity and the name of the banknote in Portuguese
            System.out.println(quantity + " nota(s) de R$ " + banknote + ",00");
        }
        scanner.close();
    }
}

