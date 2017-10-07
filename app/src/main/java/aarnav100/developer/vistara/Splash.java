package aarnav100.developer.vistara;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setContentView(R.layout.activity_splash);
        startAnimation();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        }, 2500);
    }
    public void startAnimation() {
        float scale = getResources().getDisplayMetrics().density;
        final View someImage = findViewById(R.id.plane);
        ObjectAnimator animx = ObjectAnimator.ofFloat(someImage,
                "x", 00.0f * scale, 250.0f * scale);
        ObjectAnimator animy = ObjectAnimator.ofFloat(someImage,
                "y", 480.0f * scale, 00.0f * scale);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(2000);
        animSet.play(animx).with(animy);
        animSet.start();
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                someImage.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
