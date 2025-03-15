package Recursion;

public class SumOfSeries {
    public static void main(String[] args) {
        int sum = 0;
        int n = 5;
        System.out.println("ParameterizedWay: " + sumOfSeriesParameterizedWay(sum, n));
        System.out.println("FunctionalWay: " + sumOfSeriesFunctionalWay(n));
    }

    private static int sumOfSeriesParameterizedWay(int sum, int n) {
        if (n == 0) {
            return sum;
        }
        sum += n * n * n;
        return sumOfSeriesParameterizedWay(sum, --n);
    }

    private static int sumOfSeriesFunctionalWay(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
         sum += n * n * n;
        return sum + sumOfSeriesFunctionalWay(--n);
    }
}
