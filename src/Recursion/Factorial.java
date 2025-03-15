package Recursion;

import java.util.ArrayList;

public class Factorial {
    public static void main(String[] args) {
        // code here
        long n = 6;
        long fact = 1;
        ArrayList<Long> recursion = new ArrayList<>();
        ArrayList<Long> loop = new ArrayList<>();
        getFactorialNumbersUsingRecursion(1, 1, n, recursion);
        System.out.println("Recursion:" + recursion);
        getFactorialNumbersUsingForloop(1, n, loop);
        System.out.println("Loop:" + loop);
    }

    private static void getFactorialNumbersUsingRecursion(long fact, long i, long n, ArrayList<Long> ans) {
        if (fact > n) return;
        ans.add(fact);
        getFactorialNumbersUsingRecursion(fact * (i + 1), i + 1, n, ans);
    }

    private static void getFactorialNumbersUsingForloop(long fact, long n, ArrayList<Long> ans) {
        for (int i = 1; i <= n; i++) {
            fact *= i;
            if (fact > n) {
                break;
            }
            ans.add(fact);
        }
    }
}
