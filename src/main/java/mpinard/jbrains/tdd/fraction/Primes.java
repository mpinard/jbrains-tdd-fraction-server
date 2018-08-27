package mpinard.jbrains.tdd.fraction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

final class Primes implements Iterable<Integer> {
    
    private final List<Integer> primes;

    public static Primes create() {
        return new Primes(Arrays.asList(2, 3, 5, 7));
    }
    
    private Primes(final List<Integer> primes) {
       this.primes = primes;
    }
    
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
    
    public Stream<Integer> stream() {
        return primes.stream();    
    }
    
    public Primes expandTo(final int target) {
        return this;
    }
    
}
