import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Simple Calculator =====");
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Choose an operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        int result = 0;
        switch (op) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': 
                if (num2 != 0) result = num1 / num2;
                else System.out.println("Division by zero not allowed.");
                break;
            default: System.out.println("Invalid operation");
        }

        System.out.println("Result = " + result);
        sc.close();
    }
}
