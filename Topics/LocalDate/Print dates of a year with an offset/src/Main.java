import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var inputDate = scanner.nextLine();
        var date = LocalDate.parse(inputDate);
        int year = date.getYear();

        int offset = scanner.nextInt();

        while (date.getYear() == year) {
            System.out.println(date);
            date = date.plusDays(offset);
        }
    }
}