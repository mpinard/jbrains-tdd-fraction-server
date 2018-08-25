package mpinard.jbrains.tdd.fraction;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FractionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void When_Main_Then_NoExceptionThrown() {
        Fraction.main(new String[] {});
    }
    
}
