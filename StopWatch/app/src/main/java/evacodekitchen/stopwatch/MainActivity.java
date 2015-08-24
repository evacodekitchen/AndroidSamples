package evacodekitchen.stopwatch;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Chronometer chronometer;
    protected Button startButton;
    protected Button resetButton;
    protected Button markButton;
    protected RecyclerView lapsRecyclerView;
    protected LapsAdapter lapsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        initButtons();
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        initLapsRecylerView();
    }

    private void initButtons() {
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);

        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);

        markButton = (Button) findViewById(R.id.markButton);
        markButton.setOnClickListener(this);
    }

    private void initLapsRecylerView() {
        lapsRecyclerView = (RecyclerView) findViewById(R.id.lapsRecyclerView);
        lapsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lapsAdapter = new LapsAdapter();
        lapsRecyclerView.setAdapter(lapsAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startButton:
                chronometer.start();
                break;
            case R.id.resetButton:
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                break;
            case R.id.markButton:
                addEllipsedTimeToLaps();
                break;
        }
    }

    private void addEllipsedTimeToLaps() {
        long ellipsedMilliSeconds =  SystemClock.elapsedRealtime() - chronometer.getBase();
        lapsAdapter.addLap(TimeFormatter.format(ellipsedMilliSeconds));
        lapsAdapter.notifyDataSetChanged();
    }
}
