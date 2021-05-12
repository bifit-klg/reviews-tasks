public class Main {
    private static UserInputScanner userInput = new UserInputScanner();

    public static void main (String[] args) throws Exception {
        task1();
        task2();
        task3();
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
}

