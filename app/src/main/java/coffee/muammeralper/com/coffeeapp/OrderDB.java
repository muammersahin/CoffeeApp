package coffee.muammeralper.com.coffeeapp;

import android.content.ContentValues;

public class OrderDB {


    public static final String TABLE_NAME="orders";
    public static final String FIELD_NAME = "username";
    public static final String FIELD_ORDERNAME = "ordername";
    public static final String FIELD_PRICE = "orderprice";
    public static final String FIELD_DESC = "orderdesc";
    public static final String FIELD_ADDRESS = "orderaddress";


    public static final String CREATE_TABLE_SQL = "CREATE TABLE "+TABLE_NAME+" ("+FIELD_NAME+ " text, "+ FIELD_ORDERNAME+" text, "+FIELD_PRICE+" text, "+FIELD_DESC+" text, "+FIELD_ADDRESS+" text);";
    public static final String DROP_TABLE_SQL = "DROP TABLE if exists "+TABLE_NAME;



    public static long insertStu(DatabaseOrderHelper db, String username, String price, String address ,String desc, String ordername){
        ContentValues contentValues = new ContentValues( );
        contentValues.put(FIELD_NAME, username);
        contentValues.put(FIELD_ORDERNAME, ordername);
        contentValues.put(FIELD_PRICE, price);
        contentValues.put(FIELD_ADDRESS, address);
        contentValues.put(FIELD_DESC, desc);


        long res = db.insert(TABLE_NAME,contentValues);

        return res;
    }



}
