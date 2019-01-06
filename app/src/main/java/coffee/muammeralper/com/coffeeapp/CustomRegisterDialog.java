package coffee.muammeralper.com.coffeeapp;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomRegisterDialog {

    Dialog customDialog;
    MainActivity mainActivity;
    DatabaseHelper dbHelper;
    Intent intent;

    CustomRegisterDialog(DatabaseHelper dbHelper, MainActivity mainActivity){
        this.dbHelper = dbHelper;
        this.mainActivity = mainActivity;
    }

    public void displayDialog(){

        final EditText username, password, name, surname, address;
        Button btnRegister, btnClose;

        customDialog = new Dialog(mainActivity);
        customDialog.setContentView(R.layout.registerlayout);

        username =  customDialog.findViewById(R.id.usernameR);
        password = customDialog.findViewById(R.id.passwordr);
        name = customDialog.findViewById(R.id.nameR);
        surname = customDialog.findViewById(R.id.surnameR);
        address = customDialog.findViewById(R.id.addressR);

        btnRegister = customDialog.findViewById(R.id.registerOk);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();
                String nam = name.getText().toString();
                String surna = surname.getText().toString();
                String add = address.getText().toString();

                UserDB.insertStu(dbHelper, uname, pass, nam, surna, add);
                Toast.makeText(mainActivity, "You are registered, you can now login!", Toast.LENGTH_LONG).show();
                customDialog.dismiss();

            }
        });


        customDialog.show();
    }
}

