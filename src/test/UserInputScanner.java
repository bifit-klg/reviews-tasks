import java.util.Scanner;

class UserInputScanner {
    long getUserNumber() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter your number:");

        return scanner.nextLong();
    }

    String[] getUserLine() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter your line:");
        var userLine = scanner.nextLine();
        var userWordsFromLine = userLine.split(" ");
        if (userWordsFromLine.length != 2) {
            throw new IllegalArgumentException();
        }

        return userWordsFromLine;
    }
}
