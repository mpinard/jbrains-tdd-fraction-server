package mpinard.jbrains.tdd.fraction;

import lombok.Value;

import java.beans.ConstructorProperties;

@Value
public class Fraction {
    private int numerator;
    private int denominator;
    
    public static Fraction of(final int wholeNumber) {
        return Fraction.of(wholeNumber, 1);
    }

    public static Fraction of(final int theNumerator, final int theDenominator) {
        return new Fraction(theNumerator, theDenominator);
    }
    
    @ConstructorProperties({"numerator", "denominator"})
    private Fraction(final int numerator, final int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator cannot be zero");
        }
        
        this.numerator = isPositive(numerator, denominator) ? Math.abs(numerator) : Math.negateExact(Math.abs(numerator));
        this.denominator = Math.abs(denominator);
    }

    private boolean isPositive(final int theNumerator, final int theDenominator) {
        return theNumerator >= 0
            ? theDenominator > 0
            : theDenominator < 0;
    }
    
    public Fraction plus(final Fraction addend) {
        final Fraction resolvedAugend;
        final Fraction resolvedAddend;
        
        if (denominator == addend.denominator) {
            resolvedAugend = this;
            resolvedAddend = addend;
        } else {
            final int commonDenominator = this.denominator * addend.denominator;
            
            resolvedAugend =
                Fraction.of(
                    this.numerator * addend.denominator,
                    commonDenominator);
            resolvedAddend =
                Fraction.of(
                    addend.numerator * this.denominator,
                    commonDenominator);
        }
            
        return Fraction.of(resolvedAugend.numerator + resolvedAddend.numerator, resolvedAugend.denominator);
    }
    
    public String toString() {
        return denominator == 1
            ? String.valueOf(numerator)
            : String.format("%s/%s", numerator, denominator);
    }
    
}

