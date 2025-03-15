package Recursion;

public class StringToInteger {
    public static void main(String[] args) {
//        String s = "-91283472332";
//        String s = "-+12";
        String s = "-0012a42";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        if (s==null || s.trim().length() == 0)
            return 0;
        int sign = 1;
        String str = s.trim();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                // Check for overflow
                int digit = str.charAt(i) - '0';
                if (result > (Integer.MAX_VALUE - digit) / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                result = digit + (result * 10);
            } else {
                if (i==0 &&(str.charAt(0) == '-' || str.charAt(0) == '+')) {
                    sign = str.charAt(0) == '-' ? -1 : 1;
                } else {
                    break;
                }
            }
        }
        return result * sign;
    }
}
