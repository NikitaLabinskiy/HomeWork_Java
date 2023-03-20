// Реализуйте очередь с помощью LinkedList со следующими методами:
// • enqueue() — помещает элемент в конец очереди,
// • dequeue() — возвращает первый элемент из очереди и удаляет его,
// • first() — возвращает первый элемент из очереди, не удаляя.
package HomeWorkSeminar4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> array = FillArray(random, scanner);
        System.out.print("Изначальный список: " + array);
        MethodsImplementation(array, scanner);
    }
    
    public static Queue<Integer> FillArray(Random random, Scanner scanner) {
        System.out.print("Введите размер массива: ");
        int number = scanner.nextInt();
        Queue<Integer> array = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            array.add(random.nextInt(1, 20));
        }
        return array;
    }

    public static void enqueue(Queue<Integer> array, Scanner scanner) {
        System.out.print("Введите добавляемый эллемент: ");
        int number = scanner.nextInt();
        System.out.println(array.offer(number));
        System.out.print("\nМассив с добавленным элементом в конец очереди: " + array);
    }

    public static void dequeue(Queue<Integer> array) {
        System.out.print("\nУдаленный элемент: " + array.poll());
        System.out.print("\nБез первого элемнта в очереди " + array);
    }

    public static void first(Queue<Integer> array) {
        System.out.print("\nВозвращаем первый элемент из очереди не удаляя его: " + array.peek());
        System.out.print("\nМассив  с первым эллементом в очереди" + array);
    }

    public static void MethodsImplementation(Queue<Integer> array, Scanner scanner) {
        System.out.println("\nВведите 1 если хотите вызвать метод enqueue(): " + 
                           "\nВведите 2 если хотите вызвать метод dequeue(): " + 
                           "\nВведите 3 если хотите вызвать метод first(): " +
                           "\nВведите 4 если хотите вызвать все методы: ");
        int action = scanner.nextInt();
        switch (action) {
            case 1:
                enqueue(array, scanner);
                break;
            case 2:
                dequeue(array);
                break;
            case 3:
                first(array);
                break;
            case 4:
                enqueue(array, scanner);
                dequeue(array);
                first(array);
                break;   
            default: 
                System.out.println("Ошибка! Введен некорректный оператор.");
                break;
        }
    }
}
