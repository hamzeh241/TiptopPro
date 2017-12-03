package com.tiptap.tda_user.tiptap.main.activity.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tiptap.tda_user.tiptap.R;

public class Splash extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        img = (ImageView)findViewById(R.id.img);

        Animation animation = new TranslateAnimation(800,0,0,0);
        animation.setDuration(4000);
        animation.setFillAfter(true);

        img.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation arg0) {}
            @Override
            public void onAnimationRepeat(Animation arg0) {}
            @Override
            public void onAnimationEnd(Animation arg0) {
                startActivity(new Intent(Splash.this, Language.class));
                Splash.this.finish();
            }
        });
    }
}