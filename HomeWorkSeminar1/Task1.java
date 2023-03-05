// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
package HomeWorkSeminar1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();
        Integer resultTriangular = TriangularNumber(number);
        System.out.printf("Tringular number: %d", resultTriangular);
        System.out.println();
        Integer polindrom = FactorialOfNumber(number);
        System.out.printf("Factorial: %d", polindrom);
        scanner.close();
    }
    public static Integer TriangularNumber(Integer number) {
        int result = 0;
        for (int i = 2; i < number; i++) {
            result += i + (i - 1);
        }
        return result;
    }
    public static Integer FactorialOfNumber(Integer number) {
        int result = 0;
        for (int i = 2; i < number; i++) {
            result += i * (i - 1);
        }
        return result;         
    }
}