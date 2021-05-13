import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void calculate() {
        var calculator = new FactorialCalculator();
        assertEquals(calculator.calculate(0), BigDecimal.valueOf(1));
        assertEquals(calculator.calculate(1), BigDecimal.valueOf(1));
        assertEquals(calculator.calculate(2), BigDecimal.valueOf(2));
        assertEquals(calculator.calculate(3), BigDecimal.valueOf(6));
        assertEquals(calculator.calculate(4), BigDecimal.valueOf(24));
        assertEquals(calculator.calculate(5), BigDecimal.valueOf(120));
        assertEquals(calculator.calculate(20), BigDecimal.valueOf(2432902008176640000L));
    }
}
