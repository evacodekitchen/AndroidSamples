package evacodekitchen.stopwatch;


import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withChild;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class StopWatchUiTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public StopWatchUiTests() {
        super(MainActivity.class);
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    @Test
    public void newLap_ShouldBeAddedToLapsList() {
        //given
        onView(withId(R.id.lapsRecyclerView)).check(matches(not(hasDescendant(withText(any(String.class))))));

        //when
        onView(withId(R.id.startButton)).perform(ViewActions.click());
        onView(withId(R.id.markButton)).perform(ViewActions.click());

        //then
        onView(withId(R.id.lapsRecyclerView)).check(matches(hasDescendant(withText(any(String.class)))));
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }


}