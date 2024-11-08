package input;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        String filePath = "learn/src/input/test.txt"; //путь к файлу
        validateFile(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) { //создаю буффер, в котором использую FileReader для чтения файла
            String string;
            int lineCount = 0;
            int charCount = 0;
            int wordCount = 0;
            while ((string = reader.readLine()) != null) {
                lineCount++; //прибавляем каунт строки
                charCount += string.length(); //прибавляем каунт символов
                StringTokenizer tokenizer = new StringTokenizer(string); //используем токенайзер, который разделяет строку на подстроки (слова)
                wordCount += tokenizer.countTokens(); //используем метод подсчета подстрок и прибавляем их каждый раз к числу слов
            }

            System.out.println("Количество строк в файле: " + lineCount);
            System.out.println("Количество символов в файле (без учета переноса строки): " + charCount);
            charCount += lineCount - 1; //если надо с переносом, надо вручную к charCount выше прибавлять 1 в цикле или вот так
            System.out.println("Количество символов в файле (с учетом переноса строки): " + charCount);
            System.out.println("Количество слов в файле: " + wordCount);

        } catch (FileNotFoundException e) { //ловлю ошибку "не найдено"
            System.out.println("Error. File not found!");
        } catch (IOException e) { //ловлю остальные любые ошибки ввода-вывода
            System.out.println("Error. File read error!");
        }
    }

    private static void validateFile(String filePath) { //сделал проверку на txt, тк буффер читает и картинки и тп))
        if (!filePath.endsWith(".txt")) { //проверка, заканчивается ли файл на txt
            System.out.println("Error. File is not a .txt file!");
            System.exit(1);
        }
    }
}
