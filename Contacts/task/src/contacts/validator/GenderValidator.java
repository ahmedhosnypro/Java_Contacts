package contacts.validator;

public class GenderValidator {

    public static String validateAndReturn(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Bad gender!");
            return "";
        }

        if (isValid(input)) {
            return input;
        }
        return "";
    }

    private static boolean isValid(String input) {
        return input.equals("M") || input.equals("F");
    }
}
