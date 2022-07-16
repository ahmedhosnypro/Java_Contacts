import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int remainingDays = scanner.nextInt();

        var date = LocalDate.of(year, month, 1);
        var dayOfMonth = date.lengthOfMonth();
        System.out.println(date.plusDays(dayOfMonth - remainingDays));
    }
}