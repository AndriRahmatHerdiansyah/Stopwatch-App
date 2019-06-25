package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash, tvSubSplash;
    Button btnget;
    Animation atg, btgone, btgtwo;
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = (TextView) findViewById(R.id.tvSplash);
        tvSubSplash = (TextView) findViewById(R.id.tvSubSplash);
        btnget = (Button) findViewById(R.id.btnget);
        ivSplash = findViewById(R.id.ivSplash);

        // load animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        // passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btnget.startAnimation(btgtwo);

        // passing event
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, StopWatchAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        // import font
        Typeface PlayfairDisplay = Typeface.createFromAsset(getAssets(), "fonts/PlayfairDisplay-Bold.ttf");
        Typeface SourceSansProRegular = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        Typeface SourceSansProSemiBold = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-SemiBold.ttf");

        // customize font
        tvSplash.setTypeface(PlayfairDisplay);
        tvSubSplash.setTypeface(SourceSansProRegular);
        btnget.setTypeface(SourceSansProSemiBold);
    }
}
