package tech.hyperdev.scorekeeper.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    FrameLayout firstFrame, secondFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.theme_array, android.R.layout.activity_list_item);
//        Fragment fragment = null;
//        fragment = new ScoreFragment();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.activity_main,fragment);
//        ft.commit();
        if(savedInstanceState == null) {
            firstFrame = (FrameLayout) findViewById(R.id.FirstFrame);
            secondFrame = (FrameLayout) findViewById(R.id.SecondFrame);

            Fragment first = ScoreFragment.newInstance("Team 1");
            Fragment second = ScoreFragment.newInstance("Team 2");

            FragmentTransaction one = getSupportFragmentManager().beginTransaction();
            getSupportFragmentManager().beginTransaction();
            one.replace(R.id.FirstFrame, first).commit();

            FragmentTransaction two = getSupportFragmentManager().beginTransaction();
            getSupportFragmentManager().beginTransaction();
            two.replace(R.id.SecondFrame, second).commit();
        }

    }
}
