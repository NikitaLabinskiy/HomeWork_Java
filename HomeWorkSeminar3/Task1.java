package HomeWorkSeminar3;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int[] array = FillArray(random, scanner);
        int[] result = SortArray(array);
        PrintArray(result);
    }

    public static int[] FillArray(Random random, Scanner scanner) {
        System.out.print("Введите размер массива: ");
        int number = scanner.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 200);
        }
        return array;
    }

    public static int[] SortArray(int[] array) {

        if (array == null)
            return null;
        if (array.length < 2)
            return array;
        int[] arrayLeft = new int[array.length / 2];
        System.arraycopy(array, 0, arrayLeft, 0, arrayLeft.length);
        int[] arrayRight = new int[array.length - arrayLeft.length];
        System.arraycopy(array, arrayLeft.length, arrayRight, 0, arrayRight.length);

        SortArray(arrayLeft);
        SortArray(arrayRight);

        MergeArray(array, arrayLeft, arrayRight);

        return array;
    }

    public static void MergeArray(int[] array, int[] arrayLeft, int[] arrayRight) {

        int countLeft = 0;
        int countRight = 0;

        for (int i = 0; i < array.length; i++) {
            if (countLeft == arrayLeft.length) {
                array[i] = arrayRight[countRight];;
                countRight++;
            } else if (countRight == arrayRight.length) {
                array[i] = arrayLeft[countLeft];
                countLeft++;
            } else if (arrayLeft[countLeft] < arrayRight[countRight]) {
                array[i] = arrayLeft[countLeft];
                countLeft++;
            } else {
                array[i] = arrayRight[countRight];
                countRight++;
            }
        }
    }

    public static void PrintArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.printf(array[index] + " ");
        }
    }
}
