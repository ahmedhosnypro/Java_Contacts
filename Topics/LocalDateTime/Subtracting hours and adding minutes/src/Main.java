import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var dateTime = LocalDateTime.parse(scanner.nextLine());

        var hours = scanner.nextInt();
        var minutes = scanner.nextInt();
        dateTime = dateTime.minusHours(hours).plusMinutes(minutes);

        System.out.println(dateTime);
    }
}