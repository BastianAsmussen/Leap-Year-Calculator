package tech.asmussen;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final boolean DEBUG_MODE = args.length > 0 && args[0].equalsIgnoreCase("--debug");

        final Calculator CALCULATOR = new Calculator();

        final Scanner SCANNER = new Scanner(System.in);

        String input = "";

        while (!input.equalsIgnoreCase("exit")) {

            System.out.print("Is this year a leap year? ");
            input = SCANNER.nextLine();

            if (input.equalsIgnoreCase("exit")) {

                break;
            }

            final long START_TIME = System.currentTimeMillis();

            final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,###");

            final long YEAR = Long.parseLong(input);
            final boolean IS_LEAP_YEAR = CALCULATOR.isLeapYear(YEAR);

            System.out.println("Year " + DECIMAL_FORMAT.format(YEAR) + ((IS_LEAP_YEAR) ? " is " : " isn't ") + "a leap year!");

            if (DEBUG_MODE) {

                final double END_TIME = (System.currentTimeMillis() - START_TIME) / 1_000D;
                final String[] TIME = String.valueOf(END_TIME).split("\\.");

                System.out.printf("Time: %s second(s) and %s millisecond(s).%n", TIME[0], TIME[1]);
            }
        }
    }
}
