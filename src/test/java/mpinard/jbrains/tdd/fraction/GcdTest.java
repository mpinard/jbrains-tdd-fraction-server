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
    }

    @Test
    public void Given_TwoNumbersWithNoCommonDenominator_When_Gcd_Then_ResultIsOne() {
        assertThat(gcd(5, 7)).isEqualTo(1);
        assertThat(gcd(13, 23)).isEqualTo(1);
        assertThat(gcd(36, 19)).isEqualTo(1);
        assertThat(gcd(1279, 1181)).isEqualTo(1); // large primes
    }

    private static int gcd(final int value1, final int value2) {
        int a = value1;
        int b = value2;
        
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        
        return a;
    }
}
