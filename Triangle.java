package com.company;
import java.util.Scanner;
public class Main {                 //跟Another method 那個檔案差別在 override可以直接覆蓋掉參數，而不用override的話直接用this.或是直接新一個參數把他覆蓋掉
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double X= scanner.nextDouble();
        double Y= scanner.nextDouble();
        double Z= scanner.nextDouble();
        String color=scanner.next();
        boolean filled=scanner.nextBoolean();
        GeometricObject GGeometricObject = new Triangle(X, Y, Z, color, filled);
        System.out.println("Triangle: side1 = "+X+" side2 = "+Y+" side3 = "+Z);
        System.out.println("The area is "+GGeometricObject.area(X,Y,Z));
        System.out.println("The perimeter is "+GGeometricObject.perimeter(X,Y,Z));
        System.out.println(GGeometricObject.getColor());
        System.out.println(GGeometricObject.isFilled());
    }
}
abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    protected GeometricObject() {                              //Construct a default geometric object
        dateCreated = new java.util.Date();
    }
    protected GeometricObject(String color, boolean filled) {  //Construct a geometric object with color and filled value
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {                                 //Return color
        return color;
    }
    public void setColor(String color) {                       // Set a new color
        this.color = color;
    }
    public boolean isFilled() {                                //Return filled. Since filled is boolean,the get method is named isFilled
        return filled;
    }
    public void setFilled(boolean filled) {                    // Set a new filled
        this.filled = filled;
    }
    public java.util.Date getDateCreated() {                   // Get dateCreated
        return dateCreated;
    }
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }                                                           //call toString的時候會override 但是這題沒有用到
    public abstract double area(double X,double Y,double Z);                             // Abstract method getArea
    public abstract double perimeter(double X,double Y,double Z);                        //Abstract method getPerimeter
}
class Triangle extends GeometricObject {
    public Triangle(double X,double Y,double Z,String color,boolean filled){
        setColor(color);
        setFilled(filled);
    }
    @Override
    public double area(double X,double Y,double Z){
        double S=(X+Y+Z)/2;
        double area_all=Math.sqrt(S*(S-X)*(S-Y)*(S-Z));
        return area_all;
    }
    @Override
    public double perimeter(double X,double Y,double Z){
        double preimeter_all=X+Y+Z;
        return preimeter_all;
    }
}