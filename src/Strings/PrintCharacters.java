package Strings;

public class PrintCharacters {

    public static void main(String[] args) {
        String str = "b3c6d15";
        printCharacter(str);
    }

    private static void printCharacter(String str) {

        int i = 0;
        while(i < str.length()){
            char ch = str.charAt(i);
            if(i+1 != str.length() && Character.isDigit(str.charAt(i+1))){
                if(i+2!= str.length() && Character.isDigit(str.charAt(i+2))){
                    print( ch, Integer.parseInt( String.valueOf(str.charAt(i+1)) + String.valueOf(str.charAt(i+2))  ));
                    i=i+3;
                }else{
                   print( ch, Integer.parseInt( String.valueOf(str.charAt(i+1))));
                   i = i+2;
                }
            }

        }

    }

    private static void print(char ch, int parseInt) {
        for (int i = 0; i < parseInt; i++) {
            System.out.print(ch);
        }
    }
}
