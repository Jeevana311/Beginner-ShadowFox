import java.util.InputMismatchException;
import java.util.Scanner;

public class EnhancedCalculator {

    // Basic Operations
    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    // Scientific Operations
    static double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Square root of negative number not allowed.");
        }
        return Math.sqrt(a);
    }

    static double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Temperature Conversion
    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Currency Conversion (Static Rate Example)
    static double inrToUsd(double inr) {
        double rate = 0.012;   // Example conversion rate
        return inr * rate;
    }

    static double usdToInr(double usd) {
        double rate = 83.0;   // Example conversion rate
        return usd * rate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            try {
                System.out.println("\n====== ENHANCED CONSOLE CALCULATOR ======");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Square Root");
                System.out.println("6. Power");
                System.out.println("7. Celsius to Fahrenheit");
                System.out.println("8. Fahrenheit to Celsius");
                System.out.println("9. INR to USD");
                System.out.println("10. USD to INR");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                double a, b;

                switch (choice) {

                    case 1:
                        System.out.print("Enter two numbers: ");
                        a = sc.nextDouble();
                        b = sc.nextDouble();
                        System.out.println("Result: " + add(a, b));
                        break;

                    case 2:
                        System.out.print("Enter two numbers: ");
                        a = sc.nextDouble();
                        b = sc.nextDouble();
                        System.out.println("Result: " + subtract(a, b));
                        break;

                    case 3:
                        System.out.print("Enter two numbers: ");
                        a = sc.nextDouble();
                        b = sc.nextDouble();
                        System.out.println("Result: " + multiply(a, b));
                        break;

                    case 4:
                        System.out.print("Enter two numbers: ");
                        a = sc.nextDouble();
                        b = sc.nextDouble();
                        System.out.println("Result: " + divide(a, b));
                        break;

                    case 5:
                        System.out.print("Enter a number: ");
                        a = sc.nextDouble();
                        System.out.println("Result: " + squareRoot(a));
                        break;

                    case 6:
                        System.out.print("Enter base and exponent: ");
                        a = sc.nextDouble();
                        b = sc.nextDouble();
                        System.out.println("Result: " + power(a, b));
                        break;

                    case 7:
                        System.out.print("Enter Celsius: ");
                        a = sc.nextDouble();
                        System.out.println("Result: " + celsiusToFahrenheit(a) + " °F");
                        break;

                    case 8:
                        System.out.print("Enter Fahrenheit: ");
                        a = sc.nextDouble();
                        System.out.println("Result: " + fahrenheitToCelsius(a) + " °C");
                        break;

                    case 9:
                        System.out.print("Enter INR amount: ");
                        a = sc.nextDouble();
                        System.out.println("Result: " + inrToUsd(a) + " USD");
                        break;

                    case 10:
                        System.out.print("Enter USD amount: ");
                        a = sc.nextDouble();
                        System.out.println("Result: " + usdToInr(a) + " INR");
                        break;

                    case 0:
                        System.out.println("Exiting calculator...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.next(); // clear invalid input
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}