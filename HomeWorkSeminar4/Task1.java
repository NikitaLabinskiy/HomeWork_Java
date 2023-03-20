// Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод, который вернёет «перевёрнутый» список.
package HomeWorkSeminar4;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> array = FillArray(random, scanner);
        System.out.print("Изначальный список: " + array);
        LinkedList<Integer> result = FlipArray(array);
        System.out.print("\nПеревернутый список: " + result);
        scanner.close();
    }
    public static LinkedList<Integer> FillArray(Random random, Scanner scanner) {
        System.out.print("Введите размер массива: ");
        int number = scanner.nextInt();
        LinkedList<Integer> array = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            array.add(random.nextInt(1, 20));
        }
        return array;
    }
    public static LinkedList<Integer> FlipArray(LinkedList<Integer> array) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < array.size(); i++) {
            result.addFirst(array.get(i));
        }
        return result;
    }
}
