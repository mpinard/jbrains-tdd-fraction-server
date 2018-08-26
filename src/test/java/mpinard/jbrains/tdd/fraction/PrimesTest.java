package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimesTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void Given_InitialPrimes_When_Iterate_ValuesAsExpected() {
        final StringBuilder sb = new StringBuilder();
        
        for (Integer prime : new Primes()) {
            sb.append(prime).append(" ");
        }
        
        assertThat(sb.toString()).isEqualTo("2 3 5 7 ");
    }
}
