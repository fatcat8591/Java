package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            int size=100,row,col;
            size=scanner.nextInt();
            if(size%2==0)
            {
                System.out.println("It is not an odd number.");
                if(scanner.hasNextInt()){
                    System.out.println();
                }
                continue;
            }
            int [][]square=new int [size][size];
            for(row=0;row<size;row++)
            {
                for(col=0;col<size;col++)
                {
                    square[row][col]=0;
                }
            }
            row=(size-1);
            col=(size-1)/2;
            square[row][col]=1;
            for(int i=2;i<=size*size;i++)
            {
                if(square[(row+1)%size][(col+1)%size]==0){
                    row=(row+1)%size;
                    col=(col+1)%size;
                }
                else{
                    row=(row-1+size)%size;
                }
                square[row][col]=i;
            }
            int a=size;
            a=(a*(a*a+1))/2;
            System.out.println(a);
            for(int[] i:square) {
                for(int j:i) {
                    System.out.printf("%5d", j);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}