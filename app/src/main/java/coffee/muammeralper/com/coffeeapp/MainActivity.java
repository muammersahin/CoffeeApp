package coffee.muammeralper.com.coffeeapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button login, register;
    CustomLoginDialog loginDialog;
    CustomRegisterDialog registerDialog;
    DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        login = findViewById(R.id.loginBtn);
        register = findViewById(R.id.registerBtn);

        databaseHelper = new DatabaseHelper(this);
        loginDialog = new CustomLoginDialog(databaseHelper, this);
        registerDialog = new CustomRegisterDialog(databaseHelper,this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginDialog.displayDialog();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerDialog.displayDialog();

            }
        });



    }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("coffee.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
