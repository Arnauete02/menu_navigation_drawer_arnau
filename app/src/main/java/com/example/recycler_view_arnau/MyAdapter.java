package com.example.recycler_view_arnau;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Geographic> mGeographics = new ArrayList<>();
    private Context mContext;

    public MyAdapter(ArrayList<Geographic> mGeographics, Context mContext) {
        this.mGeographics = mGeographics;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Picasso.get().load(mGeographics.get(position).getUrl())
                .fit()
                .centerCrop()
                .into(holder.url);
        holder.text_title.setText(mGeographics.get(position).getText());
        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);

                intent.putExtra("text_title", mGeographics.get(holder.getAdapterPosition()).getText());
                intent.putExtra("url", mGeographics.get(holder.getAdapterPosition()).getUrl());
                intent.putExtra("desc", mGeographics.get(holder.getAdapterPosition()).getDesc());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGeographics.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView url;
        private TextView text_title;
        private TextView desc;

        ConstraintLayout rowLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            url = itemView.findViewById(R.id.url);
            text_title = itemView.findViewById(R.id.text_title);
            desc = itemView.findViewById(R.id.desc_2);
            rowLayout = itemView.findViewById(R.id.rowLayout);
        }
    }
}
