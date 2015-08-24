package evacodekitchen.stopwatch;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TimeFormatterTest {
    @Test
    public void threeSec_shouldBeFormatted(){
        checkThatFormatsGivenMillisTo(3567L, "00:03");
    }

    @Test
    public void oneMinAndOneSec_shouldBeFormatted() {
        checkThatFormatsGivenMillisTo(61000L, "01:01");
    }
    @Test
    public void oneHourAndOneSec_shouldBeFormatted() {
        checkThatFormatsGivenMillisTo(3601000L, "01:00:01");
    }

    @Test
    public void twoHourAndOneMinAndFourSec_shouldBeFormatted() {
        checkThatFormatsGivenMillisTo(7264000L, "02:01:04");
    }

    @Test
    public void tenHours_shouldBeFormatted() {
        checkThatFormatsGivenMillisTo(36000000L, "10:00:00");
    }


    private void checkThatFormatsGivenMillisTo(Long milliseconds, String formattedTime) {
        //when
        String timeInSeconds = TimeFormatter.format(milliseconds);

        //then
        assertThat(timeInSeconds, is(formattedTime));
    }
}
