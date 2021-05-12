public class Main {
    private static UserInputScanner userInput = new UserInputScanner();

    public static void main (String[] args) throws Exception {
        task1();
        task2();
    }

    private static void task1() {
        var calculator = new FactorialCalculator();
        long number = userInput.getUserNumber();
        System.out.println("Factorial is: " + calculator.calculate(number));
    }

    private static void task2() throws Exception {
        var userWordsFromLine = userInput.getUserLine();
        var filePath = userWordsFromLine[0];
        var wordToCount = userWordsFromLine[1];
        var fileReader = new FileReader();
        var lines = fileReader.readUserFile(filePath);
        var counter = new WordsCounter();
        System.out.println("Count is: " + counter.count(lines, wordToCount));
    }
}

