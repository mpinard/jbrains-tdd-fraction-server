package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests multiplying two {@link Fraction} objects.
 */
public class MulitiplyFractionsTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void Given_ZeroAndZero_When_FractionTimes_Expect_Zero() {
        assertThat(Fraction.of(0).times(Fraction.of(0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0).times(Fraction.of(-0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(-0).times(Fraction.of(-0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0).times(Fraction.of(0, 5))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0, 7).times(Fraction.of(0))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0, 5).times(Fraction.of(0, 23))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(0, 9).times(Fraction.of(-0, 11))).isEqualTo(Fraction.of(0));
        assertThat(Fraction.of(-0, 14).times(Fraction.of(-0, 12))).isEqualTo(Fraction.of(0));
    }

    @Test
    public void Given_OneAndK_When_FractionTimes_Expect_K() {
        assertThat(Fraction.of(1).times(Fraction.of(1))).isEqualTo(Fraction.of(1));
        assertThat(Fraction.of(1).times(Fraction.of(5))).isEqualTo(Fraction.of(5));
        assertThat(Fraction.of(7).times(Fraction.of(1))).isEqualTo(Fraction.of(7));
        assertThat(Fraction.of(-9).times(Fraction.of(1))).isEqualTo(Fraction.of(-9));
        assertThat(Fraction.of(1).times(Fraction.of(-2))).isEqualTo(Fraction.of(-2));
    }
    
    @Test
    public void Given_TwoWholeNumbers_When_FractionTimes_Expect_CorrectResult() {
        assertThat(Fraction.of(3).times(Fraction.of(5))).isEqualTo(Fraction.of(15));
        assertThat(Fraction.of(5).times(Fraction.of(3))).isEqualTo(Fraction.of(15));
    }
    
    @Test
    public void Given_AtLeastOneNegativeNumber_When_FractionTimes_Expect_CorrectResult() {
        assertThat(Fraction.of(4).times(Fraction.of(-3))).isEqualTo(Fraction.of(-12));
        assertThat(Fraction.of(-7).times(Fraction.of(3))).isEqualTo(Fraction.of(-21));
        assertThat(Fraction.of(-6).times(Fraction.of(-4))).isEqualTo(Fraction.of(24));
    }

    @Test
    public void Given_TwoNonWholeFractions_When_Times_Expect_CorrectResult() {
        assertThat(Fraction.of(1, 3).times(Fraction.of(1, 3))).isEqualTo(Fraction.of(1, 9));
        assertThat(Fraction.of(1, 2).times(Fraction.of(1, 2))).isEqualTo(Fraction.of(1, 4));
        assertThat(Fraction.of(1, 3).times(Fraction.of(1, 2))).isEqualTo(Fraction.of(1, 6));
        assertThat(Fraction.of(3, 2).times(Fraction.of(1, 4))).isEqualTo(Fraction.of(3, 8));
        assertThat(Fraction.of(3, 5).times(Fraction.of(4, 3))).isEqualTo(Fraction.of(12, 15));
    }

    @Test
    public void Given_AtLeastOneNegativeFraction_When_FractionTimes_Expect_CorrectResult() {
        assertThat(Fraction.of(-1, 4).times(Fraction.of(1, 4))).isEqualTo(Fraction.of(-1, 16));
        assertThat(Fraction.of(3, 2).times(Fraction.of(-2, 5))).isEqualTo(Fraction.of(-6, 10));
        assertThat(Fraction.of(-5, 9).times(Fraction.of(-3, 5))).isEqualTo(Fraction.of(1, 3));
    }
}
