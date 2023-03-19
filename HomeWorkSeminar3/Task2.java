// Пусть дан произвольный список целых чисел, удалить из него чётные числа

package HomeWorkSeminar3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = FillArray(random, scanner);
        System.out.print("Изначальный массив: ");
        System.out.println(array);
        ArrayList<Integer> result = DeleteEvenNumbers(array);
        System.out.print("Массив нечетных элементов: ");
        System.out.println(result);
    }
    public static ArrayList<Integer> FillArray(Random random, Scanner scanner) {
        System.out.print("Введите размер массива: ");
        int number = scanner.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            array.add(random.nextInt(1, 200));
        }
        return array;
    }
    public static ArrayList<Integer> DeleteEvenNumbers(ArrayList<Integer> array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) % 2 == 1)
                result.add(array.get(i));
        }
        return result;
    }
}
