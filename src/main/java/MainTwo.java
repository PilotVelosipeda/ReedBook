import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args)  throws Exception {
        List<String> book = Files.readAllLines(
                Paths.get("C:\\Users\\Вадим\\IdeaProjects\\WarAndPeace\\data\\Толстой Лев. Война и мир.txt"));

        System.out.println("Введите слово, а мы выведем в консоль кол-во повторений в данной книге: ");
        String inputWord = new Scanner(System.in).nextLine();
        int countAttempts = 0;
        int countWord = 0;
        double termFrequency = 0;

        for (String line : book) {
            String[] elements = line.split("(\s+)|(\\n+)|(.)|(\\.)");
            for (String element : elements) {
                if (element.compareToIgnoreCase(inputWord) == 0) {
                    countAttempts++;
                }
                if (element.matches("[а-яА-Я]+")) {
                    String word = element;
                    countWord++;
                }
            }
        }

        termFrequency =(double)countAttempts / countWord;
        System.out.println(
                "Кол-во повторений " + inputWord + " равно " + countAttempts +
                        "\nКол-во слов в кинге равно " + countWord +
                        "\nЧастота потребления слов " + inputWord + " в книге равна " + termFrequency
        );
    }
}
