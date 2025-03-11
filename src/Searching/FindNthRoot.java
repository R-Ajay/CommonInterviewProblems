package Searching;

public class FindNthRoot {
    public static void main(String[] args) {
        int n = 2;
        int m = 9;
//        int n = 3; int m = 121;

        System.out.println("Brute: " + bruteForce(n, m));
        System.out.println("Optimal: " + optimal(n, m));
    }

    private static int optimal(int n, int m) {
        if (n == 0) return 1;
        if (n == 1) return m;
        int low = 1;
        int high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midN = getNumberUsingExponential(mid, n, m);
            if (midN == m) {
                return mid;
            } else if (midN < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int bruteForce(int n, int m) {
        if (n == 0) return 1;
        if (n == 1) return m;

        for (int i = 2; i <= m; i++) {
            int multiply = getNumber(i, n, m);
            if (multiply == m) return i;
            else if (multiply > m) break;
        }
        return -1;
    }

    /**
     * Time Complexity O(Log N)
     * Exponential Way
     *
     * @param i
     * @param n
     * @param m
     * @return
     */
    private static int getNumberUsingExponential(int i, int n, int m) {
        int multiply = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                multiply = multiply * i;
                n = n - 1;
            } else {
                i = i * i;
                n = n / 2;
            }
        }
        return multiply;
    }

    /**
     * Time Complexity O(N)
     *
     * @param i
     * @param n
     * @param m
     * @return
     */
    private static int getNumber(int i, int n, int m) {
        int multiply = i;
        for (int j = 1; j <= n - 1; j++) {
            multiply *= i;
            if (multiply > m) break;
        }
        return multiply;
    }
}
