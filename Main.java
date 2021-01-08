import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num, num1;
        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            num1 = 2;
            while (num > 1) {
                if (num % num1 == 0) {
                    System.out.print(num1);
                    num = num / num1;
                    if(num!=1)
                    {
                        System.out.print(" ");
                    }
                }
                else {
                    num1 = num1 + 1;
                }
            }
            System.out.println();
        }
    }
}
