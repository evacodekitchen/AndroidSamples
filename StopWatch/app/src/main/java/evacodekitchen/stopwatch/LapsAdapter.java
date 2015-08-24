package evacodekitchen.stopwatch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LapsAdapter extends RecyclerView.Adapter<LapsAdapter.LapViewHolder> {

    protected List<String> laps;

    public LapsAdapter() {
        laps = new ArrayList<>();
    }

    @Override
    public LapViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lap_row, viewGroup, false);
        return new LapViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LapViewHolder viewHolder, int i) {
        viewHolder.ellipsedTimeTextview.setText(laps.get(i));
    }

    @Override
    public int getItemCount() {
        return laps.size();
    }

    public void addLap(String ellipsedTime) {
        laps.add(ellipsedTime);
    }

    protected static class LapViewHolder extends RecyclerView.ViewHolder {
        public TextView ellipsedTimeTextview;

        public LapViewHolder(View itemView) {
            super(itemView);
            this.ellipsedTimeTextview = (TextView) itemView.findViewById(R.id.ellipsedSeconds);
        }
    }

}
