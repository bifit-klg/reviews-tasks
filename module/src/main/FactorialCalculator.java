import java.math.BigDecimal;
import java.util.stream.Stream;

class FactorialCalculator {
    BigDecimal calculate(long number) {
        return Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                .limit(number)
                .reduce(BigDecimal.ONE, BigDecimal::multiply);
    }
}
