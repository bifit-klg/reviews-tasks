import java.util.Scanner;

class UserInputScanner {
    private Scanner scanner = new Scanner(System.in);

    long getUserNumber() {
        System.out.println("Enter your number:");

        return scanner.nextLong();
    }

    String[] getUserWords() {
        System.out.println("Enter your line:");
        var userLine = scanner.nextLine();
        var userWordsFromLine = userLine.split(" ");
        if (userWordsFromLine.length != 2) {
            throw new IllegalArgumentException();
        }

        return userWordsFromLine;
    }

    String getUserLine() {
        System.out.println("Enter your line:");

        return scanner.nextLine();
    }
}
