package evacodekitchen.stopwatch;


import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.internal.Shadow;
import org.robolectric.shadows.ShadowSystemClock;

import static org.assertj.android.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainActivityTest {

    private MainActivity activityUnderTest;

    @Before
    public void setUp() {
        activityUnderTest = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void chronometer_shouldBeOnScreen() {
        assertThat(activityUnderTest.chronometer).isNotNull();
        assertThat(activityUnderTest.chronometer).isVisible();
    }

    @Test
    public void startButton_shouldBeOnScreen() {
        checkButtonWithText(activityUnderTest.startButton, R.string.start);
    }

    @Test
    public void resetButton_shouldBeOnScreen() {
        checkButtonWithText(activityUnderTest.resetButton, R.string.reset);
    }

    @Test
    public void markButton_shouldBeOnScreen() {
        assertThat(activityUnderTest.markButton).isNotNull();
        assertThat(activityUnderTest.markButton).isVisible();
    }


    private void checkButtonWithText(Button resetButton, int textId) {
        assertThat(resetButton).isNotNull();
        assertThat(resetButton).isVisible();
        assertThat(resetButton).hasText(textId);
    }

    @Test
    public void chronometer_ShouldBeStartedOnStartButtonClick() {
        //given
        activityUnderTest.chronometer = mock(Chronometer.class);

        //when
        activityUnderTest.startButton.performClick();

        //then
        verify(activityUnderTest.chronometer, times(1)).start();
        verifyNoMoreInteractions(activityUnderTest.chronometer);
    }

    @Test
    public void chronometer_ShouldBeResetOnResetButtonClick() {
        //given
        activityUnderTest.chronometer = mock(Chronometer.class);

        //when
        activityUnderTest.resetButton.performClick();

        //then
        verify(activityUnderTest.chronometer, times(1)).stop();
        verify(activityUnderTest.chronometer, times(1)).setBase(SystemClock.elapsedRealtime());
        verifyNoMoreInteractions(activityUnderTest.chronometer);
    }

    @Test
    public void elapsedTime_ShouldBePassedToAdapter() {
        //given
        Chronometer chronometerMock = mock(Chronometer.class);
        when(chronometerMock.getBase()).thenReturn(SystemClock.elapsedRealtime() - 3000);
        activityUnderTest.chronometer = chronometerMock;

        activityUnderTest.lapsAdapter = mock(LapsAdapter.class);

        //when
        activityUnderTest.markButton.performClick();

        //then
        verify(activityUnderTest.lapsAdapter).addLap("00:03");
        verify(activityUnderTest.lapsAdapter).notifyDataSetChanged();
    }

}