package com.yoga.farmer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoga.farmer.R;
import com.yoga.farmer.net.respose.ResCrop;
import com.yoga.farmer.net.respose.ResState;

import java.util.List;

public class SpinnerStateAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    private List<ResState.StateEntity> mList;
    public SpinnerStateAdapter(Context applicationContext, List<ResState.StateEntity> list) {
        this.context = applicationContext;
        this.mList= list;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return this.mList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        //icon.setImageURI(this.contestEntities.get(i).getContestImg());
        names.setText(mList.get(i).getState_name());
        return view;
    }
}