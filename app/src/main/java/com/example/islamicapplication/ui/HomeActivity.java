package com.example.islamicapplication.ui;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.islamicapplication.R;
import com.example.islamicapplication.ui.fragment.HadethFragment;
import com.example.islamicapplication.ui.fragment.QuranFragment;
import com.example.islamicapplication.ui.fragment.SebhaFragment;
import static com.example.islamicapplication.helper.HelperMethod.*;

public class HomeActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_quran:
                    fragment = new QuranFragment();
                    break;

                case R.id.navigation_hadeth:
                    fragment = new HadethFragment();
                    break;

                case R.id.navigation_sebha:
                    fragment = new SebhaFragment();
                    break;
            }

            replaceFragments(fragment, getSupportFragmentManager(), R.id.FrameLayoutFragment_Container);

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_quran);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
