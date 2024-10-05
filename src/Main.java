import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String FILE_IN_NAME = "IN.txt";
        final String FILE_OUT_NAME = "OUT.txt";

        // Чтение данных из файла
        StringBuilder text = new StringBuilder();
        try(FileReader reader = new FileReader(FILE_IN_NAME))
        {
            int c;
            while ((c=reader.read())!=-1) {
                text.append((char)c);
            }
        }
        // Проверка на ошибку при чтении файла
        catch(IOException ex){
            System.out.println("При чтении данны из файла произошла ошибка!");
        }

        String myText = text.toString();

        int letterCount = myText.length();
        int spaceCount = 0;
        int paragraphCount = 0;
        int pageCount = 0;

        // Плучение коичества символов пробелов, нового абзаца и новой страницы
        for(char letter: myText.toCharArray()) {
            if (letter == ' ') spaceCount++;
            if (letter == '\u000c') pageCount++;
            if (letter == '\r') paragraphCount++;
        }

        int wordCount = spaceCount + 1;

        System.out.println("Количество символов: " + letterCount);
        System.out.println("Количество пробелов: " + spaceCount);
        System.out.println("Количесвто слов: " + wordCount);
        System.out.println("Количесвто параграфов: " + paragraphCount);
        System.out.println("Количесво страниц: " + pageCount);

        // Запись данных в файл
        try (FileWriter writer = new FileWriter(FILE_OUT_NAME)) {
            writer.write("Количество символов: " + letterCount + "\n");
            writer.write("Количество пробелов: " + spaceCount + "\n");
            writer.write("Количесвто слов: " + wordCount + "\n");
            writer.write("Количесвто параграфов: " + paragraphCount + "\n");
            writer.write("Количесво страниц: " + pageCount + "\n");
        }
        // Проверка на ошибку при записи данных в файл
        catch (IOException e) {
            System.err.println("Данные не были записаны из-за ошибки: " + e.getMessage());
        }
    }
}