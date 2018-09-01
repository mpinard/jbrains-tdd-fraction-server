package mpinard.jbrains.tdd.fraction;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for Greatest Common Denominator.
 */
public class GcdTest {

    @Test
    public void Given_OneAndAnyNumber_Then_GcdIsOne() {
        assertThat(gcd(1, 1)).isEqualTo(1);
        assertThat(gcd(1, 3)).isEqualTo(1);
        assertThat(gcd(3, 1)).isEqualTo(1);
        assertThat(gcd(12, 1)).isEqualTo(1);
        assertThat(gcd(1, 12)).isEqualTo(1);
    }
    
    private static int gcd(final int value1, final int value2) {
        return 1;
    }
}
