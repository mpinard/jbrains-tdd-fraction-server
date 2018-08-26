package mpinard.jbrains.tdd.fraction;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Value(staticConstructor = "of")
public class Fraction {
    private int numerator;
    private int denominator;
    
    public static Fraction of(final int wholeNumber) {
        return Fraction.of(wholeNumber, 1);
    }
    
    public Fraction plus(final Fraction addend) {
        return Fraction.of(numerator + addend.numerator, denominator);
    }
    
    public String toString() {
        return denominator == 1
            ? String.valueOf(numerator)
            : String.format("%s/%s", numerator, denominator);
    }
    
}

