package contacts.validator;

import java.util.regex.Pattern;

public class PhoneNumberValidator {

    private PhoneNumberValidator() {
    }

    /*
     * The phone number should be split into groups using a space or dash. One group is also possible.
     * Before the first group, there may or may not be a plus symbol.
     * The first group or the second group can be wrapped in parentheses,
     * but there should be no more than one group which is wrapped in parentheses.
     * There may be no groups wrapped in parentheses.
     * A group can contain numbers, uppercase, and lowercase English letters.
     * A group should be at least 2 symbols in length. But the first group may be only one symbol in length.
     * */

    private static final String PHONE_NUMBER_REGEX = "^\\+?([\\da-zA-Z]+[\\s-]?)?" +
            "(\\([\\da-zA-Z]{2,}(\\)[\\s-]|\\)$))?" +
            "([\\da-zA-Z]{2,}[\\s-]?)*([\\da-zA-Z]{2,})?$";
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);

    private static boolean isValid(String phoneNumber) {
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }


    public static String validateAndReturn(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Bad birth date!");
            return "";
        }

        if (isValid(input)) {
            return input;
        } else {
            System.out.println("Wrong number format!");
            return "";
        }
    }
}
