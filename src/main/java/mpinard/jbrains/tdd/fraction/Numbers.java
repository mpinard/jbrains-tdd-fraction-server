package mpinard.jbrains.tdd.fraction;

class Numbers {
    /**
     * Returns the Greatest Common Divisor of two numbers.
     * 
     * @param n the first number
     * @param k the second number
     * @return the greatest common divisor of <code>n</code> and <code>k</code>
     */
    static int gcd(final int n, final int k) {
        if (Math.abs(n) == 0 && Math.abs(k) == 0) {
            return 1;
        }
        
        int a = n;
        int b = k;
        
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        
        return Math.abs(a);
    }
}
