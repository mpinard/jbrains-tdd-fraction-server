package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimesTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void Given_InitialPrimes_When_Iterate_Then_ValuesAsExpected() {
        final StringBuilder sb = new StringBuilder();
        
        for (Integer prime : Primes.create()) {
            sb.append(prime).append(" ");
        }
        
        assertThat(sb.toString()).isEqualTo("2 3 5 7 ");
    }

    @Test
    public void Given_InitialPrimes_When_ForEach_Then_ValuesAsExpected() {
        final StringBuilder sb = new StringBuilder();

        Primes.create().forEach(prime -> sb.append(prime).append(" "));

        assertThat(sb.toString()).isEqualTo("2 3 5 7 ");
    }

    @Test
    public void Given_Primes_When_Stream_Then_StreamOfPrimes() {
        assertThat(Primes.create().stream().collect(Collectors.toList())).isEqualTo(Arrays.asList(2, 3, 5, 7));
    }
    
    public void When_ExpandToHigherValue_Than_PrimesExtendedToThatValue() {
//        final Primes primes = new Primes();
//        final List<Integer> initialPrimes =  primes.stream();
    }
    
}
