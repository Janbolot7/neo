package Janbolot.neobis.week1;

import java.util.Scanner;

public class PopulationIncrease {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();

            for (int t = 0; t < T; t++) {
                int PA = scanner.nextInt();
                int PB = scanner.nextInt();
                double G1 = scanner.nextDouble();
                double G2 = scanner.nextDouble();
                int years = 0;

                while (PA <= PB) {
                    PA = (int) (PA * (1 + G1 / 100));
                    PB = (int) (PB * (1 + G2 / 100));
                    years++;

                    if (years > 100) {
                        System.out.println("Mais de 1 seculo");
                        break;
                    }
                }

                if (years <= 100) {
                    System.out.println(years + " ano(s)");
                }
            }
        }
    }

}
