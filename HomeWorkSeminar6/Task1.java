// 1) Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы. Реализовать в Java.
// 2) Создать множество ноутбуков.
// 3)Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map. Например:
// “Введите цифру, соответствующую необходимому критерию:
// 1 - ОЗУ
// 2 - Объём ЖД
// 3 - Операционная система
// 4 - Цвет …

// 4) Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
// 5) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

package HomeWorkSeminar6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        Scanner scanner = new Scanner(System.in);
        LapTopClass laptop1 = new LapTopClass(1, "Asus", "15", "1920x1080", "Windows 11", "512 ГБ", "черный");
        LapTopClass laptop2 = new LapTopClass(2, "Asus", "15", "2560x1440", "Windows 11", "1 ТБ", "space gray");
        LapTopClass laptop3 = new LapTopClass(3, "Asus", "15", "1920x1080", "без ОС", "512 ГБ", "черный");
        LapTopClass laptop4 = new LapTopClass(4, "Huawei", "14.2", "3120x2080", "Windows 11", "1 ТБ", "синий");
        LapTopClass laptop5 = new LapTopClass(5, "Huawei", "14.2", "3120x2080", "Windows 11", "1 ТБ", "белый");
        LapTopClass laptop6 = new LapTopClass(6, "Huawei", "14.2", "3120x2080", "Windows 11", "1 ТБ", "space gray");
        LapTopClass laptop7 = new LapTopClass(7, "Huawei", "13", "3000x2000", "Windows 11", "512 ГБ", "серебристый");
        LapTopClass laptop8 = new LapTopClass(8, "Huawei", "13", "3000x2000", "Windows 11", "512 ГБ", "space gray");
        LapTopClass laptop9 = new LapTopClass(9, "MacBook", "14.2", "3024x1924", "macOS", "1 ТБ", "серебристый");
        LapTopClass laptop10 = new LapTopClass(10, "MacBook", "14.2", "3024x1924", "macOS", "512 ГБ", "space gray");
        LapTopClass laptop11 = new LapTopClass(11, "MacBook", "13.6", "2560x1664", "macOS", "256 ГБ", "серебристый");
        LapTopClass laptop12 = new LapTopClass(12, "MacBook", "13.6", "2560x1664", "macOS", "512 ГБ", "space gray");
        
        System.out.println("Выберите критерий фильтрации: " + "\n1 - Модель ноутбука" +
                "\n2 - Размер монитора" + "\n3 - Разрешение монитора" +
                "\n4 - Операционная система" + "\n5 - SSD накопитель" + "\n6 - Цвет");
        int number = scanner.nextInt();
        int number2 = 0;
        if(number > 6 && number < 1)
            System.out.println("Введены некорректные данные!"); 
        else{
            switch (number) {
                case 1:
                    System.out.println("Выберите модель ноутбука: " + "\n1 - Asus" + "\n2 - Huawei" + "\n3 - MacBook");
                    number2 = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Выберите размер экрана: " + "\n1 - 15" + "\n2 - 14.2" + "\n3 - 13.6" + "\n4 - 13");
                    number2 = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("Выберите разрешение экрана: " + "\n1 - 3120x2080" + "\n2 - 3024x1924" + "\n3 - 3000x2000" + "\n4 - 2560x1664" + "\n5 - 2560x1440" + "\n6 - 1920x1080");
                    number2 = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Выберите операционную систему ноутбука: " + "\n1 - Windows 11" + "\n2 - macOS" + "\n3 - без OS");
                    number2 = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Выберите SSD накопитель ноутбука: " + "\n1 - 1 ТБ" + "\n2 - 512 ГБ" + "\n3 - 256 ГБ");
                    number2 = scanner.nextInt();
                    break;
                case 6:
                    System.out.println("Выберите желаемый цвет: " + "\n1 - черный" + "\n2 - space gray" + "\n3 - синий" + "\n4 - белый" + "\n5 - серебристый");
                    number2 = scanner.nextInt();
                    break;
                default:
                    System.out.println("Введены некорректные данные!"); 
                    break;
            }
        }
        FilterArgument(laptop1, number, number2);
        FilterArgument(laptop2, number, number2);
        FilterArgument(laptop3, number, number2);
        FilterArgument(laptop4, number, number2);
        FilterArgument(laptop5, number, number2);
        FilterArgument(laptop6, number, number2);
        FilterArgument(laptop7, number, number2);
        FilterArgument(laptop8, number, number2);
        FilterArgument(laptop9, number, number2);
        FilterArgument(laptop10, number, number2);
        FilterArgument(laptop11, number, number2);
        FilterArgument(laptop12, number, number2);
        scanner.close();
    }

    public static int FilterArgument(LapTopClass laptop, int number, int i) {
        ArrayList<String> array = laptop.ConvertToArrayList(laptop);
        switch (number) {
            case 1:
                switch (i) {
                    case 1:
                        if (array.contains("Asus"))
                            System.out.println(laptop);
                            break;
                    case 2:
                        if (array.contains("Huawei"))
                            System.out.println(laptop);
                            break;
                    case 3:
                        if (array.contains("MacBook"))
                            System.out.println(laptop);
                            break;
                
                }
                break;
            case 2:
                switch (i) {
                    case 1:
                        if (array.contains("15"))
                                System.out.println(laptop);
                                break;
                    case 2:
                        if (array.contains("14.2"))
                            System.out.println(laptop);
                            break;
                    case 3:
                        if (array.contains("13.6"))
                            System.out.println(laptop);
                            break;
                    case 4:
                        if (array.contains("13"))
                            System.out.println(laptop);
                            break;
                    
                }
                break;
            case 3:
                switch (i) {
                    case 1:
                        if (array.contains("3120x2080"))
                            System.out.println(laptop);
                            break;
                    case 2:
                        if (array.contains("3024x1924"))
                            System.out.println(laptop);
                            break;
                    case 3:
                        if (array.contains("3000x2000"))
                            System.out.println(laptop);
                            break;
                    case 4:
                        if (array.contains("2560x1664"))
                            System.out.println(laptop);
                            break;
                    case 5:
                        if (array.contains("2560x1440"))
                            System.out.println(laptop);
                            break;
                    case 6:
                        if (array.contains("1920x1080"))
                            System.out.println(laptop);
                        break;
                }
                break;
            case 4:
                switch (i) {
                    case 1:
                        if (array.contains("Windows 11"))
                            System.out.println(laptop);
                            break;
                    case 2:
                        if (array.contains("macOS"))
                            System.out.println(laptop);
                            break;
                    case 3:
                        if (array.contains("без OS"))
                            System.out.println(laptop);
                            break;
                }
                break;
            case 5:
                switch (i) {
                    case 1:
                        if (array.contains("1 ТБ"))
                            System.out.println(laptop);
                            break;
                    case 2:
                        if (array.contains("512 ГБ"))
                            System.out.println(laptop);
                            break;
                    case 3:
                        if (array.contains("256 ГБ"))
                            System.out.println(laptop);
                            break;
                }
                break;
            case 6:
                switch (i) {
                    case 1:
                    if (array.contains("черный"))
                            System.out.println(laptop);
                            break;
                    case 2:
                        if (array.contains("space gray"))
                            System.out.println(laptop);
                            break;
                    case 3:
                        if (array.contains("синий"))
                            System.out.println(laptop);
                            break;
                    case 4:
                        if (array.contains("белый"))
                            System.out.println(laptop);
                            break;
                    case 5:
                        if (array.contains("серебристый"))
                            System.out.println(laptop);
                            break;
                }
        }
        return number;
    }
}
