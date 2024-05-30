package testing;

import java.util.Scanner;

public class Modulo {
    static Scanner firstNum = new Scanner(System.in);
    static Scanner secondNum = new Scanner(System.in);

    public static void main(String[] args) {

        int one = -1;
        int two = -1;
        while (one != 0 || two != 0) {
            System.out.print("Please enter a number: ");
            one = firstNum.nextInt();
            System.out.println();
            System.out.print("Please enter another number: ");
            two = secondNum.nextInt();
            System.out.println();
            System.out.println(one % two);
        }
    }
}
