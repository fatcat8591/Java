package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count= scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<count;i++){
            String str =scanner.nextLine();
            String strbereplaced =scanner.nextLine();
            String strreplaceto =scanner.nextLine();
            String A=str.replace(strbereplaced,strreplaceto);
            StringBuffer buffer = new StringBuffer(A);
            buffer.reverse();
            System.out.print(buffer);
            System.out.println();
        }
    }
}

/*
4
?era uoy ohW
era uoy
uoy era
 */
