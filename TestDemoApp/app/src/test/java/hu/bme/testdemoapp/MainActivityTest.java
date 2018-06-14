package hu.bme.testdemoapp;

import android.app.Activity;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.security.acl.NotOwnerException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private FragmentActivity activityUnderTest;

    @Before
    public void setup() {
        //given
        activityUnderTest = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void shouldSetTheBottomNavigationMenu() {
        //given
        BottomNavigationView bottomNavigationView = (BottomNavigationView) shadowOf(activityUnderTest).findViewById(R.id.navigation);
        Menu menu = bottomNavigationView.getMenu();

        //then
        assertThat(menu.findItem(R.id.navigation_home).getTitle().toString(), is("Home"));
        assertThat(menu.findItem(R.id.navigation_dashboard).getTitle().toString(), is("Dashboard"));
        assertThat(menu.findItem(R.id.navigation_notifications).getTitle().toString(), is("Notifications"));
    }

    @Test
    public void homeFragmentShouldBeStarted() {
        //given
        FrameLayout frame = activityUnderTest.findViewById(R.id.frame);

        //then
        assertNotNull(frame);

        //and
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().size(), is(1));
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().get(0).getTag(), is(HomeFragment.class.getName()));
    }

    @Test
    public void shouldSwitchToDashboardFragment() {
        //when
        activityUnderTest.findViewById(R.id.navigation_dashboard).performClick();

        //then
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().size(), is(1));
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().get(0).getTag(), is(DashboardFragment.class.getName()));
    }

    @Test
    public void shouldSwitchToNotificationsFragment() {
        //when
        activityUnderTest.findViewById(R.id.navigation_notifications).performClick();

        //then
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().size(), is(1));
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().get(0).getTag(), is(NotificationsFragment.class.getName()));
    }

    @Test
    public void shouldSwitchToHomeFragment() {
        //when
        activityUnderTest.findViewById(R.id.navigation_notifications).performClick();

        //and
        activityUnderTest.findViewById(R.id.navigation_home).performClick();

        //then
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().size(), is(1));
        assertThat(activityUnderTest.getSupportFragmentManager().getFragments().get(0).getTag(), is(HomeFragment.class.getName()));
    }
}
