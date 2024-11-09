package input;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        String filePath = "learn/src/input/test.txt"; //путь к файлу
        validateFile(filePath);

        //создаю буффер, в котором использую FileReader для чтения файла
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            CountResultDto countResult = countWordsAndChars(reader);
            logResult(countResult);
        } catch (FileNotFoundException e) { //ловлю ошибку "не найдено"
            System.out.println("Error. File not found!");
        } catch (IOException e) { //ловлю остальные любые ошибки ввода-вывода
            System.out.println("Error. File read error!");
        }
    }

    private static CountResultDto countWordsAndChars(BufferedReader reader) throws IOException {
        String string;
        CountResultDto countResult = new CountResultDto();
        while ((string = reader.readLine()) != null) {
            countResult.setLineCount(countResult.getLineCount() + 1); //прибавляем каунт строки
            countResult.setCharCount(countResult.getCharCount() + string.length()); //прибавляем каунт символов

            //используем токенайзер, который разделяет строку на подстроки (слова)
            StringTokenizer tokenizer = new StringTokenizer(string);

            //используем метод подсчета подстрок и прибавляем их каждый раз к числу слов
            countResult.setWordCount(countResult.getWordCount() + tokenizer.countTokens());
        }
        return countResult;
    }

    private static void logResult(CountResultDto countResult) {
        System.out.println("Количество строк в файле: " + countResult.getLineCount());
        System.out.println("Количество символов в файле (без учета переноса строки): " + countResult.getCharCount());
        countResult.setCharCount(countResult.getCharCount() + countResult.getLineCount() - 1);

        //если надо с переносом, надо вручную к charCount выше прибавлять 1 в цикле или вот так
        System.out.println("Количество символов в файле (с учетом переноса строки): " + countResult.getCharCount());
        System.out.println("Количество слов в файле: " + countResult.getWordCount());
    }

    private static void validateFile(String filePath) { //сделал проверку на txt, тк буффер читает и картинки и тп))
        if (!filePath.endsWith(".txt")) { //проверка, заканчивается ли файл на txt
            System.out.println("Error. File is not a .txt file!");
            System.exit(1);
        }
    }
}
