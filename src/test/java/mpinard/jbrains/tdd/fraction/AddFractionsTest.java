package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class AddFractionsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

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
