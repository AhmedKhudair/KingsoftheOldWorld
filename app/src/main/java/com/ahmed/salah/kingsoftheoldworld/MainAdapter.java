package com.ahmed.salah.kingsoftheoldworld;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed on 21/10/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<KingsName>kingsNameList=new ArrayList<>();

    public MainAdapter(Context context, List<KingsName> kingsNameList) {
        this.context = context;
        this.kingsNameList = kingsNameList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.main_row,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final KingsName kingsName=kingsNameList.get(position);
        holder.textView.setText(kingsName.getName());
        Picasso.with(context)
                .load(kingsName.getImage())
                .resize(98, 98)
                .into(holder.img);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        Intent intent = new Intent(context,Info.class);
                        intent.putExtra("name", kingsName.getName());
                        intent.putExtra("content",kingsName.getHtml());
                        intent.putExtra("img",kingsName.getImage());
                        context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kingsNameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView    img;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            img=itemView.findViewById(R.id.img);
            cardView=itemView.findViewById(R.id.line1);
        }
    }
}
