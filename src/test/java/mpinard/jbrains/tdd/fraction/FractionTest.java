package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void When_ZeroPlusZero_Then_ExpectZero() {
        assertThat(Fraction.of(0).plus(Fraction.of(0))).isEqualTo(Fraction.of(0));
    }
    
    @Test
    public void Given_Fraction_When_ToString_Then_FormatIsAsExpected() {
        assertThat(Fraction.of(1, 2).toString()).isEqualTo("1/2");
        assertThat(Fraction.of(3, 4).toString()).isEqualTo("3/4");
        assertThat(Fraction.of(7, 8).toString()).isEqualTo("7/8");
    }
    
}
