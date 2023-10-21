package Janbolot.neobis.week1;

import java.util.Scanner;

public class Grenais {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int interGoals, gremioGoals;
            int totalGrenais = 0,
                    victoriesInter = 0,
                    victoriesGremio = 0,
                    draws = 0;

            do {
                interGoals = sc.nextInt();
                gremioGoals = sc.nextInt();
                totalGrenais++;

                if (interGoals > gremioGoals) {
                    victoriesInter++;
                } else if (gremioGoals > interGoals) {
                    victoriesGremio++;
                } else {
                    draws++;
                }

                System.out.println("Novo grenal (1-sim 2-nao)");
            } while (sc.nextInt() == 1);

            sc.close();

            System.out.println(totalGrenais + " grenais");
            System.out.println("Inter:" + victoriesInter);
            System.out.println("Gremio:" + victoriesGremio);
            System.out.println("Empates:" + draws);

            if (victoriesInter > victoriesGremio) {
                System.out.println("Inter venceu mais");
            } else if (victoriesGremio > victoriesInter) {
                System.out.println("Gremio venceu mais");
            } else {
                System.out.println("Nao houve vencedor");
            }
        }
    }
