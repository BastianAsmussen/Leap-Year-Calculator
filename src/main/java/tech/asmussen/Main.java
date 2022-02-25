package tech.asmussen;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean debugMode = false;

        if (args.length > 0) {

             debugMode = (args[0] != null) && (args[0].equalsIgnoreCase("debug"));
        }


        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!input.equalsIgnoreCase("exit")) {

            System.out.print("What year do you want to know is a leap year? ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {

                break;
            }

            final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,###");

            final long START_TIME = System.currentTimeMillis();

            int year = Integer.parseInt(input);
            boolean isLeapYear = calculator.isLeapYear(year);

            System.out.println("Year " + DECIMAL_FORMAT.format(year) + ((isLeapYear) ? " is " : " isn't ") + "a leap year!");

            if (debugMode) {

                final double END_TIME = (System.currentTimeMillis() - START_TIME) / 1_000D;
                final String[] TIME = String.valueOf(END_TIME).split("\\.");

                System.out.printf("Time: %s second(s) and %s millisecond(s).%n", TIME[0], TIME[1]);
            }
        }
    }
}
