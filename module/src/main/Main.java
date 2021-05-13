public class Main {
    private static UserInputScanner userInput = new UserInputScanner();

    public static void main (String[] args) throws Exception {
        task1();
        task2();
        task3();
        task4();
    }

    private static void task1() {
        var calculator = new FactorialCalculator();
        long number = userInput.getUserNumber();
        System.out.println("Factorial is: " + calculator.calculate(number));
    }

    private static void task2() throws Exception {
        var userWordsFromLine = userInput.getUserWords();
        var filePath = userWordsFromLine[0];
        var wordToCount = userWordsFromLine[1];
        var fileReader = new FileReader();
        var lines = fileReader.readUserFile(filePath);
        var counter = new WordsCounter();
        System.out.println("Count is: " + counter.count(lines, wordToCount));
    }

    private static void task3() {
        var userLine = userInput.getUserLine();
        var calculator = new Calculator();
        System.out.println("Answer is: " + calculator.calculate(userLine));
    }

    private static void task4() throws Exception {
        var sourceName = userInput.getUserLine();
        var targetName = userInput.getUserLine();
        var copier = new Copier();
        System.out.println("Your time is: " + copier.copy(sourceName, targetName) + " (mm:ss:mils)");
    }
}

