package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MinmumSubStringContainingAllThreeCharacter {
    public static void main(String[] args) {
//        String str = "ddaaabbca";
//        String str = "abacbc";
//        String str = "cbabcacab";
        String str = "timetopractice";
        String find = "toc";
        findMinmumSubStringContainingAllThreeCharacterBetter(str, find);
//        findMinmumSubStringContainingAllThreeCharacterBrute(str);
    }

    /**
     * Time Complexity O(n * n)
     * Space Complexity O(1)
     *
     * @param str
     */
    private static void findMinmumSubStringContainingAllThreeCharacterBetter(String str, String find) {
        int left =0;
        int right = 0;
        int min = Integer.MAX_VALUE;
//        int[] arr = new int[3];
        Map<Character, Integer> map = new HashMap<>();
        String result = "";
        while (right < str.length()){
            char ch = str.charAt(right);
            if (ch == find.charAt(0) || ch == find.charAt(1) || ch == find.charAt(2)) {
//                arr[ch - 'a']++;
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            while(left < right
                    && map.getOrDefault(find.charAt(0), 0) > 0
                    && map.getOrDefault(find.charAt(1), 0) > 0
                    && map.getOrDefault(find.charAt(2), 0) > 0){
                if(right - left + 1 < min){
                    min = right - left + 1;
                    result = str.substring(left, right + 1);
                }
                ch = str.charAt(left);
                if (ch == find.charAt(0) || ch == find.charAt(1) || ch == find.charAt(2)) {
//                    arr[ch - 'a']--;
                    map.put(ch, map.get(ch) - 1);
                    if(map.get(ch) <= 0) map.remove(ch);
                }
                left++;
            }
            right++;
        }
        System.out.println(result);
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
                    arr[ch - 'a']++;
                }
//                if (map.getOrDefault('a', 0) >= 1
//                        && map.getOrDefault('b', 0) >= 1
//                        && map.getOrDefault('c', 0) >= 1
//                        && min > j - i + 1) {
                if (arr[0] >0 && arr[1] >0 && arr[2] >0 && (min > j - i + 1)) {
                    min = j - i + 1;
                    result = str.substring(i, j + 1);
                }

            }
        }
        System.out.println(result);
    }
}
