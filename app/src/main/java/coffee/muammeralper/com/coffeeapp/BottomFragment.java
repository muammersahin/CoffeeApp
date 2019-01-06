package coffee.muammeralper.com.coffeeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class BottomFragment extends Fragment {
    RecyclerView rc;
    MyRecyclerViewAdapter myR;
    JSONObject coffee;
    JSONArray coffees;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rc = view.findViewById(R.id.coffeeRec);



        String cofeeStr = loadJSONFromAsset(view.getContext());
        try {
            coffee = new JSONObject(cofeeStr);
            coffees = coffee.getJSONArray("coffees");
            for(int i = 0; i<coffees.length(); i++){
                JSONObject o = (JSONObject) coffees.get(i);
                String name = o.getString("name");
                String price = o.getString("price");
                String image = o.getString("img");
                String desc = o.getString("desc");
                ShoppingItems cof =  new ShoppingItems(name, price, desc, image);
                Commons.data.add(cof);
                Log.d("testicin", cof.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        rc.setLayoutManager(new LinearLayoutManager(getActivity()));

        myR = new MyRecyclerViewAdapter(getActivity());
        rc.setAdapter(myR);


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
