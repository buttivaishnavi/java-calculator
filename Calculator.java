import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Calculator {
    public static void main(String[] args) {
        int num1 = 0, num2 = 0, result = 0;
        char op = '+';

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("===== Simple Calculator =====");
            System.out.print("Enter first number: ");
            num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            num2 = sc.nextInt();

            System.out.print("Choose an operation (+, -, *, /): ");
            op = sc.next().charAt(0);
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("⚠️ No input detected — using default values (5 + 3)");
            num1 = 5;
            num2 = 3;
            op = '+';
        }

        switch (op) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': 
                if (num2 != 0) result = num1 / num2;
                else {
                    System.out.println("Division by zero not allowed.");
                    return;
                }
                break;
            default: 
                System.out.println("Invalid operation");
                return;
        }

        System.out.println("Result = " + result);
        sc.close();
    }
}
