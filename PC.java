package com.company;
import java.lang.String;
import java.util.Scanner;
import java.math.BigInteger;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextBigInteger()) {
            String num1,num2; //BigInteger only could just use string to store ,can't use int
            num1= scanner.next();
            num2= scanner.next();
            BigInteger B = new BigInteger(num1);
            BigInteger B1 = new BigInteger(num2);
            System.out.print(B.gcd(B1) + " ");
            BigInteger product = B.multiply(B1);
            BigInteger gcd = B.gcd(B1);
            BigInteger lcm = product.divide(gcd); //xy/gcd=lcm
            System.out.println(lcm);
            for(int i=0;i<=4;i++){
                lcm = lcm.nextProbablePrime();
                if(i<=3){
                    System.out.print(lcm+ " ");
                }
                if(i==4){
                    System.out.print(lcm);
                }
            }
            System.out.println();
        }
    }
}