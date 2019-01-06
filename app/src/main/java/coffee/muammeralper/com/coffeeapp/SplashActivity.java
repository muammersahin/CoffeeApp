package coffee.muammeralper.com.coffeeapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    Intent intent;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Locking the orientation to Portrait
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show your application logo or company logo
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your application's main activity which is a ListView
                intent = new Intent(SplashActivity.this, MainActivity.class);

                // Close this activity
                finish();

                startActivity(intent);
            }
        }, SPLASH_TIME_OUT);
        
    }
}
