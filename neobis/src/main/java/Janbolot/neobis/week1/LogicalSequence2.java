package Janbolot.neobis.week1;

import java.util.Scanner;

public class LogicalSequence2 {
    public class TriangleType {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            double A = scanner.nextDouble();
            double B = scanner.nextDouble();
            double C = scanner.nextDouble();

            if (A < B) {
                double temp = A;
                A = B;
                B = temp;
            }
            if (A < C) {
                double temp = A;
                A = C;
                C = temp;
            }
            if (B < C) {
                double temp = B;
                B = C;
                C = temp;
            }

            if (A >= B + C) {
                System.out.println("NAO FORMA TRIANGULO");
            } else {
                if (A * A == B * B + C * C) {
                    System.out.println("TRIANGULO RETANGULO");
                }
                if (A * A > B * B + C * C) {
                    System.out.println("TRIANGULO OBTUSANGULO");
                }
                if (A * A < B * B + C * C) {
                    System.out.println("TRIANGULO ACUTANGULO");
                }
                if (A == B && B == C) {
                    System.out.println("TRIANGULO EQUILATERO");
                } else if (A == B || B == C || A == C) {
                    System.out.println("TRIANGULO ISOSCELES");
                }
            }
            scanner.close();
        }
    }
}
