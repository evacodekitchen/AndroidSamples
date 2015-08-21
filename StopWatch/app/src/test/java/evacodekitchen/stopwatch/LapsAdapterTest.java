package evacodekitchen.stopwatch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.robolectric.shadows.ShadowContext;
import org.robolectric.shadows.ShadowContextImpl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LapsAdapterTest {

    @Test
    public void newLap_shouldBeAddedToLaps() {
        //given
        LapsAdapter lapsAdapter = new LapsAdapter();

        //then
        assertThat(lapsAdapter.laps.size(), is(0));

        //when
        lapsAdapter.addLap(2);

        //then
        assertThat(lapsAdapter.laps.size(), is(1));
    }

    @Test
    public void ellipsedTimeOfNewLap_shouldBeSetOnTextView() {
        //given
        LapsAdapter lapsAdapter = new LapsAdapter();

        //when
        lapsAdapter.addLap(66);

        TextView textViewMock = Mockito.mock(TextView.class);
        View viewItemMock = Mockito.mock(View.class);
        when(viewItemMock.findViewById(R.id.ellipsedSeconds)).thenReturn(textViewMock);
        lapsAdapter.onBindViewHolder(new LapsAdapter.LapViewHolder(viewItemMock), 0); //invoked normally by the layout manager

        //then
        verify(textViewMock).setText("66");
    }

    @Test
    public void lapsCount_shouldBeReturned() {
        //given
        LapsAdapter lapsAdapter = new LapsAdapter();

        lapsAdapter.addLap(66);
        lapsAdapter.addLap(77);
        lapsAdapter.addLap(45);

        //when
        int lapsCount = lapsAdapter.getItemCount();

        //then
        assertThat(lapsCount, is(3));

    }
}