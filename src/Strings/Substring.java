package Strings;

public class Substring {

    public static void main(String[] args) {
        String pattern = "for";
        String word = "forgeeksssfofxxxxgeeks";

        System.out.println(findSubstring(pattern, word));
    }

    private static int findSubstring(String pattern, String word) {
        int k = 0;
        for (int i = 0; i < word.length() ; i++) {
            if(pattern.charAt(k) == word.charAt(i)){
                k++;
                if(k ==pattern.length())
                    return i - k + 2;
            }else{
                k = 0;
            }
        }
        return -1;
    }
}
