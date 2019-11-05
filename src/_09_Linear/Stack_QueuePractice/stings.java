package _09_Linear.Stack_QueuePractice;

import java.util.Scanner;

public class stings {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        String s=cin.nextLine();
        for (int i = s.length()-1; i >=0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
