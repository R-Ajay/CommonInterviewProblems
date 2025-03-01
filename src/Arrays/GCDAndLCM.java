package Arrays;


public class GCDAndLCM {
    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        System.out.println("GCD is " + findGcd(a, b));
        System.out.println("LCM is " + findLcm(a, b));
    }

    /**
     * Applying to Euclidean algo to get the complexity of O(Log min(a, b))
     *
     * @param a
     * @param b
     * @return
     */
    private static int findGcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a == 0 ? b : a;
    }

    private static int findLcm(int a, int b) {
        return (a * b) / findGcd(a,b);
    }
}
