package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcdefg";
        findLongestSubstringWithoutRepeatingCharacter(str);
    }
    private static void findLongestSubstringWithoutRepeatingCharacter(String str) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < str.length()){
            if(map.containsKey(str.charAt(right)) && map.get(str.charAt(right)) >= left){
                left = map.get(str.charAt(right)) + 1;
            }
            map.put(str.charAt(right), right);
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
        System.out.println("Longest Substring + length: " + str.substring(left, right)+ " "+ maxLength);
    }

}
