import java.util.Scanner;

public class FractionSimplifier {
    // Method to calculate the Greatest Common Divisor (GCD) iteratively
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to simplify the fraction
    public static void simplifyFraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Denominator cannot be zero.");
            return;
        }
        
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        // If the denominator is negative, make both numerator and denominator positive/negative
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        System.out.println("Simplified fraction: " + numerator + "/" + denominator);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input numerator and denominator from user
        System.out.print("Enter the numerator: ");
        int numerator = scanner.nextInt();

        System.out.print("Enter the denominator: ");
        int denominator = scanner.nextInt();

        simplifyFraction(numerator, denominator);

        scanner.close();
    }

  public static int gcdrecur(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
