package tech.asmussen;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean debugMode = false;

        if (args.length > 0) {

             debugMode = args[0].equalsIgnoreCase("debug");
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

            final int YEAR = Integer.parseInt(input);
            final boolean IS_LEAP_YEAR = calculator.isLeapYear(YEAR);

            System.out.println("Year " + DECIMAL_FORMAT.format(YEAR) + ((IS_LEAP_YEAR) ? " is " : " isn't ") + "a leap year!");

            if (debugMode) {

                final double END_TIME = (System.currentTimeMillis() - START_TIME) / 1_000D;
                final String[] TIME = String.valueOf(END_TIME).split("\\.");

                System.out.printf("Time: %s second(s) and %s millisecond(s).%n", TIME[0], TIME[1]);
            }
        }
    }
}
