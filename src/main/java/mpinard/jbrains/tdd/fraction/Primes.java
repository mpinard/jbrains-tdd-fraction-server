package mpinard.jbrains.tdd.fraction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

class Primes implements Iterable<Integer> {
    
    private List<Integer> primes = Arrays.asList(2, 3, 5, 7);

    @Override
    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        primes.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return primes.spliterator();
    }
    
    public Primes expandTo(final int target) {
        return this;
    }
}
