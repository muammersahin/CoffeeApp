package coffee.muammeralper.com.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    GestureDetectorCompat bcompac;
    Intent intent;
    TextView address, name, price, desc;
    String ad, nm, pr, dsc, user;
    DatabaseOrderHelper doh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        doh = new DatabaseOrderHelper(this);

        bcompac = new GestureDetectorCompat(this, new MyGestureListener2());
        intent = getIntent();
        Bundle b = intent.getExtras();
        ad = b.getString("address");
        nm = b.getString("name");
        pr = b.getString("price");
        dsc = b.getString("desc");
        user = b.getString("user");
        address = findViewById(R.id.finalAddress);
        name = findViewById(R.id.cofName);
        price = findViewById(R.id.cofPrice);
        desc = findViewById(R.id.cofDesc);


        address.setText(ad);
        name.setText(nm);
        price.setText(pr);
        desc.setText(dsc);

    }

    public boolean onTouchEvent(MotionEvent event) {
        bcompac.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener2 extends GestureDetector.SimpleOnGestureListener {

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);


            OrderDB.insertStu(doh, user, pr, ad, dsc, nm);

            Intent newIntent = new Intent(ThirdActivity.this, ForthActivity.class);
            Bundle b = new Bundle();
            b.putString("name", nm);
            b.putString("address", ad);
            b.putString("desc", dsc);
            b.putString("price", pr);
            intent.putExtras(b);
            startActivity(newIntent);


        }
    }

}
