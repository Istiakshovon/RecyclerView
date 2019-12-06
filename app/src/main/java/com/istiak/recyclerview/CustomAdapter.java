package com.istiak.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {


    Context context;
    private String countryList[];
    private int imgList[];

    //constructor
    public CustomAdapter(Context context, String countryList[],int imgList[]) {
        this.context = context;
        this.countryList = countryList;
        this.imgList=imgList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(view); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myHolder, final int position) {

        myHolder.txtName.setText(countryList[position]);
        myHolder.imgCountry.setImageResource(imgList[position]);
        // implement setOnClickListener event on item view.
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, countryList[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        ImageView imgCountry;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // get the reference of item view's
            txtName =  itemView.findViewById(R.id.txt_name);
            imgCountry =  itemView.findViewById(R.id.img_flag);
        }
    }
}
