package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView iconanchor;
    Animation roundingalone;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        iconanchor = findViewById(R.id.icanchor);
        timerHere = findViewById(R.id.timerHere);

        // create optional animation
        btnstop.setAlpha(0);

        // load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        // import font
        Typeface SourceSansProSemiBold = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-SemiBold.ttf");

        // customize font
        btnstart.setTypeface(SourceSansProSemiBold);
        btnstop.setTypeface(SourceSansProSemiBold);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // passing animation
                iconanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                // start time
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });
    }
}
