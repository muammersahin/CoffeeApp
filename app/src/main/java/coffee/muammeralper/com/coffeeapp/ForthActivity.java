package coffee.muammeralper.com.coffeeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ForthActivity extends AppCompatActivity {

    Spinner spinner;
    private String[] kurlar = {"0", "1", "2", "3", "4", "5"};
    private ArrayAdapter<String> dataAdapter;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.voteBtn);
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kurlar);

        spinner.setAdapter(dataAdapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String vote = spinner.getSelectedItem().toString();
                Toast.makeText(ForthActivity.this, "Your vote for this shopping is "+ vote, Toast.LENGTH_LONG).show();


            }
        });


    }
}
