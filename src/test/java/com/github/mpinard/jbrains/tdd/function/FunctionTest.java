package com.github.mpinard.jbrains.tdd.function;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FunctionTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void When_Main_Then_NoExceptionThrown() {
        Function.main(new String[] {});
    }
    
}
