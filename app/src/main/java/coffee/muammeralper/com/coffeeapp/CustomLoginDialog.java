package coffee.muammeralper.com.coffeeapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class CustomLoginDialog {

    Dialog customDialog;
    MainActivity mainActivity;
    DatabaseHelper dbHelper;
    Intent intent;

    CustomLoginDialog(DatabaseHelper dbHelper, MainActivity mainActivity) {
        this.dbHelper = dbHelper;
        this.mainActivity = mainActivity;
    }

    public void displayDialog() {

        final EditText username, password;
        Button btnLogin, btnClose;

        customDialog = new Dialog(mainActivity);
        customDialog.setContentView(R.layout.logindialog);

        username = customDialog.findViewById(R.id.usernameTxt);
        password = customDialog.findViewById(R.id.passwordTxt);

        btnLogin = customDialog.findViewById(R.id.loginOk);
        btnClose = customDialog.findViewById(R.id.closeBtn);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = username.getText().toString();
                String pass = password.getText().toString();

                List<User> check = UserDB.findUser(dbHelper, name, pass);

                if (!check.isEmpty()) {
                  //  Toast.makeText(mainActivity, "Login successful", Toast.LENGTH_LONG).show();
                    intent = new Intent(mainActivity, SecondActivity.class);
                    Bundle b = new Bundle();
                    b.putString("user", username.getText().toString());
                    intent.putExtras(b);
                    mainActivity.startActivity(intent);
                } else {
                    Toast.makeText(mainActivity, "Login unsuccessful, check username and password", Toast.LENGTH_LONG).show();

                }

            }
        });


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                customDialog.dismiss();
            }
        });
        customDialog.show();
    }
}
