package hu.bme.testdemoapp;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;
import org.robolectric.util.FragmentTestUtil;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
public class HomeFragmentTest {
    @Test
    public void shouldShowMessage() throws Exception {
        Fragment fragmentUnderTest = new HomeFragment();
        SupportFragmentTestUtil.startFragment(fragmentUnderTest);

        TextView message = fragmentUnderTest.getView().findViewById(R.id.home_message);
        assertThat(message.getText().toString(), is("Home"));
    }

}
