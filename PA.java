package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int i, j,num,count=0;
        String PPrime;
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            num = scanner.nextInt();
            if (num == 0) {
                System.out.println();
                continue;
            }
            for (i = 2; i <= 1000000000; i++) {
                for (j = 2; j < i; j++) {
                    if (i % j == 0)
                        break;
                }
                if (j >= i) {
                    if (i <= 11) {
                        System.out.print(i + " ");
                        count++;
                    }
                    if (i > 100 && i < 1000) {
                        PPrime = Integer.toString(i);
                        if (PPrime.charAt(0) == PPrime.charAt(2)) {
                            count++;
                            if(count==num){
                                System.out.println(i);
                            }
                            else{
                                if(count%10!=0){
                                    System.out.print(i+" ");
                                }
                                else{
                                    System.out.println(i);
                                }
                            }
                        }
                    }
                    if (i > 10000 && i < 100000) {
                        PPrime = Integer.toString(i);
                        if (PPrime.charAt(0) == PPrime.charAt(4) && PPrime.charAt(1) == PPrime.charAt(3)) {
                            count++;
                            if(count==num){
                                System.out.println(i);
                            }
                            else{
                                if(count%10!=0){
                                    System.out.print(i+" ");
                                }
                                else{
                                    System.out.println(i);
                                }
                            }
                        }
                    }
                    if (count == num) {
                        break;
                    }
                }
            }
            count=0;
        }
    }
}
