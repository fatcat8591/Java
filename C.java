package com.company;
import java.util.Scanner;
import java.awt.geom.Point2D;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count= scanner.nextInt();
        for(int i=0;i<count;i++){
            Triangle point=new Triangle();
            double x1= scanner.nextDouble();
            double y1= scanner.nextDouble();
            double x2= scanner.nextDouble();
            double y2= scanner.nextDouble();
            double x3= scanner.nextDouble();
            double y3= scanner.nextDouble();
            Point2D l1=new Point2D.Double(x1,y1); //Point2D的格式 x1，y1存到 l1(由Point2D宣告)
            Point2D l2=new Point2D.Double(x2,y2); //宣告完之後 兩個變數的距離: X1.distance(X2) 而我想要放入下方class去做計算距離
            Point2D l3=new Point2D.Double(x3,y3);
            Double A1=point.A(l1,l2); //傳入下方的CLASS A1所需的值
            Double B1=point.B(l2,l3); //傳入下方的CLASS B1所需的值
            Double C1=point.C(l3,l1); //傳入下方的CLASS C1所需的值    而Line19~23除了要先宣告好 好讓main傳值進去class之外 以後要呼叫就可以直接用所儲存的變數去呼叫
            Double S_all=point.S(A1,B1,C1); //同理
            Double area_all=point.area(A1,B1,C1,S_all); //同理
            if(area_all==0){
                System.out.print("Just Line!");
                System.out.println();
            }
            else {  //做輸出 由小到大輸出
                if(A1<B1 && A1<C1 && B1<C1){
                    System.out.printf("%.3f",A1);
                    System.out.print(" ");
                    System.out.printf("%.3f",B1);
                    System.out.print(" ");
                    System.out.printf("%.3f",C1);
                    System.out.print(" ");
                    System.out.printf("%.3f",area_all);
                    System.out.println();
                }
                else if(A1<C1 && A1<B1 && C1<B1){
                    System.out.printf("%.3f",A1);
                    System.out.print(" ");
                    System.out.printf("%.3f",C1);
                    System.out.print(" ");
                    System.out.printf("%.3f",B1);
                    System.out.print(" ");
                    System.out.printf("%.3f",area_all);
                    System.out.println();
                }
                else if(B1<A1 && B1<C1 && A1<C1){
                    System.out.printf("%.3f",B1);
                    System.out.print(" ");
                    System.out.printf("%.3f",A1);
                    System.out.print(" ");
                    System.out.printf("%.3f",C1);
                    System.out.print(" ");
                    System.out.printf("%.3f",area_all);
                    System.out.println();
                }
                else if(B1<A1 && B1<C1 && C1<A1){
                    System.out.printf("%.3f",B1);
                    System.out.print(" ");
                    System.out.printf("%.3f",C1);
                    System.out.print(" ");
                    System.out.printf("%.3f",A1);
                    System.out.print(" ");
                    System.out.printf("%.3f",area_all);
                    System.out.println();
                }
                else if(C1<A1 && C1<B1 && A1<B1){
                    System.out.printf("%.3f",C1);
                    System.out.print(" ");
                    System.out.printf("%.3f",A1);
                    System.out.print(" ");
                    System.out.printf("%.3f",B1);
                    System.out.print(" ");
                    System.out.printf("%.3f",area_all);
                    System.out.println();
                }
                else if(C1<B1 && C1<A1 && B1<A1){
                    System.out.printf("%.3f",C1);
                    System.out.print(" ");
                    System.out.printf("%.3f",B1);
                    System.out.print(" ");
                    System.out.printf("%.3f",A1);
                    System.out.print(" ");
                    System.out.printf("%.3f",area_all);
                    System.out.println();
                }
            }
        }
    }
}
class Triangle{
    public Double A(Point2D l1,Point2D l2){ //我是由main去輸入x y 然後帶入Triangle去做 而我的X跟Y是存在l1 但是在做的時候是不一樣的東西 還是要在宣告一次Point2D
        Double A1=l1.distance(l2); //api: l1到l2的距離
        return A1;                 //不是用void的時候要寫一個return做回傳值
    }
    public Double B(Point2D l2,Point2D l3){ //同理 如果今天L2是用double 或int之類的宣告 下方的class還是要再宣告一次
        Double B1=l2.distance(l3);
        return B1;
    }
    public Double C(Point2D l3,Point2D l1){
        Double C1=l3.distance(l1);
        return C1;
    }
    public Double S(Double A1,Double B1,Double C1){
        Double S_all=(A1+B1+C1)/2;
        return S_all;
    }
    public Double area(Double A1,Double B1,Double C1,Double S_all){
        Double area_all=Math.sqrt(S_all*(S_all-A1)*(S_all-B1)*(S_all-C1));
        return area_all;
    }
}
