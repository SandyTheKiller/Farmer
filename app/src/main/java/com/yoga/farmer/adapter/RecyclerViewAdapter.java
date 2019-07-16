package com.yoga.farmer.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yoga.farmer.Fragment.MyField;
import com.yoga.farmer.R;
import com.yoga.farmer.model.ModelFeilds;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList mValues;
    Context mContext;
    protected ItemListener mListener;

    public RecyclerViewAdapter(Context context, ArrayList values, MyField itemListener) {

        mValues = values;
        mContext = context;
        //mListener=itemListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvFarmArea,tvFarmName,tvCropName;
        public ImageView imageView;
        public RelativeLayout relativeLayout;
        ModelFeilds item;

        public ViewHolder(View v) {

            super(v);

            v.setOnClickListener(this);
            tvFarmName = (TextView) v.findViewById(R.id.tvFarmName);
            tvFarmArea = (TextView) v.findViewById(R.id.tvFarmArea);
            tvCropName = (TextView) v.findViewById(R.id.tvCropName);
            imageView = (ImageView) v.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);

        }

        public void setData(ModelFeilds item) {
            this.item = item;

            tvFarmName.setText(item.farmName);
            tvFarmArea.setText(item.farmArea);
            imageView.setImageResource(item.drawable);
            tvCropName.setText(item.subCropName);
            relativeLayout.setBackgroundColor(Color.parseColor(item.color));


        }


        @Override
        public void onClick(View view) {
            if (mListener != null) {
                mListener.onItemClick(item);
            }
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, int position) {
        Vholder.setData((ModelFeilds) mValues.get(position));

    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }

    public interface ItemListener {
        void onItemClick(ModelFeilds item);
    }
}
