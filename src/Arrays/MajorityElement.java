package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2}; //Output: 2
//        int[] nums = {3,2,3}; //Output: 3
        System.out.println(brute(nums)); //Time: O(N) and Space O(N)
        System.out.println(optimal(nums)); // Time: O(N) and Space O(1)
    }

    /**
     * Applying Moore Voting algorithm
     * @param nums
     * @return
     */
    private static int optimal(int[] nums) {
        int element = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (element == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0)
                    element = nums[i + 1];
            }
        }
        return element;
    }

    private static int brute(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int size = nums.length / 2;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > size)
                return entry.getKey();
        }
        return -1;
    }
}
