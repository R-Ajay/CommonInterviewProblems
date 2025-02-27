package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MinmumSubStringContainingAllThreeCharacter {
    public static void main(String[] args) {
        String str = "ddaaabbca";
        findMinmumSubStringContainingAllThreeCharacterBrute(str);
    }

    /**
     * Time Complexity O(n * n)
     * Space Complexity O(1)
     *
     * @param str
     */
    private static void findMinmumSubStringContainingAllThreeCharacterBrute(String str) {
        int min = Integer.MAX_VALUE;
        String result = "";
        //       Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            int[] arr = new int[3];
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == 'a' || ch == 'b' || ch == 'c') {
//                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                    arr[ch - 'a'] = 1;
                }
//                if (map.getOrDefault('a', 0) >= 1
//                        && map.getOrDefault('b', 0) >= 1
//                        && map.getOrDefault('c', 0) >= 1
//                        && min > j - i + 1) {
                if (arr[0] == 1 && arr[1] == 1 && arr[2] == 1 && (min > j - i + 1)) {
                    min = j - i + 1;
                    result = str.substring(i, j + 1);
                }

            }
        }
        System.out.println(result);
    }
}
