package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for subtracting one {@link Fraction} from another.
 */
public class SubtractFractionsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void Given_WholeNumbers_When_Minus_Expect_CorrectResult() {
        assertThat(Fraction.of(1).minus(Fraction.of(1))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0).minus(Fraction.of(5))).isEqualTo(Fraction.of(-5));
        assertThat(Fraction.of(7).minus(Fraction.of(4))).isEqualTo(Fraction.of(3));
        assertThat(Fraction.of(4).minus(Fraction.of(7))).isEqualTo(Fraction.of(-3));
    }

    @Test
    public void Given_ZeroAndAnotherWholeNumber_When_FractionMinus_Expect_CorrectResult() {
        assertThat(Fraction.of(0).minus(Fraction.of(0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(5).minus(Fraction.of(0))).isEqualTo(Fraction.of(5));
        assertThat(Fraction.of(0).minus(Fraction.of(5))).isEqualTo(Fraction.of(-5));
        
        assertThat(Fraction.of(7).minus(Fraction.of(0))).isEqualTo(Fraction.of(7));
        assertThat(Fraction.of(0).minus(Fraction.of(7))).isEqualTo(Fraction.of(-7));
    }

    @Test
    public void Given_NegativeZeroAndAnotherWholeNumber_When_FractionMinus_Expect_CorrectResult() {
        assertThat(Fraction.of(-0).minus(Fraction.of(0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0).minus(Fraction.of(-0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(-0).minus(Fraction.of(-0))).isEqualTo(Fraction.of(0));

        assertThat(Fraction.of(-0).minus(Fraction.of(5))).isEqualTo(Fraction.of(-5));
        assertThat(Fraction.of(5).minus(Fraction.of(-0))).isEqualTo(Fraction.of(5));
        
        assertThat(Fraction.of(-0).minus(Fraction.of(-5))).isEqualTo(Fraction.of(5));
        assertThat(Fraction.of(-5).minus(Fraction.of(-0))).isEqualTo(Fraction.of(-5));
    }

    @Test
    public void Given_NegativeWholeNumberAndAnotherNumber_When_FractionMinus_Expect_CorrectResult() {
        assertThat(Fraction.of(-5).minus(Fraction.of(0))).isEqualTo(Fraction.of(-5));
        assertThat(Fraction.of(0).minus(Fraction.of(-5))).isEqualTo(Fraction.of(5));
        
        assertThat(Fraction.of(-7).minus(Fraction.of(4))).isEqualTo(Fraction.of(-11));
        assertThat(Fraction.of(4).minus(Fraction.of(-7))).isEqualTo(Fraction.of(11));
        assertThat(Fraction.of(-4).minus(Fraction.of(-7))).isEqualTo(Fraction.of(3));
    }
    
    @Test
    public void When_ZeroMinusZero_Then_ExpectZero() {
        assertThat(Fraction.of(0).minus(Fraction.of(0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0, 2).minus(Fraction.of(0, 3))).isEqualTo(Fraction.of(0));
    }

    @Test
    public void Given_WholeNumberAndFraction_When_FractionMinus_Expect_CorrectResult() {
        assertThat(Fraction.of(1).minus(Fraction.of(1, 2))).isEqualTo(Fraction.of(1, 2));
        assertThat(Fraction.of(1, 2).minus(Fraction.of(1))).isEqualTo(Fraction.of(-1, 2));
        assertThat(Fraction.of(1).minus(Fraction.of(1, 1))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(5).minus(Fraction.of(4, 3))).isEqualTo(Fraction.of(11, 3));
        assertThat(Fraction.of(4, 3).minus(Fraction.of(5))).isEqualTo(Fraction.of(-11, 3));
    }

    @Test
    public void When_SubtractTwoFractionsWithoutReduction_Then_ResultAsExpected() {
        assertThat(Fraction.of(7, 3).minus(Fraction.of(4, 5))).isEqualTo(Fraction.of(23, 15));
    }

    @Test
    public void When_SubtractTwoFractionsWithReduction_Then_ResultAsExpected() {
        assertThat(Fraction.of(3, 2).minus(Fraction.of(3, 4))).isEqualTo(Fraction.of(3, 4));
        assertThat(Fraction.of(1, 6).minus(Fraction.of(1, 2))).isEqualTo(Fraction.of(-1, 3));
        assertThat(Fraction.of(1, 2).minus(Fraction.of(1, 2))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(5, 4).minus(Fraction.of(1, 4))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(1, 4).minus(Fraction.of(2, 3))).isEqualTo(Fraction.of(-5, 12));
        assertThat(Fraction.of(5, 8).minus(Fraction.of(1, 8))).isEqualTo(Fraction.of(1, 2));
        assertThat(Fraction.of(2, 3).minus(Fraction.of(5, 12))).isEqualTo(Fraction.of(1, 4));
    }

    @Test
    public void When_SubtractTwoNegativeFractionsWithReduction_Then_ResultAsExpected() {
        assertThat(Fraction.of(-5, 4).minus(Fraction.of(-3, 4))).isEqualTo(Fraction.of(-1, 2));
    }

    @Test
    public void When_WholeNumberMinusZeroFraction_Then_ResultAsExpected() {
        assertThat(Fraction.of(1).minus(Fraction.of(0, 2))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(1).minus(Fraction.of(-0, 2))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(1).minus(Fraction.of(0, -2))).isEqualTo(Fraction.of(1));
    }
    
}
