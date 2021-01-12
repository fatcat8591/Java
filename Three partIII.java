package com.company;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.String;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        postfixClass PFC =new postfixClass();       //class到main裡面以PFC代替
        BigDecimal all=PFC.calculate(input);        //class 的end會傳到main裡面叫做all
        System.out.printf("%.2f",all.doubleValue());
        System.out.println();
    }
}
class postfixClass{
    static String[] Tokenizer(String input){
        StringTokenizer str1 = new StringTokenizer(input, "+*-/%()", true);
        int size_str1 = str1.countTokens();
        String[] str1tk = new String[size_str1];
        int count=0;
        while (str1.hasMoreTokens()) {
            str1tk[count] = str1.nextToken();
            count++;                                //存到陣列
        }
        return str1tk;
    }
    static String[] Tokenizer_all(String input) {
        StringTokenizer str2 = new StringTokenizer(input, "+*-/%", true);
        int size_str2 = str2.countTokens();
        String[] str2tk = new String[size_str2];   //最後出的答案我要存進str2tk
        Stack<String> str = new Stack<String>();
        String[] str1tk;
        str1tk = Tokenizer(input);                 //從上面的static傳str1tk下來
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
                    while (true) {
                        if (str.peek().equals("(")) {
                            str.pop();
                            break;
                        } else {
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
                    str2tk[count2] = str1tk[i];
                    count2++;
                    if (i == str1tk.length - 1) {                         //當數字為最後一個字
                        while (!str.isEmpty()) {
                            str2tk[count2] = str.peek();
                            str.pop();
                            count2++;
                        }
                    }
            }
        }
        return str2tk;
    }
    static BigDecimal calculate(String input){
        String [] str2tk =Tokenizer_all(input);                   //從Tokenizer_all傳已經做好的str2tk下來做
        Stack<String> str=new Stack<String>();
        BigDecimal X,Y;
        BigDecimal end=new BigDecimal(0);
        for(int i=0;i<str2tk.length;i++){
            String operation=str2tk[i];
            switch (operation){
                case"+":
                    X=new BigDecimal(str.peek());
                    str.pop();
                    Y=new BigDecimal(str.peek());
                    str.pop();
                    end=X.add(Y);
                    str.push(end.toString());
                    continue;
                case "-":
                    Y=new BigDecimal(str.peek());               //特別注意減的時候要從後面POP出來
                    str.pop();                                  //如果先POP X在POP Y 等等5*3-3會變成-12而不是12
                    X=new BigDecimal(str.peek());               //會出現stack層級上的問題
                    str.pop();
                    end=X.subtract(Y);
                    str.push(end.toString());
                    continue;
                case "*":
                    X=new BigDecimal(str.peek());
                    str.pop();
                    Y=new BigDecimal(str.peek());
                    str.pop();
                    end=X.multiply(Y);
                    str.push(end.toString());
                    continue;
                case "/":
                    Y=new BigDecimal(str.peek());               //跟"-"一樣 要先從後面POP
                    str.pop();                                  //不然會有stack層級上的問題
                    X=new BigDecimal(str.peek());               //而且除法會比減法嚴重，會直接壞掉
                    str.pop();
                    end=X.divide(Y);
                    str.push(end.toString());
                    continue;
                case "%":
                    Y=new BigDecimal(str.peek());
                    str.pop();
                    X=new BigDecimal(str.peek());
                    str.pop();
                    end=X.remainder(Y);
                    str.push(end.toString());
                    continue;
                default:
                    str.push(str2tk[i]);
            }
            if(i==str2tk.length-1){                                 //i==長度-1 代表最後一個字了 要做輸出
                BigDecimal endfor = new BigDecimal(str.peek());
                str.pop();                                          //pop出來丟到endfor 再把endfor丟到end
                end=endfor;
            }
        }
        return end;
    }
}