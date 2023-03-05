// Реализовать простой калькулятор
package HomeWorkSeminar1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите символ операции, например ('*' '/' '+' '-'): ");
        char symbol = scanner.next().charAt(0);
        System.out.print("Введите первое число: ");
        double number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        double number2 = scanner.nextInt();
        Operation(symbol, number1, number2);
        scanner.close();
    }
    public static void Operation(char symbol, double number1, double number2) {
        double result = 0;
        switch (symbol) {
            case '*': result = number1 * number2;
                break;
            case '/': result = number1 / number2;
                break;
            case '-': result = number1 - number2;
                break;
            case '+': result = number1 + number2;
                break;
            default: System.out.println("Ошибка! Введен некорректный оператор.");
                break;
        }
        System.out.printf(number1 + " " + symbol + " " + number2 + " = " + result);
    }

    // public static double Multiplication(double number1, double number2) {
    //     return number1 * number2;
    // }
    // public static double Division(double number1, double number2) {
    //     return number1 / number2;
    // }
    // public static double Addition(double number1, double number2) {
    //     return number1 + number2;
    // }
    // public static double Subtraction(double number1, double number2) {
    //     return number1 - number2;
    // }
    // public static void Operation(String symbol, double number1, double number2) {
    //     String multipl = "*";
    //     String division = "/";
    //     String plus = "+";
    //     String minus = "-";
    //     if (symbol.equals(multipl)) 
    //         System.out.println(Multiplication(number1, number2)); 
    //     if (symbol.equals(division))
    //         System.out.println(Division(number1, number2));
    //     if (symbol.equals(plus))
    //         System.out.println(Addition(number1, number2));
    //     if (symbol.equals(minus))
    //         System.out.println(Subtraction(number1, number2));
    // }
}
