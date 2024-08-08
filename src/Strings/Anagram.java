package Strings;

public class Anagram {

    public static void main(String[] args) {
        String str1 = "debit card";
        String str2 = "bad credit";

        System.out.println("The given words are anagram: "
                            + (areAnagram(str1, str2) ? "Yes" : "No"));
    }

    private static boolean areAnagram(String str1, String str2) {

        if(str1.length()!= str2.length())
            return false;

        int count = 0;
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str2.length() ; j++) {
                if(str1.charAt(i) == str2.charAt(j)){
                    count++;
                    str2.replace(str2.charAt(j), '.');
                    break;
                }
            }
        }
        return count == str2.length();
    }
}
