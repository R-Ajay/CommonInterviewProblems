package Searching;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
//        int[] piles = {3, 6, 7, 11}; int hour = 8;
        int[] piles = {30, 11, 23, 4, 20}; int hour = 6;
        System.out.println("Optimal: " + findMinBannanaKokkoCanToFinishPileOptimal(piles, hour));
    }

    private static int findMinBannanaKokkoCanToFinishPileOptimal(int[] piles, int hour) {
        int ans = -1;
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int requireTime = calculateMinBannana(piles, mid);
            if (requireTime <= hour) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int calculateMinBannana(int[] piles, int eat) {
        int requireBannanaPerHour = 0;
        for (int i = 0; i < piles.length; i++) {
            requireBannanaPerHour += Math.ceil( (double) piles[i] / (double) eat);
        }

        return requireBannanaPerHour;
    }
}
