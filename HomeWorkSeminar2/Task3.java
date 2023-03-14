// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json 
// и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package HomeWorkSeminar2;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        ArrayList<String> arrayStrings = ReadStringFromFile();
        ParsAllStrings(arrayStrings);
    }
    // В этом методе мы считываем строку из файла и помещаем ее в массив строк;
    public static ArrayList<String> ReadStringFromFile() {
        File file = new File("text2.txt");
        StringBuilder text = new StringBuilder();
        ArrayList<String> arrayStrings = new ArrayList<>();
        try {
            FileReader fileR = new FileReader(file);
            int s;
            while ((s = fileR.read()) != -1) {
                text.append((char) s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        while (text.length() > 2) {
            String string = text.substring(0, text.indexOf("}"));
            text.delete(0, text.indexOf("}")+1);
            arrayStrings.add(string); 
        }
        return arrayStrings;
    }
    // Этот метод принимает наш массив строк. 
    // В цикле "for" каждый эллемент массива преобразовывается в формат StringBuilder и передается в метод ParseJson.
    public static void ParsAllStrings(ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {
            String stringIndex = new String(array.get(i));
            StringBuilder string = new StringBuilder(stringIndex);
            StringBuilder result = ParseJson(string);
            System.out.print(result);
            System.out.println();
        }
    }
    // Этот метод принимает переменную формата StringBuilder, в которой JSON строка, и преобразовывает ее в конечный результат;
    public static StringBuilder ParseJson(StringBuilder stringBuilder) {
        String sql = "The student ";
        StringBuilder result = new StringBuilder(sql);
        while (stringBuilder.length() > 2) {
            StringBuilder text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            String argument = stringBuilder.substring(0, stringBuilder.indexOf("\""));
            text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            String value = stringBuilder.substring(0, stringBuilder.indexOf("\""));
            text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            boolean check = value.equals("null");
            if (check == false) {
                result.append(value);
                if(argument.equals("surname"))
                    result.append(" recieved ");
                if(argument.equals("grade"))
                    result.append(" in subject ");
            }
        }
        return result;
    }
}
