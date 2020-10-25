package tutorials.tutorial_4;

import java.util.Iterator;
import java.util.LinkedList;

public class PrimeList {

    private LinkedList<Integer> primes;

    public PrimeList(LinkedList<Integer> primes) {
        this.primes = primes;
    }

    public int size() {
        return primes.size();
    }

    public int lastPrime() {
        return primes.getLast();
    }

    @Override
    public String toString() {
        return "PrimeList{"
                + "primes=" + primes
                + '}';
    }

    public LinkedList<Integer> getPrimeList() {
        return (LinkedList<Integer>) primes.clone();
    }

    private boolean isPrime(int posInt) {
        if (primes.contains(posInt)) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(posInt); i++) {
            if (posInt % i == 0) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Integer> iterator() {
        return new PrimeListGen<Integer>(size(), lastPrime());
    }

    class PrimeListGen<Integer> implements Iterator<java.lang.Integer> {

        private int index;
        private int primeNumber;

        public PrimeListGen(int index, int primeNumber) {
            this.index = index;
            this.primeNumber = primeNumber;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public java.lang.Integer next() {
            int nextPrimeNumber = primeNumber + 1;
            while (!isPrime(nextPrimeNumber)) {
                nextPrimeNumber++;
            }
            index++;
            primes.add(nextPrimeNumber);
            return nextPrimeNumber;
        }
    }

}
