package code.problem.easy;

/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    public static int countPrimes(int n) {
        n = n - 1;
        if (n <= 1)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int count = 2;
        for (int i = 4; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;

    }

    public int countPrimesUsingSieveOfEratosthenes(int n) {
        if (n <= 2)
            return 0;

        // init an array to track prime numbers
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++)
            primes[i] = true;

        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            // or for (int i = 2; i <= n-1; i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i)
                    primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }

        return count;
    }


    private static boolean isPrime(int num) {
        int sqrt = Double.valueOf(Math.sqrt(num)).intValue();
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(countPrimes(10));
    }
}
