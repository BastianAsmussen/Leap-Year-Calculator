package tech.asmussen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!input.equalsIgnoreCase("exit")) {

            System.out.print("What year do you want to know is a leap year? ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {

                break;
            }

            int year = Integer.parseInt(input);
            boolean isLeapYear = calculator.isLeapYear(year);

            if (isLeapYear) {

                System.out.println("Year " + year + " is a leap year!");

            } else {

                System.out.println("Year " + year + " isn't a leap year!");
            }
        }
    }
}
