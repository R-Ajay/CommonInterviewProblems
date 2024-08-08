package Strings;

public class StringPalindrome {

    public static void main(String[] args) {
        String str1 = "level";
        System.out.println("The given word is " + (isPalindrome(str1) ? "" : "not a ")+ "palindrome.");
    }

    private static boolean isPalindrome(String str1) {

        int i = 0;
        int j = str1.length() - 1;

        while(i < j){
            if(str1.charAt(i) != str1.charAt(j)) {
                return false;
            }
            i++;
            j--;
            }
        return true;
    }

    }
