package coffee.muammeralper.com.coffeeapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    Context context;

    SecondActivity fragment;
    private Resources res = null;


    public MyRecyclerViewAdapter(Context context) {
        this.context = context;
        fragment = (SecondActivity) context;
        res = fragment.getResources();

    }

    public void modifyData(){
        notifyDataSetChanged();
        notifyItemRangeChanged(0, Commons.data.size());
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recycler_item_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //BIND DATA
        final ShoppingItems contact = Commons.data.get(position);
        int resourceId = res.getIdentifier(contact.getImage(), "drawable",
                context.getPackageName());
        holder.img.setImageResource(resourceId);
        holder.tvName.setText(contact.getName());
        holder.tvAmount.setText(contact.getPirce()+"");
        Log.d("Degerler",  contact.getName());
    }

    @Override
    public int getItemCount() {
        return Commons.data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout layout;
        TextView tvName, tvAmount;
        ImageView img;

        MyViewHolder(final View viewItem){
            super(viewItem);
            tvName = viewItem.findViewById(R.id.tvName);
            img = viewItem.findViewById(R.id.img);
            tvAmount = viewItem.findViewById(R.id.tvAmount);
            layout = viewItem.findViewById(R.id.constLayout);

            viewItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Commons.curentShopingItem = Commons.data.get(getLayoutPosition());

                    Commons.curentItemIndex = getLayoutPosition();

                    Toast.makeText(fragment, "You selected: " + Commons.data.get(Commons.curentItemIndex).getName(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
