package coffee.muammeralper.com.coffeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class TopFragment extends Fragment {

    EditText address;
    TextView name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        address = view.findViewById(R.id.editAddress);
        Intent intent = getActivity().getIntent();
        Bundle b = intent.getExtras();
        name = view.findViewById(R.id.txtNameFrg);
        name.setText(b.getString("user"));
        Log.d("name is: ", name.getText().toString());




    }

    public String getAddress(){
        return address.getText().toString();
    }

}
