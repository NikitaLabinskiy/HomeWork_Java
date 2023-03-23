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

// import java.util.ArrayList;
// import java.util.HashMap;

public class LapTopClass {
    int id;
    String laptopModel;
    String screenSize;
    String screenResolution;
    String processor;
    String operatingSystem;
    String SSD;
    String color; 
     
    public LapTopClass(int id, String  laptopModel, String screenSize, String screenResolution, 
                       String  operatingSystem, String SSD, String color){
        this.id = id;
        this.laptopModel = laptopModel;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.operatingSystem = operatingSystem;
        this.laptopModel = laptopModel;
        this.SSD = SSD;
        this.color = color;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%s %s %s %s %s %s", laptopModel, screenSize, screenResolution, operatingSystem, SSD, color);
    }

    @Override
    public boolean equals(Object obj) {
        LapTopClass temp = (LapTopClass) obj;
        return laptopModel.equals(temp.laptopModel) && screenSize.equals(temp.screenSize)  && screenResolution.equals(temp.screenResolution) &&
               operatingSystem.equals(temp.operatingSystem)  && SSD.equals(temp.SSD) && color.equals(temp.color);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return id;
    }

    public ArrayList<String> ConvertToArrayList(LapTopClass laptop) {
        ArrayList<String> array = new ArrayList<>();
        array.add(laptopModel);
        array.add(screenSize);
        array.add(screenResolution);
        array.add(operatingSystem);
        array.add(SSD);
        array.add(color);

        return array;
    }
}
