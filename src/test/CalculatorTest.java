import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        var calculator = new Calculator();
        assertEquals(calculator.calculate("2+1"), BigDecimal.valueOf(3));
        assertEquals(calculator.calculate("2.0+1.3"), BigDecimal.valueOf(3.3));
        assertEquals(calculator.calculate("2-1"), BigDecimal.valueOf(1));
        assertEquals(calculator.calculate("2.0-1.3"), BigDecimal.valueOf(0.7));
        assertEquals(calculator.calculate("2/1"), BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP));
        assertEquals(calculator.calculate("2.0/1"), BigDecimal.valueOf(2.00).setScale(2, RoundingMode.HALF_UP));
        assertEquals(calculator.calculate("2*1"), BigDecimal.valueOf(2));
        assertEquals(calculator.calculate("2*1.0"), BigDecimal.valueOf(2.00));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(null));
        assertThrows(ArithmeticException.class, () -> calculator.calculate("10/0"));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("10--10"));
    }
}