package coffee.muammeralper.com.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;

public class SecondActivity extends AppCompatActivity {
    GestureDetectorCompat bcompac;
    TopFragment top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        bcompac = new GestureDetectorCompat(this, new MyGestureListener());

        FragmentManager manager = getSupportFragmentManager();
        top = (TopFragment) manager.findFragmentById(R.id.fragmentTop);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        bcompac.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDoubleTap(MotionEvent event) {

            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            Bundle b = new Bundle();
            b.putString("address", top.getAddress());
            b.putString("name", Commons.data.get(Commons.curentItemIndex).getName());
            b.putString("price", Commons.data.get(Commons.curentItemIndex).getPirce());
            b.putString("desc", Commons.data.get(Commons.curentItemIndex).getDesc());
            b.putString("user", getIntent().getExtras().getString("user"));
            Log.d("deneme", Commons.data.get(Commons.curentItemIndex).getDesc());
            intent.putExtras(b);
            startActivity(intent);
            return true;
        }


    }


}
