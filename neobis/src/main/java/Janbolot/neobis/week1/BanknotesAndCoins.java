package Janbolot.neobis.week1;

import java.util.Scanner;

//Считывание значения с плавающей точкой с двумя знаками после запятой.
// Это значение представляет собой денежную сумму.
// После этого вычислите наименьшее возможное количество банкнот и монет,
// на которые можно разложить данное значение. Рассматриваются купюры достоинством 100, 50, 20, 10, 5, 2.
// Возможные монеты - 1, 0,50, 0,25, 0,10, 0,05 и 0,01. Выведите сообщение "NOTAS:",
// за которым следует список банкнот, и сообщение "MOEDAS:", за которым следует список монет.
//Переведено с помощью www.DeepL.com/Translator (бесплатная версия)
public class BanknotesAndCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double monetaryValue = scanner.nextDouble();
        scanner.close();

        int[] banknotes = { 100, 50, 20, 10, 5, 2 };
        double[] coins = { 1.0, 0.5, 0.25, 0.1, 0.05, 0.01 };

        System.out.println("NOTAS:");

        for (int note : banknotes) {
            int count = (int) (monetaryValue / note);
            System.out.printf("%d nota(s) de R$ %.2f%n", count, (double) note);
            monetaryValue -= count * note;
        }
        System.out.println("MOEDAS:");
        for (double coin : coins) {
            int count = (int) (monetaryValue / coin);
            System.out.printf("%d moeda(s) de R$ %.2f%n", count, coin);
            monetaryValue -= count * coin;
        }
    }
}
