package mpinard.jbrains.tdd.fraction;

import lombok.Value;
import lombok.experimental.NonFinal;

import java.beans.ConstructorProperties;
import java.lang.ref.WeakReference;

@Value
public class Fraction {
    private int numerator;
    private int denominator;

    @ConstructorProperties({"numerator", "denominator"})
    private Fraction(final int numerator, final int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator cannot be zero");
        }

        int signedNumerator = isPositive(numerator, denominator) ? Math.abs(numerator) : Math.negateExact(Math.abs(numerator));
        int signedDenominator = Math.abs(denominator);
        int greatestCommonDivisor = Numbers.gcd(signedNumerator, signedDenominator);
        
        this.numerator = signedNumerator / greatestCommonDivisor;
        this.denominator = signedDenominator / greatestCommonDivisor;
    }

    public static Fraction of(final int wholeNumber) {
        return Fraction.of(wholeNumber, 1);
    }

    public static Fraction of(final int theNumerator, final int theDenominator) {
        return new Fraction(theNumerator, theDenominator);
    }

    public Fraction plus(final Fraction addend) {
        if (denominator == addend.denominator) {
            return Fraction.of(numerator + addend.numerator, denominator);
        }
        
        return Fraction.of(
            (this.numerator * addend.denominator) + (addend.numerator * this.denominator),
            this.denominator * addend.denominator);
    }

    @Override
    public String toString() {
        return denominator == 1
            ? String.valueOf(numerator)
            : String.format("%s/%s", numerator, denominator);
    }

    private boolean isPositive(final int theNumerator, final int theDenominator) {
        return theNumerator >= 0
            ? theDenominator > 0
            : theDenominator < 0;
    }
}

