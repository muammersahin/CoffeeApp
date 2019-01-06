package coffee.muammeralper.com.coffeeapp;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class UserDB {


    public static final String TABLE_NAME="user";
    public static final String FIELD_USERNAME = "username";
    public static final String FIELD_PASSWORD = "name";
    public static final String FIELD_NAME = "gpa";
    public static final String FIELD_SURNAME = "type";
    public static final String FIELD_ADDRESS = "type";


    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_USERNAME+" text, "+FIELD_PASSWORD+" text, "+FIELD_NAME+" text, "+FIELD_SURNAME+" text, "+FIELD_ADDRESS+"text);";
    public static final String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;


    public static List<User> findUser(DatabaseHelper db, String username, String password){

        String where = FIELD_USERNAME+" like '%"+username+"%' AND " + FIELD_PASSWORD+" like '%"+password+"%'";
        Cursor cursor = db.getSomeRecords(TABLE_NAME,null, where);
        List<User> data=new ArrayList<>();
        User user = null;
        while (cursor.moveToNext()) {
            String usename = cursor.getString(0);
            String pasword = cursor.getString(1);
            String name = cursor.getString(2);
            String surname = cursor.getString(3);
            String address = cursor.getString(4);

            user = new User(usename, pasword, name, surname, address);
            data.add(user);
        }

        return data;
    }


    public static long insertStu(DatabaseHelper db, String username, String password, String name,String surname,String address){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_USERNAME, username);
        contentValues.put(FIELD_PASSWORD, password);
        contentValues.put(FIELD_NAME, name);
        contentValues.put(FIELD_SURNAME, surname);
        contentValues.put(FIELD_ADDRESS, address);


        long res = db.insert(TABLE_NAME,contentValues);


        return res;
    }



}
