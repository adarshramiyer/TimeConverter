import java.util;
import java.util.Scanner;
import java.lang.Math;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Your mark (mm:ss.ms): ");
        String time = scan.next();
        double totalTime = convertFromTime(time);
        //System.out.println(totalTime);
        System.out.print("Mark distance: ");
        double distance1 = scan.nextDouble();
        while(true) {
            System.out.print("Convert to distance: ");
            double distance2 = scan.nextDouble();
            double conversionFactor = (distance2 / distance1);
            // System.out.println(conversionFactor);
            double newTotalTime = totalTime * conversionFactor;
            //System.out.println(newTotalTime);
            printTime(newTotalTime);
            System.out.println("\n");
        }
    }

    public static double convertFromTime(String originalTime) {
        double numberSeconds = 0;
        String Minutes = "";
        int firstColonIndex = 0;
        for (int i = 0; i < 3; i++) {
            //System.out.println(originalTime.charAt(i));
            if (originalTime.charAt(i) == ':') {
                firstColonIndex = i;
                break;
            }
            Minutes += originalTime.charAt(i);
        }
        //System.out.println("firstColonIndex" + Integer.toString(firstColonIndex));
        //System.out.println(Minutes);
        numberSeconds += Double.parseDouble(Minutes) * 60;
        numberSeconds += Double.parseDouble(originalTime.substring(firstColonIndex+1, firstColonIndex+3));
        numberSeconds += Double.parseDouble(originalTime.substring(firstColonIndex+4, firstColonIndex+6)) / 100;
        //System.out.println(numberSeconds);
        return numberSeconds;
    }

    public static void printTime(double time) {
        int numMinutes = (int) (time - (time % 60)) / 60;
        int numSeconds = (int) (time - (numMinutes * 60));
        double numMilliseconds = (time % 1);

        int formattedMillis = (int) Math.round(numMilliseconds * 100);

        //System.out.println(formattedMillis);

        //System.out.println(numMilliseconds);
        String minutesString = Integer.toString(numMinutes);
        String secondsString = Integer.toString(numSeconds);
        String milliString = String.valueOf(formattedMillis);

        if (secondsString.length() == 1) {
            secondsString = "0" + secondsString;
        }
        if (milliString.length() == 1) {
            milliString = "0" + milliString;
        }
        System.out.print("Your projected time is " +
                minutesString + ":" +
                secondsString + "." +
                milliString);

    }
}