package utilities;

public class RandomDataGenerator {

    public static String generateEmail() {
        return "test" + System.currentTimeMillis() + "@gmail.com";
    }

    public static String generateFirstName() {
        return "Sudhir";
    }

    public static String generateLastName() {
        return "Patil";
    }

    public static String generatePhoneNumber() {
        return "9876543210";
    }

    public static String generatePassword() {
        return "Test@123";
    }
}