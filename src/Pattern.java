
/*
Check this link for patter
https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/assignments/09-patterns.md
*/

public class Pattern {
    public static void main(String[] args) {

         int n = 5;
        //printPattern2(n);
        //printPattern5(n);
        //printPattern6(n);
        //printPattern12(n);
        //printUpDownRightPyramid(n);
        //printPattern19(n);
        //printPattern20(n);
        //printPattern22(n);
        //printPattern28(n);
        //printPattern30(n);
        //printPattern31(n);
        //printPattern32(n);
        //printPattern33(n);
        //printPattern35(n);

        String name1 = "GEEKSFORGEEKS";
        String name2 = "PROGRAM";
       //printPatternX(name1);
        //printRight(name2);

    }

    private static void printRight(String name) {

        int middle = name.length() / 2;
        for (int row = 1; row <= name.length() ; row++) {
            int k = middle;
            for (int space = 1; space <= name.length() - row ; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                k = (k == name.length()) ? 0 : k;
                System.out.print(name.charAt(k++));

            }
            System.out.println();
        }
    }

    private static void printPattern20(int n) {
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= n-1; col++) {
                if (row == 1 || row == n || col == 1 || col == n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    private static void printPattern22(int n) {

        int k = 1;
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(k + " ");
                k = (k == 1 ? --k : ++k);
            }
            System.out.println();
        }
    }

    private static void printPattern35(int n) {
        for (int row = 1; row <= n ; row++) {

            for (int col = 1; col <= row ; col++) {
                System.out.print(col);
            }
            for (int space = 1; space <= n - row ; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >= 1 ; col--) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    private static void printPattern33(int n) {

        for (int row = 1; row <= n ; row++) {
            int k =0;
            for (int col = 1; col <= row ; col++) {
                char ch = (char)('a' + k);
                System.out.print(ch + " ");
                k++;

            }
            System.out.println();
        }

    }

    private static void printPattern32(int n) {

        for (int row = 1; row <= n ; row++) {
            int k =0;
            for (int col = 1; col <= row ; col++) {
                char ch = (char)( 'A'+ (n - row + k));
                System.out.print( ch + " " );
                k++;
            }
            System.out.println();
        }
    }

    private static void printPattern31(int n) {

        int originalN = n;
        for (int row = 1; row < 2 * n ; row++) {
            for (int col = 1; col < 2 * n ; col++) {
                int atEvertIndex = 1 + originalN - Math.min(Math.min(row, col), Math.min((2*n)-row, (2*n)-col));
                System.out.print(atEvertIndex + " ");
            }
            System.out.println();

        }
    }

    private static void printPattern30(int n) {

        for (int row = 1; row <= n; row++) {

            for (int space = 1; space <= n-row ; space++) {
                System.out.print(" ");
            }
            for (int col = row; col > 0 ; col--) {
                System.out.print(col);
            }
            for (int col = 2 ; col <= row; col++) {
                System.out.print( col);
            }
        System.out.println();
        }
    }


    private static void printPattern12(int n) {

        for (int row = 1; row <= 2 * n ; row++) {
            int noOfColsToBePrinted = n >= row ? n - row + 1 : row - n;
            int spaceToBePrinted = n - noOfColsToBePrinted;
            for (int space = 1; space <= spaceToBePrinted ; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= noOfColsToBePrinted ; col++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }

    private static void printPattern19(int n) {

        for (int row = 1; row < 2 * n; row++) {

            int noOfColsToBePrinted = row > n ? 2 * n - row : row;

            for (int col = 1; col <= noOfColsToBePrinted ; col++) {
                System.out.print("* ");
            }

            for (int space = 1; space <= n - noOfColsToBePrinted ; space++) {
                System.out.print("    ");
            }

            for (int col = 1; col <= noOfColsToBePrinted ; col++) {
                System.out.print(" *");
            }

            System.out.println();
        }
    }

    private static void printPattern2(int n) {

        for (int row = 1; row<=n; row++){
            for (int col = 1; col<=row; col++ ){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printPattern6(int n) {
        for (int row = 1; row<=n; row++){
            for(int space = n-row; space>=1; space--){
                System.out.print(" ");
            }
            for (int col = 1; col<=row; col++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void printPattern5(int n) {

        for (int row = 1; row < 2 * n ; row++) {

            int noOfColsToBePrint = row > n ? 2 * n - row : row;

            for (int col = 1; col <= noOfColsToBePrint ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    private static void printUpDownRightPyramid(int n) {

        for (int row = 1; row < 2 * n ; row++) {

            int noOfColsToBePrint = row > n ? 2 * n - row : row;

            for (int space = 1; space <= n - noOfColsToBePrint; space++) {
                System.out.print("  ");
            }
            for (int col = 1; col <= noOfColsToBePrint ; col++) {
                System.out.print(" *");
            }
            System.out.println();
        }

    }

    private static void printPattern28(int n) {

        for (int row = 1; row <= 2 * n - 1 ; row++) {
           int noOfColsToBePrinted = row > n ? 2 * n - row : row;
            for (int space = 1; space <= n - noOfColsToBePrinted; space++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= noOfColsToBePrinted; col++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }


    private static void printPatternX(String name) {

        for (int row = 0; row < name.length() ; row++) {
            for (int col = 0; col <= name.length(); col++) {
                if(row == col || (row + col + 1== name.length()))
                    System.out.print(name.charAt(row));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
