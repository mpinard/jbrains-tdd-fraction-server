package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void When_ZeroDenominator_Then_IllegalArgumentException() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("The denominator cannot be zero");
        
        Fraction.of(1, 0);
    }
    
    @Test
    public void When_FractionCreated_Then_FractionReduced() {
        final Fraction twoFourths = Fraction.of(2, 4);
        assertThat(twoFourths).isEqualTo(Fraction.of(1, 2));
        assertThat(twoFourths.getNumerator()).isEqualTo(1);
        assertThat(twoFourths.getDenominator()).isEqualTo(2);

        final Fraction threeNineths = Fraction.of(3, 9);
        assertThat(threeNineths).isEqualTo(Fraction.of(1, 3));
        assertThat(threeNineths.getNumerator()).isEqualTo(1);
        assertThat(threeNineths.getDenominator()).isEqualTo(3);

        final Fraction nineThirds = Fraction.of(9, 3);
        assertThat(nineThirds).isEqualTo(Fraction.of(3));
        assertThat(nineThirds.getNumerator()).isEqualTo(3);
        assertThat(nineThirds.getDenominator()).isEqualTo(1);
        
        final Fraction elevenElevenths = Fraction.of(11, 11);
        assertThat(elevenElevenths).isEqualTo(Fraction.of(1));
        assertThat(elevenElevenths.getNumerator()).isEqualTo(1);
        assertThat(elevenElevenths.getDenominator()).isEqualTo(1);
        
        final int bigMultiplier = 2 * 2 * 3 * 5 * 5 * 7 * 13;
        final Fraction bigFractionReduced = Fraction.of(bigMultiplier * 2, bigMultiplier * 3);
        assertThat(bigFractionReduced).isEqualTo(Fraction.of(2, 3));
        assertThat(bigFractionReduced.getNumerator()).isEqualTo(2);
        assertThat(bigFractionReduced.getDenominator()).isEqualTo(3);
    }
    
    @Test
    public void Given_FractionWithDenominator_When_ToString_Then_FormatIsAsExpected() {
        assertThat(Fraction.of(1, 2).toString()).isEqualTo("1/2");
        assertThat(Fraction.of(3, 4).toString()).isEqualTo("3/4");
        assertThat(Fraction.of(7, 8).toString()).isEqualTo("7/8");
        assertThat(Fraction.of(-7, 8).toString()).isEqualTo("-7/8");
        assertThat(Fraction.of(7, -8).toString()).isEqualTo("-7/8");
        assertThat(Fraction.of(-7, -8).toString()).isEqualTo("7/8");
        assertThat(Fraction.of(-0, -1).toString()).isEqualTo("0");
        assertThat(Fraction.of(-1, -1).toString()).isEqualTo("1");
    }

    @Test
    public void Given_WholeNumberFraction_When_ToString_Then_FormatIsAsExpected() {
        assertThat(Fraction.of(-0).toString()).isEqualTo("0");
        assertThat(Fraction.of(0).toString()).isEqualTo("0");
        assertThat(Fraction.of(1).toString()).isEqualTo("1");
        assertThat(Fraction.of(5).toString()).isEqualTo("5");
        assertThat(Fraction.of(-5).toString()).isEqualTo("-5");
    }

    @Test
    public void When_CreatedWithNegativeWholeNumber_Then_ResultIsNegative() {
        assertThat(Fraction.of(-1)).isEqualTo(Fraction.of(-1));
        assertThat(Fraction.of(-5)).isEqualTo(Fraction.of(-5));
    }

    @Test
    public void When_CreatedWithNegativeNumerator_Then_ResultIsNegative() {
        assertThat(Fraction.of(-0, 1)).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(-1, 1)).isEqualTo(Fraction.of(-1, 1));
        assertThat(Fraction.of(-1, 5)).isEqualTo(Fraction.of(-1, 5));
    }
    
    @Test
    public void When_CreatedWithNegativeDenominator_Then_ResultIsNegative() {
        assertThat(Fraction.of(0, -1)).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(1, -1)).isEqualTo(Fraction.of(-1, 1));
        assertThat(Fraction.of(1, -5)).isEqualTo(Fraction.of(-1, 5));
    }

    @Test
    public void When_CreatedWithNegativeNumeratorAndDenominator_Then_ResultIsPositive() {
        assertThat(Fraction.of(-0, -1)).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(-1, -1)).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(-1, -5)).isEqualTo(Fraction.of(1, 5));
        assertThat(Fraction.of(-7, -8)).isEqualTo(Fraction.of(7, 8));
    }
    
    @Test
    public void When_ZeroPlusZero_Then_ExpectZero() {
        assertThat(Fraction.of(0).plus(Fraction.of(0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0, 2).plus(Fraction.of(0, 3))).isEqualTo(Fraction.of(0));
    }
    
    @Test
    public void When_AddPositiveWholeNumbers_Then_ResultAsExpected() {
        assertThat(Fraction.of(1).plus(Fraction.of(1))).isEqualTo(Fraction.of(2));
        assertThat(Fraction.of(3).plus(Fraction.of(5))).isEqualTo(Fraction.of(8));
        assertThat(Fraction.of(4).plus(Fraction.of(9))).isEqualTo(Fraction.of(13));
    }

    @Test
    public void When_AddWholeNumbersWithNegative_Then_ResultAsExpected() {
        assertThat(Fraction.of(1).plus(Fraction.of(-1))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(5).plus(Fraction.of(-3))).isEqualTo(Fraction.of(2));
        assertThat(Fraction.of(3).plus(Fraction.of(-5))).isEqualTo(Fraction.of(-2));
        assertThat(Fraction.of(-5).plus(Fraction.of(3))).isEqualTo(Fraction.of(-2));
        assertThat(Fraction.of(4).plus(Fraction.of(9))).isEqualTo(Fraction.of(13));
        assertThat(Fraction.of(1).plus(Fraction.of(0))).isEqualTo(Fraction.of(1));
    }
    
    @Test
    public void When_AddWholeNumberToFraction_Then_ResultAsExpected() {
        assertThat(Fraction.of(1).plus(Fraction.of(1, 2))).isEqualTo(Fraction.of(3, 2));
        assertThat(Fraction.of(1, 2).plus(Fraction.of(1))).isEqualTo(Fraction.of(3, 2));
        assertThat(Fraction.of(1).plus(Fraction.of(1, 1))).isEqualTo(Fraction.of(2));
        assertThat(Fraction.of(5).plus(Fraction.of(4, 3))).isEqualTo(Fraction.of(19, 3));
        assertThat(Fraction.of(4, 3).plus(Fraction.of(5))).isEqualTo(Fraction.of(19, 3));
    }
    
    @Test
    public void When_AddTwoFractionsWithoutReduction_Then_ResultAsExpected() {
        assertThat(Fraction.of(7, 3).plus(Fraction.of(4, 5))).isEqualTo(Fraction.of(47, 15));
    }

    @Test
    public void When_AddTwoFractionsWithReduction_Then_ResultAsExpected() {
        assertThat(Fraction.of(1, 2).plus(Fraction.of(3, 4))).isEqualTo(Fraction.of(5, 4));
        assertThat(Fraction.of(1, 6).plus(Fraction.of(1, 2))).isEqualTo(Fraction.of(2, 3));
        assertThat(Fraction.of(1, 2).plus(Fraction.of(1, 2))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(2, 4).plus(Fraction.of(2, 4))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(1, 4).plus(Fraction.of(2, 3))).isEqualTo(Fraction.of(11, 12));
        assertThat(Fraction.of(3, 8).plus(Fraction.of(1, 8))).isEqualTo(Fraction.of(1, 2));
        assertThat(Fraction.of(1, 4).plus(Fraction.of(5, 12))).isEqualTo(Fraction.of(2, 3));
    }

    @Test
    public void When_AddTwoNegativeFractionsWithReduction_Then_ResultAsExpected() {
        assertThat(Fraction.of(-1, 2).plus(Fraction.of(-3, 4))).isEqualTo(Fraction.of(-5, 4));
    }

    @Test
    public void When_WholeNumberPlusZeroFraction_Then_ResultAsExpected() {
        assertThat(Fraction.of(1).plus(Fraction.of(0, 2))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(1).plus(Fraction.of(-0, 2))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(1).plus(Fraction.of(0, -2))).isEqualTo(Fraction.of(1));
    }
}
