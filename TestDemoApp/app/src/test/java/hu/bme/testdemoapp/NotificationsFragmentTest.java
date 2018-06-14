package hu.bme.testdemoapp;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class NotificationsFragmentTest {
    @Test
    public void shouldShowMessage() throws Exception {
        Fragment fragmentUnderTest = new NotificationsFragment();
        SupportFragmentTestUtil.startFragment(fragmentUnderTest);

        TextView message = fragmentUnderTest.getView().findViewById(R.id.notifications_message);
        assertThat(message.getText().toString(), is("Notifications"));
    }

}
