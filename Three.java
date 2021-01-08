package com.company;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int count1=0;
        double sum=0;
        String[] array = new String[10000];
        String first = scanner.next();
        StringTokenizer st = new StringTokenizer(first, "+*-/%()");
        while (st.hasMoreTokens()) {
            if(count!=0){
                System.out.print(" ");
            }
            count++;
            array[count]=st.nextToken();
            System.out.print(array[count]);
            sum+=Double.parseDouble(array[count]); //將array[count]轉換為浮點數， sum+= ，存入sum
        }
        System.out.println();
        for(int i=0;i<first.length();i++) {
            if (first.charAt(i) >= 37 && first.charAt(i) <= 45 || first.charAt(i) == 47) {
                if(count1!=0){
                    System.out.print(" ");
                    count1++;
                }
                count1++;
                System.out.print(first.charAt(i));
            }
        }
        System.out.println();
        System.out.printf("%.3f\n",sum); //%.3f取小數點後三位
    }
}
