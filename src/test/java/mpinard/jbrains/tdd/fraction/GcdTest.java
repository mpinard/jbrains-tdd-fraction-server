package mpinard.jbrains.tdd.fraction;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for Greatest Common Divisor.
 */
public class GcdTest {

    @Test
    public void Given_OneAndAnyNumber_When_Gcd_Expect_One() {
        assertThat(gcd(1, 1)).isEqualTo(1);
        assertThat(gcd(1, 3)).isEqualTo(1);
        assertThat(gcd(3, 1)).isEqualTo(1);
        assertThat(gcd(1, 5)).isEqualTo(1);
        assertThat(gcd(12, 1)).isEqualTo(1);
        assertThat(gcd(1, 12)).isEqualTo(1);
    }

    @Test
    public void Given_AnyNumberAndItself_When_Gcd_Expect_TheNumber() {
        assertThat(gcd(1, 1)).isEqualTo(1);
        assertThat(gcd(5, 5)).isEqualTo(5);
        assertThat(gcd(13, 13)).isEqualTo(13);
        assertThat(gcd(128, 128)).isEqualTo(128);
    }
    
    @Test
    public void Given_TwoNumbersWithCommonFactor_When_Gcd_Expect_LargestCommonFactor() {
        assertThat(gcd(12, 18)).isEqualTo(6);
        assertThat(gcd(18, 27)).isEqualTo(9);
        assertThat(gcd(64, 72)).isEqualTo(8);
        
        final int largeNumber = 3 * 5 * 19 * 23 * 23 * 1181;
        assertThat(gcd(largeNumber, largeNumber * 7)).isEqualTo(largeNumber);
    }

    @Test
    public void Given_TwoNumbersWithNoCommonDenominator_When_Gcd_Expect_One() {
        assertThat(gcd(5, 7)).isEqualTo(1);
        assertThat(gcd(13, 23)).isEqualTo(1);
        assertThat(gcd(36, 19)).isEqualTo(1);
        assertThat(gcd(1279, 1181)).isEqualTo(1); // large primes
    }

    @Test
    public void Given_ZeroAndKNotZero_When_Gcd_Expect_K() {
        assertThat(gcd(0, 1)).isEqualTo(1);
        assertThat(gcd(1, 0)).isEqualTo(1);
        assertThat(gcd(23, 0)).isEqualTo(23);
        assertThat(gcd(0, 23)).isEqualTo(23);
    }

    @Test
    public void Given_OneOrMoreNegativeNumbers_When_Gcd_Then_ResultIsPositive() {
        assertThat(gcd(-1, 1)).isEqualTo(1);
        assertThat(gcd(1, -1)).isEqualTo(1);
        assertThat(gcd(-1, 5)).isEqualTo(1);
        assertThat(gcd(1, -5)).isEqualTo(1);
        assertThat(gcd(-5, 5)).isEqualTo(5);
        assertThat(gcd(5, -5)).isEqualTo(5);
        assertThat(gcd(-5, -5)).isEqualTo(5);
        assertThat(gcd(-6, 3)).isEqualTo(3);
        assertThat(gcd(6, -3)).isEqualTo(3);
    }

    @Test
    public void Given_NegativeZeroAndZero_When_Gcd_Expect_One() {
        assertThat(gcd(-0, -0)).isEqualTo(1);
        assertThat(gcd(-0, 0)).isEqualTo(1);
        assertThat(gcd(0, -0)).isEqualTo(1);
    }

    @Test
    public void Given_NegativeZeroAndKNotZero_When_Gcd_Expect_K() {
        assertThat(gcd(-0, 1)).isEqualTo(1);
        assertThat(gcd(1, -0)).isEqualTo(1);
        assertThat(gcd(-0, 23)).isEqualTo(23);
        assertThat(gcd(23, -0)).isEqualTo(23);
    }

    private static int gcd(final int value1, final int value2) {
        if (Math.abs(value1) == 0 && Math.abs(value2) == 0) {
            return 1;
        }
        
        int a = value1;
        int b = value2;
        
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        
        return Math.abs(a);
    }
}
