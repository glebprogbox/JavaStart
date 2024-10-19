заменяем в строке / на \ (// потому что экранирование)
```
Scanner console = new Scanner(System.in);
String path = console.nextLine();

char[] chars = path.toCharArray();
for (int i = 0; i < chars.length; i++)
   if (chars[i] == '/')
      chars[i] = '\\';

String result = new String(chars);
System.out.println(result);
```
второй вариант, через разделение строки с помощью /, далее объединяем с помощью \\ (экранирование \)
```
Scanner console = new Scanner(System.in);
String path = console.nextLine();

String[] array = path.split("/");

String result = String.join("\\", array);

System.out.println(result);
```
еще вариант, используем замену символа / на \ 
```
Scanner console = new Scanner(System.in);
String path = console.nextLine();

String result = path.replace('/', '\\');

System.out.println(result);
```
проверка на формат файла
```
Scanner console = new Scanner(System.in);
String path = console.nextLine();

if (path.endsWith(".jpg") || path.endsWith(".jpeg"))
{
   System.out.println("Это Jpeg!");
}
else if (path.endsWith(".htm") || path.endsWith(".html"))
{
   System.out.println("Это HTML-страница");
}
else if (path.endsWith(".doc") || path.endsWith(".docx"))
{
   System.out.println("Это документ Word");
}
else
{
   System.out.println("Неизвестный формат");
}
```
проверяем url
```
public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        if(url.startsWith("https:") || url.startsWith("http:"))
        {
            String[] array = url.split(":");
            return(array[0]);
        }
        return "неизвестный";
    }

    public static String checkDomain(String url) {
        if(url.endsWith(".com") || url.endsWith(".net") || url.endsWith(".org") || url.endsWith(".ru"))
        {
            String[] array = url.split("\\.");
            return(array[(array.length-1)]); //можно еще укоротить, сразу у url.split писать номер массива
        }
        else
        {
        return "неизвестный";
        }
    }
}
```
Scanner console = new Scanner(System.in);
String path = console.nextLine();

int index = path.indexOf("//");
int index2 = path.indexOf("/", index + 2);

String first = path.substring(0, index + 2);
String last = path.substring(index2);

String result = first + "javarush.com" + last;
System.out.println(result);
```
выводим первый индекс попавшегося слова код в начале строки и далее первый индекс попавшегося слова код с конца строки
```
public class Solution {
    public static void main(String[] args) {
        String string = "Чтобы стать программистом, нужно писать код. Чтобы писать код, нужно учиться. Чтобы учиться, нужно желание.";
        String word = "код";
        int indexFromFirstWord = getIndexFromFirstWord(string, word);
        int indexFromLastWord = getIndexFromLastWord(string, word);
        System.out.println("Индекс первого символа первого слова \"" + word + "\" равен - " + indexFromFirstWord);
        System.out.println("Индекс первого символа последнего слова \"" + word + "\" равен - " + indexFromLastWord);
    }

    public static int getIndexFromFirstWord(String string, String word) {
        int index = string.indexOf(word);
        return index;
    }

    public static int getIndexFromLastWord(String string, String word) {
        int index = string.lastIndexOf(word);
        return index;
    }
}
```
обновление пути
```
public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        String ret = path.replaceAll("/jdk.+?/",("/" + jdk + "/"));
        return (ret);
    }
}
```
или
```
public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        int firstIndex = path.indexOf("jdk");
        int lastIndex = path.indexOf("/", firstIndex);
        String oldJdk = path.substring(firstIndex, lastIndex);

        return path.replace(oldJdk, jdk);
    }
}
```
String str = "Good news everyone!";

StringTokenizer tokenizer = new StringTokenizer(str,"ne");
while (tokenizer.hasMoreTokens())
{
   String token = tokenizer.nextToken();
   System.out.println(token);
}
```
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer mym = new StringTokenizer(query, delimiter);
        int c = mym.countTokens();
        String[] array = new String[c];
        for(int i =0; i < c; i++)
        {
            array[i] = mym.nextToken();
        }
        return array;
    }
}
```
public class Solution {
    public static void main(String[] args) {
        System.out.println(format("Амиго", 5000));
    }

    public static String format(String name, int salary) {
        String phrase = "Меня зовут . Я буду зарабатывать $ в месяц.";
        String str = phrase.format("Меня зовут %s. Я буду зарабатывать $%d в месяц.", name, salary);
        return str;
    }
}
```
public class Solution {
    public static void main(String[] args) {
        String first = new String("JavaRush");
        String second = new String("JavaRush");
        String third = new String("javarush");
        System.out.println(equal(first, second));
        System.out.println(equal(second, third));
    }

    public static boolean equal(String first, String second) {
        String s1 = first.intern();
        String s2 = second.intern();
        boolean result = s1 == s2;
        return result;
    }
}
```
public class Solution {
    public static void main(String[] args) {
        String string = "Учиться, учиться и еще раз учиться! ";

        System.out.println(addTo(string, new String[]{"Под ", "лежачий ", "камень ", "вода ", "не ", "течет"}));
        System.out.println(replace(string, ", ", 16, 27));
    }

    public static StringBuilder addTo(String string, String[] strings) {
        StringBuilder str = new StringBuilder(string);
        for(int i = 0; i <strings.length; i++)
        {
            str = str.append(strings[i]);
        }
        return str;
    }

    public static StringBuilder replace(String string, String str, int start, int end) {
        StringBuilder str2 = new StringBuilder(string);
        str2 = str2.replace(start, end, str);
        return str2;
    }
}
```
или
public class Solution {
    public static void main(String[] args) {
        String string = "Учиться, учиться и еще раз учиться! ";

        System.out.println(addTo(string, new String[]{"Под ", "лежачий ", "камень ", "вода ", "не ", "течет"}));
        System.out.println(replace(string, ", ", 16, 27));
    }

    public static StringBuilder addTo(String string, String[] strings) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder;
    }

    public static StringBuilder replace(String string, String str, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.replace(start, end, str);
    }
}
```
разворот строки
```
public class Solution {
    public static void main(String[] args) {
        String string = "Ходит кот задом наперед";
        System.out.println(string);
        System.out.println(reverseString(string));
    }

    public static String reverseString(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        return stringBuilder.reverse().toString(); // можно и так return new StringBuilder(string).reverse().toString();
    }
}
```
