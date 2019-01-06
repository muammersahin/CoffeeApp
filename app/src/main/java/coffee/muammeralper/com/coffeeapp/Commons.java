package coffee.muammeralper.com.coffeeapp;

import android.database.Cursor;

import java.util.ArrayList;

public class Commons {
    public static ShoppingItems curentShopingItem;
    public static  Cursor cursor;
    public static int curentItemIndex=0;
    public static ArrayList<ShoppingItems> getData() {
        return data;
    }
    public static ArrayList<ShoppingItems> data = new ArrayList<>();

    public static void setData(ArrayList<ShoppingItems> data) {
        Commons.data = data;
    }
    public static ShoppingItems getCurentShopingItem() {
        return curentShopingItem;
    }
    public static void setCurentShopingItem(ShoppingItems curentShopingItem) {
        Commons.curentShopingItem = curentShopingItem;
    }

}
