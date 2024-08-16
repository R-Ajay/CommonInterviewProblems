package Arrays;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 5, 12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void moveZeros(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }

    }

}
