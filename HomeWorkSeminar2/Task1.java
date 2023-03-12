// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.

// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package HomeWorkSeminar2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("\033[H\033[2J");
        StringBuilder text = ReadStringFromFile();
        StringBuilder result = ParseJson(text);
        System.out.println(result);
    }
    public static StringBuilder ReadStringFromFile() {
        File file = new File("text.txt");
        StringBuilder text = new StringBuilder();
        try {
            FileReader fileR = new FileReader(file);
            int s;
            while ((s = fileR.read()) != -1) {
                // System.out.print((char) s);
                text.append((char) s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return text;
    }
    public static StringBuilder ParseJson(StringBuilder stringBuilder) {
        String sql = "select * from students where ";
        StringBuilder result = new StringBuilder(sql);
        while (stringBuilder.length() > 2) {
            StringBuilder text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            // System.out.println(text);
            String argument = stringBuilder.substring(0, stringBuilder.indexOf("\""));
            text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            // System.out.println(name);
            // System.out.println(text);
            text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            // System.out.println(text);
            String value = stringBuilder.substring(0, stringBuilder.indexOf("\""));
            text = stringBuilder.delete(0, stringBuilder.indexOf("\"") + 1);
            // System.out.println(value);
            // System.out.println(text);
            boolean check = value.equals("null");
            if (check == false) {
                result.append(argument);
                result.append(" = ");
                result.append("\'");
                result.append(value);
                result.append("\'");
                result.append(" and ");
            }
        }
        result.delete(result.length()-4, result.length());
        return result;
    }
}
