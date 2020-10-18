package com.example.a100daysofpushup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateOps {

    // Function to print difference in
    // time start_date and end_date
    static int
    findDifference(String start_date,
                   String end_date)
    {

        // SimpleDateFormat converts the
        // string format to date object
        final SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy");

        int difference_In_Days = -99;
        // Try Block
        try {

            // parse method is used to parse
            // the text from a string to
            // produce the date
            final Date d1 = sdf.parse(start_date);
            final Date d2 = sdf.parse(end_date);

            // Calucalte time difference
            // in milliseconds
            final long difference_In_Time
                    = d2.getTime() - d1.getTime();

            // Calucalte time difference in
            // seconds, minutes, hours, years,
            // and days
            final long difference_In_Seconds
                    = (difference_In_Time
                    / 1000)
                    % 60;

            final long difference_In_Minutes
                    = (difference_In_Time
                    / (1000 * 60))
                    % 60;

            final long difference_In_Hours
                    = (difference_In_Time
                    / (1000 * 60 * 60))
                    % 24;

            final long difference_In_Years
                    = (difference_In_Time
                    / (1000l * 60 * 60 * 24 * 365));

            difference_In_Days
                    = (int)(difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds

            System.out.print(
                    "Difference "
                            + "between two dates is: ");

            System.out.println(
                    difference_In_Years
                            + " years, "
                            + difference_In_Days
                            + " days, "
                            + difference_In_Hours
                            + " hours, "
                            + difference_In_Minutes
                            + " minutes, "
                            + difference_In_Seconds
                            + " seconds");
        }

        // Catch the Exception
        catch (final ParseException e) {
            e.printStackTrace();
        }
        return difference_In_Days;
    }

    // find date difference with current date
    static int
    findDifferenceCurrentDate(String start_date) {
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        final Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        return findDifference(start_date, formatter.format(date));
    }

    // Driver Code
    public static void main(String[] args)
    {
        // Given start Date
        final String start_date
                = "10-01-2020";

        // Given end Date
        final String end_date
                = "10-06-2020";

        // Function Call
        findDifference(start_date, end_date);

        // Given start Date
        final String start_date1 = "10-01-2018";

        // Given end Date
        final String end_date1 = "10-06-2020";

        // Function Call
        findDifference(start_date1, end_date1);

        // Given start Date
        final String start_date2 = "10-10-2020";

        // Given end Date
        // final String end_date2 = "14-10-2020";

        // Function Call
        // findDifference(start_date2, end_date2);

        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        final Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        findDifference(start_date2, formatter.format(date));
    }


}





