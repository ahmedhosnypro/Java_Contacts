package contacts;

import contacts.cli.CLI;

import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        CLI.run();
    }
}
