package contacts.validator;

public class NameValidator {
    public static String validateAndReturn(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Bad name!");
            return "";
        }
        return input;
    }
}
