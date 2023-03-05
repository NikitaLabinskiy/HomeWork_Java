// Вывести все простые числа от 1 до 1000
package HomeWorkSeminar1;

public class Task2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        PrintPrimeNmbers();
    }

    public static void PrintPrimeNmbers() {
        for (int i = 2; i <= 1000; i++) {
            Integer count = 0;
            for (int j = 2; j <= Math.round(i / 2); j++) {
                if (i % j == 0)
                    count++;
            }
            if (count == 0)
                System.out.printf("[%d] ", i);
        }
    }
}
