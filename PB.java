package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str11=scanner.next();
            if(str11.equals("0")){
                break;
            }
            int even = 0,odd=0;
            for (int i = 0; i < str11.length(); i++) {
                if(str11.length()%2==0){
                    if(i%2==0){
                        even=even+str11.charAt(i)-48; //sting's calculate will use ASCII,so need to reduce the 0's ASCII is=48
                    }
                    else{
                        odd=odd+str11.charAt(i)-48;//use -48 and -'0' is the same  '0' ASCII is 48
                    }
                }
                if(str11.length()%2!=0){
                    if(i%2==0){
                        odd=odd+str11.charAt(i)-48; //sting's calculate will use ASCII,so need to reduce the 0's ASCII is=48
                    }
                    else{
                        even=even+str11.charAt(i)-48;//use -48 and -'0' is the same  '0' ASCII is 48
                    }
                }
            }
            int sum=odd-even;
            if(sum%11==0){
                System.out.println(odd+" "+even);
                System.out.println(str11+" is a multiple of 11.");
            }
            else{
                System.out.println(odd+" "+even);
                System.out.println(str11+" is not a multiple of 11.");
            }
        }
    }
}