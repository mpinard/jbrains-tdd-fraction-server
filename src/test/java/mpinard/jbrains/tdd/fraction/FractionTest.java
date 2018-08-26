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
    
}
