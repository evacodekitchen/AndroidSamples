package hu.bme.testdemoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        startFragment(new HomeFragment(), HomeFragment.class.getName());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startFragment(new HomeFragment(), HomeFragment.class.getName());
                    return true;
                case R.id.navigation_dashboard:
                    startFragment(new DashboardFragment(), DashboardFragment.class.getName());
                    return true;
                case R.id.navigation_notifications:
                    startFragment(new NotificationsFragment(), NotificationsFragment.class.getName());
                    return true;
            }
            return false;
        }
    };

    private void startFragment(Fragment fragment, String fragmentName) {
        View frameLayout = findViewById(R.id.frame);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment, fragmentName);

        fragmentTransaction.commit();
    }

}
