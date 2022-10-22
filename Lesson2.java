
/**
 * Lesson2
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson2 {
    // 1.

    public static void window(String Text1, String Text2) {
        Pattern pattern = Pattern.compile(Text2);
        Matcher matcher = pattern.matcher(Text1);
        while (matcher.find()) {
            System.out.println(Text1.substring(matcher.start(), matcher.end()));
        }
    }

    // 2.
    public static boolean searchPalindrom(String Str1, String Str2) {
        return Str1.equals(new StringBuilder(Str2).reverse().toString());
    }

    // 3.
    public static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    // 4.
    public static String compilerMathToStr(int a, int b, char sign) {
        StringBuilder mathTask = new StringBuilder();
        mathTask.append(a).append(" ").append(sign).append(" ").append(b).append(" = ");
        switch (sign) {
            case '+':
                mathTask.append(a + b);
                break;
            case '-':
                mathTask.append(a - b);
                break;
            case '*':
                mathTask.append(a * b);
                break;
        }
        return mathTask.toString();
    }

    // 5.
    public static String replacEqual(String mathTask) {
        StringBuilder task = new StringBuilder(mathTask);
        int index = task.indexOf("=");
        return task.deleteCharAt(index).insert(index, "равно").toString();
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите строку 1: ");
        String str1 = iScanner.nextLine();
        System.out.printf("Введите строку 2: ");
        String str2 = iScanner.nextLine();
        iScanner.close();

        // 1
        System.out.println(
                "1.\nНаименьшие окна строки 1, содержащие все символы строки 2: ");
        window(str1, str2);

        // 2
        System.out.println();
        if (searchPalindrom(str1, str2)) {
            System.out.println("2.\nCтроки являются вращением друг друга");
        } else
            System.out.println("2.\nCтроки не являются вращением друг друга");

        // 3
        System.out.println();
        System.out.printf("3.\nПереворачиваем строку 1: %s\n", reverse(str1));
        System.out.printf("Переворачиваем строку 2: %s\n", reverse(str2));

        // 4
        System.out.println();
        System.out.println("4.\nСтроки с примерами:");
        int a = 3, b = 56;
        System.out.println(compilerMathToStr(a, b, '+'));
        System.out.println(compilerMathToStr(a, b, '-'));
        System.out.println(compilerMathToStr(a, b, '*'));

        // 5
        System.out.println();
        System.out.println("5.\nЗаменяем знака '=' на слово равно.");
        System.out.println(replacEqual(compilerMathToStr(a, b, '+')));

    }
}