/* Author: David Jefts
 *
 * Description: Convert day of the year and time to am/pm time and mm/dd/yyyy date format, accounting for leap years
 *
 * Statement coverage, conditional coverage and branch coverage: This example allows for the demonstration of these
 * 																 types of techniques. Since there are conditions to be
 * 																 met and loops this provides different paths in a simple
 * 																 and short program. One could test different types of
 * 																 input parameters to achieve this as well as passing/failing
 * 																 conditions.
 */
public class WBExample {
    private String a = "";

    public static void main(String[] args) {
        WBExample wbExample = new WBExample();
        System.out.println(wbExample.convertDateTime("2009/2/21:29:46.000"));
    }

    public String convertDateTime(String datetime) {
        // Convert date and time using the day of the year and military time into a human readable date and standard time
        int year;
        int days;
        int hours;
        int minutes;
        int seconds;

        // Parse input datetime
        String[] dateString;
        String[] timeString;
        if (datetime.matches("\\d{4}/\\d{1,3}/\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d+")) {
            // YYYY/DDD/HH:MM:SS.SSSSSSSSSSSSSSSSSSS
            dateString = datetime.split("/");
            timeString = dateString[2].split(":");
            seconds = (int) Double.parseDouble(timeString[2]);
        } else if (datetime.matches("\\d{4}/\\d{1,3}/\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            // YYYY/DDD/HH:MM:SS
            dateString = datetime.split("/");
            timeString = dateString[2].split(":");
            seconds = Integer.parseInt(timeString[2]);
        } else if (datetime.matches("\\d{4}-\\d{1,3}-\\d{1,2}:\\d{1,2}:\\d{1,2}.\\d+")) {
            // YYYY-DDD-HH:MM:SS.SSSSSSSSSSSSSSSSSSS
            dateString = datetime.split("-");
            timeString = dateString[2].split(":");
            seconds = (int) Double.parseDouble(timeString[2]);
        } else if (datetime.matches("\\d{4}-\\d{1,3}-\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            // YYYY-DDD-HH:MM:SS
            dateString = datetime.split("-");
            timeString = dateString[2].split(":");
            seconds = Integer.parseInt(timeString[2]);
        } else {
            dateString = null;
            timeString = null;
            seconds = 0;
            System.out.println("Unknown datetime format");
            System.exit(1);
        }
        year = Integer.parseInt(dateString[0]);
        days = Integer.parseInt(dateString[1]);
        hours = Integer.parseInt(timeString[0]);
        minutes = Integer.parseInt(timeString[1]);

        String mon = "";
        int day = 0;

        int[] days_per_month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        // Check for leap year
        if (year % 4 == 0 || (year % 400 == 0 && year % 100 != 0)) {
            days_per_month[1] = 29; // leap year
        }

        // Convert date
        int days_count = days;
        for (int i = 0; i < days_per_month.length; i++) {
            if (days_count <= days_per_month[i]) {
                mon = months[i];
                day = days_count;
                break;
            }
            days_count = days_count - days_per_month[i];
        }

        // Get the ordinal indicator (st, nd, rd, th)
        String ordinal = "" + day;
        if (day > 10 && day < 20) {  // teens are special
            ordinal += "th";
        } else if (day % 10 == 1) {  // first
            ordinal += "st";
        } else if (day % 10 == 2) {  // second
            ordinal += "nd";
        } else if (day % 10 == 3) {  // third
            ordinal += "rd";
        } else {  //rest-th
            ordinal = "th";
        }

        // Convert time
        String time = "";
        if (hours > 12) {
            time += (hours - 12) + ":" + minutes + ":" + seconds + "pm";
        } else {
            time += hours + ":" + minutes + ":" + seconds + "am";
        }
        return "" + time + " on " + mon + " " + ordinal + ", " + year;
    }
}
