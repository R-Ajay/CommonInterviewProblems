package Interfaces;

import java.util.Scanner;

public class C {

    {
        System.out.println("Instance initialization class");
    }

    C(){
        System.out.println("Constructor initialization class");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number:");

        int b = in.nextInt();


        in = new Scanner(System.in);
        System.out.println("Enter the name:");
        String abc = in.nextLine();
        in.close();

    }

}


