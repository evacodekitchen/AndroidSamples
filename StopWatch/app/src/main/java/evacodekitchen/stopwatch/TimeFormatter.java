package evacodekitchen.stopwatch;

import java.util.concurrent.TimeUnit;

public class TimeFormatter {

    public static String format(long milliseconds) {
        Long totalSeconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        Long totalMinutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        Long totalMinutesInSeconds = TimeUnit.MINUTES.toSeconds(totalMinutes);
        Long totalHours = TimeUnit.MILLISECONDS.toHours(milliseconds);
        if (totalHours > 0) {
            long totalHoursInMinutes = TimeUnit.HOURS.toMinutes(totalHours);
            return String.format("%02d:%02d:%02d", totalHours, totalMinutes - totalHoursInMinutes, totalSeconds - totalMinutesInSeconds);
        } else {
            return String.format("%02d:%02d", totalMinutes, totalSeconds - totalMinutesInSeconds);
        }
    }
}
