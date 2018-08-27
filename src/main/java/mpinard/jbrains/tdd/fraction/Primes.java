package mpinard.jbrains.tdd.fraction;

import java.util.*;
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
        final int maxExistingPrime = primes.get(primes.size() - 1);
        
        if (maxExistingPrime >= target) {
            return this;
        }
        
        final List<Integer> newPrimes = new ArrayList<>(primes);
        
        for (int i = maxExistingPrime + 1; i <= target; i++) {
            if (isPrime(newPrimes, i)) {
               newPrimes.add(i);
            }
        }
        
        return new Primes(Collections.unmodifiableList(newPrimes));
    }
    
    private boolean isPrime(final List<Integer> existingPrimes, final int candidate) {
        final int maxDivisor = candidate / 2;
        
        for (final int prime : existingPrimes) {
            if (prime > maxDivisor) {
                return true;
            } 
            
            if (candidate % prime == 0) {
                return false;
            }
        }
        
        return true;
    }
}
