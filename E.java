package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count=scanner.nextInt();
        for(int i=0;i<count;i++){
            int colA,rowA,rowB,colB;
            int rowAsize=scanner.nextInt();
            int colAsize=scanner.nextInt();
            int [][]A=new int[rowAsize][colAsize];
            for(rowA=0;rowA<rowAsize;rowA++){
                for(colA=0;colA<colAsize;colA++){
                    A[rowA][colA]=scanner.nextInt();
                }
            }
            int rowBsize=scanner.nextInt();
            int colBsize=scanner.nextInt();
            int [][]B=new int[rowBsize][colBsize];
            for(rowB=0;rowB<rowBsize;rowB++){
                for(colB=0;colB<colBsize;colB++){
                    B[rowB][colB]=scanner.nextInt();
                }
            }
            int [][]AB=new int[rowAsize][colBsize];
            for(int a=0;a<rowAsize;a++){
                for(int b=0;b<colBsize;b++){
                    for(int c=0;c<rowBsize;c++){
                        AB[a][b]=AB[a][b]+A[a][c]*B[c][b];
                    }
                }
            }
            for(int a=0;a<rowAsize;a++){
                for(int b=0;b<colBsize;b++){
                    if(b==colBsize-1){
                        System.out.print(AB[a][b]);
                    }
                    else{
                        System.out.print(AB[a][b]+" ");
                    }
                }
                System.out.println();
            }
            if(i!=count-1){
                System.out.println();
            }
        }
    }
}
/*測資:
4
2 3
1 2 3
-1 0 4
3 4
1 2 3 -3
0 -1 4 0
-1 0 -2 1
2 2
0 1
1 2
2 2
1 1
1 1
*/