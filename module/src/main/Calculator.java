import java.math.BigDecimal;
import java.math.RoundingMode;

class Calculator {
    private final static String MULTIPLY = "*";
    private final static String MULTIPLY_ESCAPED = "\\*";
    private final static String DIVIDE = "/";
    private final static String ADD = "+";
    private final static String ADD_ESCAPED = "\\+";
    private final static String SUBTRACT = "-";
    private final static int RIGHT_VALUE_INDEX = 0;
    private final static int LEFT_VALUE_INDEX = 1;
    private String[] numbersFromLine;

    BigDecimal calculate(String userLine) {
        if (userLine == null) {
            throwException();
        }

        if (userLine.contains(MULTIPLY)) {
            numbersFromLine = splitWords(userLine, MULTIPLY_ESCAPED);
            guardThatThereIsTwoValues();
            return getNumber(RIGHT_VALUE_INDEX).multiply(getNumber(LEFT_VALUE_INDEX));
        } else if (userLine.contains(DIVIDE)) {
            numbersFromLine = splitWords(userLine, DIVIDE);
            guardThatThereIsTwoValues();
            return getScaledNumber(RIGHT_VALUE_INDEX).divide(getScaledNumber(LEFT_VALUE_INDEX), RoundingMode.HALF_UP);
        } else if (userLine.contains(ADD)) {
            numbersFromLine = splitWords(userLine, ADD_ESCAPED);
            guardThatThereIsTwoValues();
            return getNumber(RIGHT_VALUE_INDEX).add(getNumber(LEFT_VALUE_INDEX));
        } else if (userLine.contains(SUBTRACT)) {
            numbersFromLine = splitWords(userLine, SUBTRACT);
            guardThatThereIsTwoValues();
            return getNumber(RIGHT_VALUE_INDEX).subtract(getNumber(LEFT_VALUE_INDEX));
        } else {
            throwException();
        }

        return BigDecimal.ZERO;
    }

    private String[] splitWords(String userLine, String subtract) {
        return userLine.split(subtract);
    }

    private void guardThatThereIsTwoValues() {
        if (numbersFromLine.length != 2) {
            throwException();
        }
    }

    private BigDecimal getScaledNumber(int index) {
        return getNumber(index).setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal getNumber(int index) {
        return new BigDecimal(numbersFromLine[index]);
    }

    private void throwException() {
        throw new IllegalArgumentException("Dont know what to do");
    }
}
