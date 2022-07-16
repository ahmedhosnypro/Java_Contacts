import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var dateTime = LocalDateTime.parse(scanner.nextLine());
        var year = dateTime.getYear();
        var beginningOfYear = LocalDateTime.of(year, 1, 1, 0, 0);

        Duration duration = Duration.between(beginningOfYear, dateTime);
        var hours = duration.toHours();
        System.out.println(hours);
    }
}