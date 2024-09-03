public class ISBNValidator {

    public static boolean isValidISBN(String isbn) {
        // ISBN should have exactly 13 digits
        if (isbn == null || isbn.length() != 13) {
            return false;
        }

        int sum = 0;

        // Iterate through each digit in the ISBN
        for (int i = 0; i < 13; i++) {
            // Get the numeric value of the digit
            int digit = Character.digit(isbn.charAt(i), 10);

            // If the character is not a digit, return false
            if (digit == -1) {
                return false;
            }

            // Apply the alternating weight of 1 and 3
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += 3 * digit;
            }
        }

        // The ISBN is valid if the sum modulo 10 is 0
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        // Test cases for valid ISBNs
        String[] validISBNs = {
            "9780306406157", // Example ISBN from a book
            "9780134685991", // Clean Code by Robert C. Martin
            "9780201633610", // Design Patterns: Elements of Reusable Object-Oriented Software
        };

        // Test cases for invalid ISBNs
        String[] invalidISBNs = {
            "9780306406156", // Wrong check digit
            "9780134685990", // Wrong check digit
            "9780201633619", // Wrong check digit
            "123456789012",  // Less than 13 digits
            "abcdefghijklm", // Non-digit characters
        };

        // Test the valid ISBNs
        for (String isbn : validISBNs) {
            System.out.println(isbn + " is valid: " + isValidISBN(isbn));
        }

        // Test the invalid ISBNs
        for (String isbn : invalidISBNs) {
            System.out.println(isbn + " is valid: " + isValidISBN(isbn));
        }
    }
}
