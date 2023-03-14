// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package HomeWorkSeminar2;
import java.io.IOException;
import java.util.Random;
import java.util.logging.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        System.out.print("\033[H\033[2J");
        FileHandler fh = new FileHandler("log.xml");
        // FileHandler fh = new FileHandler("log.txt");
        Random random = new Random();
        int[] array = FillArray(random);
        System.out.print("Первоначальный массив: ");
        PrintArray(array);
        System.out.println();
        int[] result = SortArray(array, fh);
        System.out.print("Отсортированный массив: ");
        PrintArray(result);
    }
    public static int[] FillArray(Random random) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 20);
        }
        return array;
    }
    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(array[i] + " ");
        }
    }
    public static int[] SortArray(int[] array, FileHandler fh) {
        Logger logger = Logger.getLogger(Task2.class.getName());
        logger.addHandler(fh);
        // SimpleFormatter sFormat = new SimpleFormatter();
        XMLFormatter xml = new XMLFormatter();
        // fh.setFormatter(sFormat);
        fh.setFormatter(xml);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    logger.log(Level.INFO, "Cycle iteration!");
                }
            }
        }
        return array;
    }
}
