package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for dividing one {@link Fraction} by another.
 */
public class DivideFractionsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void Given_One_When_DividedByZero_Then_ExceptionThrown() {
        performDivideByZeroTestFor(Fraction.of(1));
    }

    @Test
    public void Given_Zero_When_DividedByZero_Then_ExceptionThrown() {
        performDivideByZeroTestFor(Fraction.of(0));
    }

    @Test
    public void Given_WholeNumber_When_DividedByZero_Then_ExceptionThrown() {
        performDivideByZeroTestFor(Fraction.of(5));
    }

    @Test
    public void Given_NonWholeFraction_When_DividedByZero_Then_ExceptionThrown() {
        performDivideByZeroTestFor(Fraction.of(7, 3));
    }

    @Test
    public void Given_NegativeFraction_When_DividedByZero_Then_ExceptionThrown() {
        performDivideByZeroTestFor(Fraction.of(-1, 3));
    }

    @Test
    public void Given_Fraction_When_DividedByNegativeZero_Then_ExceptionThrown() {
        exception.expect(java.lang.ArithmeticException.class);
        exception.expectMessage("/ by zero");

        Fraction.of(5, 3).dividedBy(Fraction.of(-0));
    }

    private void performDivideByZeroTestFor(final Fraction dividend) {
        exception.expect(java.lang.ArithmeticException.class);
        exception.expectMessage("/ by zero");

        dividend.dividedBy(Fraction.of(0));
    }
    
    @Test
    public void Given_TwoWholeNumbers_When_FractionDividedBy_Expect_CorrectResult() {
        assertThat(Fraction.of(15).dividedBy(Fraction.of(3))).isEqualTo(Fraction.of(5));
        assertThat(Fraction.of(12).dividedBy(Fraction.of(4))).isEqualTo(Fraction.of(3));
        assertThat(Fraction.of(3).dividedBy(Fraction.of(1))).isEqualTo(Fraction.of(3));
        assertThat(Fraction.of(1).dividedBy(Fraction.of(9))).isEqualTo(Fraction.of(1, 9));
        assertThat(Fraction.of(9).dividedBy(Fraction.of(18))).isEqualTo(Fraction.of(1, 2));
    }

    @Test
    public void Given_TwoNonWholeFractions_When_FractionDividedBy_Expect_CorrectResult() {
        assertThat(Fraction.of(1, 4).dividedBy(Fraction.of(1, 4))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(2, 3).dividedBy(Fraction.of(3, 5))).isEqualTo(Fraction.of(10, 9));
        assertThat(Fraction.of(2, 3).dividedBy(Fraction.of(4, 5))).isEqualTo(Fraction.of(5, 6));
    }

    @Test
    public void Given_WholeNumberAndNonWholeFraction_When_FractionDividedBy_Expect_CorrectResult() {
        assertThat(Fraction.of(4).dividedBy(Fraction.of(1, 4))).isEqualTo(Fraction.of(16));
        assertThat(Fraction.of(1, 3).dividedBy(Fraction.of(3))).isEqualTo(Fraction.of(1, 9));
        assertThat(Fraction.of(3).dividedBy(Fraction.of(1, 3))).isEqualTo(Fraction.of(9));
    }

    @Test
    public void Given_AtLeastOneNegativeFraction_When_FractionDividedBy_Expect_CorrectResult() {
        assertThat(Fraction.of(-4).dividedBy(Fraction.of(1, 4))).isEqualTo(Fraction.of(-16));
        assertThat(Fraction.of(1, 3).dividedBy(Fraction.of(-3))).isEqualTo(Fraction.of(-1, 9));
        assertThat(Fraction.of(-3).dividedBy(Fraction.of(-1, 3))).isEqualTo(Fraction.of(9));
    }
}
