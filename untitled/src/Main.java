import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException, ScriptException {
        String fileName = "D:/Новый текстовый документ.txt";

        System.out.println("Калькулятор " + calculator("7+5"));
        System.out.println("Факториал " + factorial(10));
        System.out.println("Вхождение слова " + findWordEntries(fileName, "devcon.exe"));
        System.out.println("Копирование файла" + timeForFileCopying(fileName, "D:/new"));
    }


    /*Задание 1: факториал*/
    static int factorial(int number) {
        if (number <= 1) return 1;
        else return IntStream.rangeClosed(2, number)
                .reduce(((left, right) -> left * right))
                .getAsInt();
    }


    /*Задание 2: количество вхождений в слове*/
    static long findWordEntries(String fileName, String word) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(fileName)));
        return  Arrays.stream(text.split(" "))
                .filter( w -> w.equals(word))
                .count();
    }


    /*Задание 3: калькулятор*/
    static double calculator(String expression) throws ScriptException {
        return Double.parseDouble(String.valueOf(new ScriptEngineManager().getEngineByName("JavaScript").eval(expression)));
    }


    /*Задание 4: копирование файла*/
    static long timeForFileCopying(String inputFileName, String outputFileName) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        long start = System.nanoTime();

        try {
            is = new FileInputStream(new File(inputFileName));
            os = new FileOutputStream(new File(outputFileName));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            is.close();
            os.close();
        }
        long finish = System.nanoTime();

        return finish - start;
    }
}
