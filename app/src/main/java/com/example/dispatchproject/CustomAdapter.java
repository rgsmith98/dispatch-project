package com.example.dispatchproject;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DataModel> dataSet;

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        TextView txtViewProductname = holder.txtview_productname;
        TextView txtViewProductPrice = holder.txtview_productprice;

        txtViewProductname.setText(dataSet.get(position).getProduct_name());
        txtViewProductPrice.setText(dataSet.get(position).getProduct_price());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
        //return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtview_productname;
        TextView txtview_productprice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtview_productname = (TextView) itemView.findViewById(R.id.product_name);
            this.txtview_productprice = (TextView) itemView.findViewById(R.id.product_price);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data){
        this.dataSet = data;
    }
}
