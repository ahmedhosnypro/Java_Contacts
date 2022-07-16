package contacts.validator;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class BirthDateValidator {
    private BirthDateValidator() {
    }

    private static final String BIRTH_DATE_REGEX = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    private static final Pattern BIRTH_DATE_PATTERN = Pattern.compile(BIRTH_DATE_REGEX);


    private static boolean isValid(String birthDate) {
        return BIRTH_DATE_PATTERN.matcher(birthDate).matches();
    }

    private static final String BAD_BIRTH = "Bad birth date!";


    public static String validateAndReturn(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println(BAD_BIRTH);
            return "";
        }
        if (isValid(input)) {
            return input;
        } else {
            System.out.println(BAD_BIRTH);
            return "";
        }
    }

    public static LocalDateTime getValidDateOrNull(String input) {
        LocalDateTime birthDateTime = null;
        try {
            birthDateTime = LocalDateTime.parse(validateAndReturn(input));
        } catch (Exception e) {
            System.out.println(BAD_BIRTH);
        }
        return birthDateTime;
    }
}