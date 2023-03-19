// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
package HomeWorkSeminar3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> array = FillArray(random, scanner);
        System.out.println(array);
        FindMaxMinAverage(array);
        scanner.close();
    }
    public static ArrayList<Integer> FillArray(Random random, Scanner scanner) {
        System.out.print("Введите размер массива: ");
        int number = scanner.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            array.add(random.nextInt(1, 20));
        }
        return array;
    }
    public static void FindMaxMinAverage(ArrayList<Integer> array) {
        int max = 0;
        int min = array.get(0);
        int average = 0;
        for (int i : array) {
            if(i > max)
                max = i;
            else if(i < min)
                min = i;
        }
        average = (min + max) / 2;
        int averageminus = average;
        for (int i : array) {
            if(array.contains(average))
                break;
            else if(array.contains(averageminus)){
                average = averageminus;
                break;
            }
            else {
                average++; 
                averageminus--;
            }
        }
        System.out.print("Min = " + min);
        System.out.print("\nMax = " + max);
        System.out.print("\nAverage = " + average);
    }
}
