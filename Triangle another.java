package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double X= scanner.nextDouble();
        double Y= scanner.nextDouble();
        double Z= scanner.nextDouble();
        String color=scanner.next();
        boolean filled=scanner.nextBoolean();
        GeometricObject GGeometricObject = new Triangle(X, Y, Z, color, filled);
        System.out.println("Triangle: side1 = "+GGeometricObject.outputedge1()+" side2 = "+GGeometricObject.outputedge2()+" side3 = "+GGeometricObject.outputedge3());
        System.out.println("The area is "+GGeometricObject.area());
        System.out.println("The perimeter is "+GGeometricObject.perimeter());
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
    public String getColor() {                                  //Return color
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
    }//call toString的時候會override 但是這題沒有用到
    public abstract double area();                                 // Abstract method getArea
    public abstract double perimeter();                      //Abstract method getPerimeter
    public abstract double outputedge1();
    public abstract double outputedge2();
    public abstract double outputedge3();
}
class Triangle extends GeometricObject {
    private double getEdge1, getEdge2, getEdge3;
    public Triangle(double edge1,double edge2,double edge3,String color,boolean filled){
        getEdge1=edge1;
        getEdge2=edge2;
        getEdge3=edge3;
        setColor(color);
        setFilled(filled);
    }
    public double area(){
        double S=(getEdge1+getEdge2+getEdge3)/2;
        double area_all=Math.sqrt(S*(S-getEdge1)*(S-getEdge2)*(S-getEdge3));
        return area_all;
    }
    public double outputedge1(){
        return getEdge1;
    }
    public double outputedge2(){
        return getEdge2;
    }
    public double outputedge3(){
        return getEdge3;
    }
    public double perimeter(){
        double preimeter_all=getEdge1+getEdge2+getEdge3;
        return preimeter_all;
    }
}
