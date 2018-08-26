package mpinard.jbrains.tdd.fraction;

import lombok.Value;

import java.beans.ConstructorProperties;

@Value
public class Fraction {
    private int numerator;
    private int denominator;

    @ConstructorProperties({"numerator", "denominator"})
    private Fraction(final int numerator, final int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator cannot be zero");
        }

        this.numerator = isPositive(numerator, denominator) ? Math.abs(numerator) : Math.negateExact(Math.abs(numerator));
        this.denominator = Math.abs(denominator);
    }

    public static Fraction of(final int wholeNumber) {
        return Fraction.of(wholeNumber, 1);
    }

    public static Fraction of(final int theNumerator, final int theDenominator) {
        return new Fraction(theNumerator, theDenominator);
    }

    private static Fraction from(final SimpleFraction simpleFraction) {
        return Fraction.of(simpleFraction.numerator, simpleFraction.denominator);
    }

    private boolean isPositive(final int theNumerator, final int theDenominator) {
        return theNumerator >= 0
            ? theDenominator > 0
            : theDenominator < 0;
    }
    
    public Fraction plus(final Fraction addend) {
        return Fraction.from(this.toSimpleFraction().plus(addend.toSimpleFraction()));
    }
    
    private SimpleFraction toSimpleFraction() {
        return SimpleFraction.of(numerator, denominator);
    }
    
    public String toString() {
        return denominator == 1
            ? String.valueOf(numerator)
            : String.format("%s/%s", numerator, denominator);
    }
    
    @Value(staticConstructor = "of")
    private static class SimpleFraction {
        private int numerator;
        private int denominator;
        
        private SimpleFraction plus(final SimpleFraction addend) {
            final SimpleFraction resolvedAugend;
            final SimpleFraction resolvedAddend;

            if (denominator == addend.denominator) {
                resolvedAugend = this;
                resolvedAddend = addend;
            } else {
                final int commonDenominator = this.denominator * addend.denominator;

                resolvedAugend =
                    SimpleFraction.of(
                        this.numerator * addend.denominator,
                        commonDenominator);
                resolvedAddend =
                    SimpleFraction.of(
                        addend.numerator * this.denominator,
                        commonDenominator);
            }

            return SimpleFraction.of(resolvedAugend.numerator + resolvedAddend.numerator, resolvedAugend.denominator);
        }
        
    }
    
}

