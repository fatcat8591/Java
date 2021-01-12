package com.company;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Stack<String> str = new Stack<String>();
        StringTokenizer str1 = new StringTokenizer(input, "+*-/%()", true);
        int size_str1 = str1.countTokens();
        String[] str1tk = new String[size_str1];

        StringTokenizer str2 = new StringTokenizer(input, "+*-/%", true);
        int size_str2 = str2.countTokens();
        String[] str2tk = new String[size_str2];

        int count = 0;
        while (str1.hasMoreTokens()) {
            str1tk[count] = str1.nextToken();
            count++;                            //存到陣列
        }
        count = 0;
        int count2 = 0;
        for (int i = 0; i < str1tk.length; i++) {
            String operation = str1tk[i];         //丟出來一個一個判斷
            switch (operation) {
                case "(":
                    str.push(str1tk[i]);
                    continue;
                case "+":
                case "-":
                    if (str.isEmpty() || str.peek().equals("(")) {
                            str.push(str1tk[i]);
                        } else {
                            while (true) {
                                if (!str.isEmpty() && !str.peek().equals("(")) {
                                    str2tk[count2] = str.peek();
                                    str.pop();
                                    count2++;
                                } else {
                                    break;
                                }
                            }
                            str.push(str1tk[i]);
                        }
                    continue;
                case "*":
                case "/":
                case "%":
                    if (str.isEmpty() || !(str.peek().equals("*") || str.peek().equals("/") || str.peek().equals("%"))) {
                        str.push(str1tk[i]);
                    } else {
                        while (true) {
                            if (str.isEmpty() || !(str.peek().equals("*") || str.peek().equals("/") || str.peek().equals("%"))) {
                                break;
                            } else {
                                str2tk[count2] = str.peek();
                                str.pop();
                                count2++;
                            }
                        }
                        str.push(str1tk[i]);
                    }
                    continue;
                case ")":
                    while (true){
                        if(str.peek().equals("(")){
                            str.pop();
                            break;
                        }
                        else{
                            str2tk[count2] = str.peek();
                            str.pop();
                            count2++;
                        }
                    }
                    if (i == str1tk.length - 1) {               //當右括號為最後一個，而且還要考慮左括號前面有可能有+-*/
                        while (!str.isEmpty()) {                //因為我上面的判斷是只有判斷 遇到"(" BREAK掉
                            str2tk[count2] = str.peek();        //就用一個一個去判斷前面有+-*/
                            str.pop();
                            count2++;
                        }
                    }
                    continue;
                default:
                    str2tk[count2]=str1tk[i];
                    count2++;
                    if(i==str1tk.length-1){                         //當數字為最後一個字
                        while (!str.isEmpty()){
                            str2tk[count2]=str.peek();
                            str.pop();
                            count2++;
                        }
                    }
            }
        }
        for(int j=0;j<str2tk.length;j++){
            System.out.print(str2tk[j]+" ");
        }
        System.out.println();
    }
}