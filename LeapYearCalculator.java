package dev.asmussen;

import java.io.IOException;
import java.util.Scanner;

public class LeapYearCalculator {

    public static boolean isLeapYear(int year) {
        
        boolean value = false;

        if (year >= 1 && year <= 9999) {

            if (year % 4 == 0) {

                if (year % 100 == 0) {

                    if (year % 400 == 0) {
                        value = true;
                    }
                    
                } else {
                    
                    value = true;
                }
            }
        }

        return value;
    }

    public static void menu() throws NumberFormatException, IOException {

        boolean yearDefiner = true;
        Scanner reader = new Scanner(System.in);

        int convertedInput = -1;
        
        while (yearDefiner == true) {
            
            System.out.println("Hvilket år vil du gerne vide var et skudår?");
            String userInput = reader.nextLine();

            try {
                convertedInput = Integer.parseInt(userInput);
                yearDefiner = false;

            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt år. Prøv igen!");
            }
        }

        int year = convertedInput;
        boolean value = isLeapYear(year);

        String returnValue;
        
        if(value == true) {
            
            returnValue = "Året " + year + " er et skudår!";

        } else {
            
            returnValue = "Året " + year + " er ikke et skudår!";
        }

        System.out.println(returnValue);
    }
}
