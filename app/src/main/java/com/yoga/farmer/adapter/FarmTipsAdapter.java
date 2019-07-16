package com.yoga.farmer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoga.farmer.R;

public class FarmTipsAdapter extends RecyclerView.Adapter<FarmTipsAdapter.FarmTipsClass> {
    private Context context;

    public FarmTipsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FarmTipsClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.farm_tips_adapter, null);
        return new FarmTipsAdapter.FarmTipsClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmTipsAdapter.FarmTipsClass holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
public  class FarmTipsClass extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView Title,Crop,Body,Date,Location;
    public FarmTipsClass(View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.imgCrop);
        Title=itemView.findViewById(R.id.title);
        Crop=itemView.findViewById(R.id.cropName);
        Body=itemView.findViewById(R.id.body);
        Date=itemView.findViewById(R.id.date);
        Location=itemView.findViewById(R.id.location);
    }
}
}
