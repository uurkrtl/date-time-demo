package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime afterTwoWeeks = now.plusWeeks(2);
        DateTimeFormatter dateFormatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        //Step 1: Write code to output the current date and time.
        System.out.println("Now (in date and time): " + now.format(dateTimeFormatter));

        //Step 2: Add a timespan of 2 weeks to the current date and output the new date.
        System.out.println("After 2 weeks (in date): " + afterTwoWeeks.format(dateFormatter));

        //Step 3: Compare the current date with a specified future date and output whether the current date is before or after the specified date.
        System.out.println(now.format(dateFormatter) + (now.isBefore(afterTwoWeeks) ? " is before " : " is after ") + afterTwoWeeks.format(dateFormatter));

        //Step 4: Calculate the difference in days between two arbitrary dates and output the result.
        System.out.printf("There are %d days between %s and %s%n", (int) ChronoUnit.DAYS.between(now, afterTwoWeeks), now.format(dateFormatter).toString(), afterTwoWeeks.format(dateFormatter).toString());

        //Bonus: Print on the command line how many days are left until the next birthday of the animal.
        Animal cat = new Animal("Mittens", LocalDate.of(2015, 5, 31));
        LocalDate nextBirthday = cat.getBirthday().withYear(now.getYear()).isBefore(now.toLocalDate()) ? cat.getBirthday().withYear(now.getYear() + 1) : cat.getBirthday().withYear(now.getYear());
        System.out.printf("%nThere are %d days left until %s's next birthday%n", (int) ChronoUnit.DAYS.between(now.toLocalDate(), nextBirthday), cat.getName());
    }
}