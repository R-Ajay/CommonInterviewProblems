package Searching;

public class FloorSqrt {
    public static void main(String[] args) {
        int n = 130; // Output : 2
        System.out.println("Brute: " + bruteForce(n));
        System.out.println("Optimal: " + optimal(n));
    }
    /**
     * Time Complexity O(Log N)
     *
     * @param n
     * @return
     */
    private static int optimal(int n) {
        if (n == 0 || n == 1) return n;
        int low = 1;
        int high = n;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid == n) {
                return mid;
            } else if ((mid * mid) < n) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     * Time Complexity O(sqrt{n})
     *
     * @param n
     * @return
     */
    public static int bruteForce(int n) {
        // Your code here
        int i = 1;
        for (; i * i <= n; i++) {
            if (n == (i * i)) {
                return i;
            }
        }
        return i - 1;
    }
}
