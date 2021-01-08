package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num=scanner.nextInt();
            int numbox=0;
            numbox=num;
            int prime=2,count=0;
            int primeodd=1;
            while(num>1){
                while(num%prime==0){
                    num/=prime;
                    count++;
                }
                if(count%2!=0){
                    primeodd*=prime;
                }
                prime++;
                count=0;
            }
            int total=primeodd*numbox;
            System.out.println(primeodd+" "+total);
        }
    }
}
