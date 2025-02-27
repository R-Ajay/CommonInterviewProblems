package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBaskert {
    public static void main(String[] args) {
//        int[] fruits = {1, 2, 1, 3, 4};
        int[] fruits = {1, 2, 3, 2, 2};
        //int[] fruits = {1, 2, 1};
        int basket = 2;//No of Basket
        findMaximumFruitsIntoBaskert(fruits, basket);
    }

    private static void findMaximumFruitsIntoBaskert(int[] fruits, int basket) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > basket) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) <= 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        System.out.println("The Maximum fruits into the basket:" + maxLength);
    }


    /**
     * This is one approach but O(n * n)
     */
    private static void findMaximumFruitsIntoBaskert1(int[] fruits, int basket) {
        int maxLength = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fruits.length; i++) {
            for (int j = i; j < fruits.length; j++) {
                set.add(fruits[j]);
                if (set.size() <= basket) {
                    maxLength = Math.max(j - i + 1, maxLength);
                } else {
                    break;
                }
            }
            set.clear();
        }

        System.out.println("The Maximum fruits into the basket:" + maxLength);
    }
}
