package com.yoga.farmer.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.yoga.farmer.activity.Farm_Reg_Activity;
import com.yoga.farmer.R;
import com.yoga.farmer.adapter.RecyclerViewAdapter;
import com.yoga.farmer.model.ModelFeilds;
import com.yoga.farmer.net.respose.ResFarmList;
import com.yoga.farmer.net.retrofit.CallGenerator;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyField extends Fragment {
    public RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayout lyt_not_found;
    private CardView Card1, Card2, Card3, Card4;
    Context context;
    ArrayList arrayList;
    private Realm realm;
    public MyField() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_my_field, container, false);
        Card1=(CardView)rootView.findViewById(R.id.card_registration);
        Card2=(CardView)rootView.findViewById(R.id.card_fram1);
        Card3=(CardView)rootView.findViewById(R.id.card_fram2);
        Card4=(CardView)rootView.findViewById(R.id.card_fram3);
        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Farm_Reg_Activity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        getFramList();


        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
       /* int columns = getResources().getInteger(R.integer.number_of_column);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columns));
       *//* ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(requireActivity(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);*/
        return rootView;
    }

    private void getFramList() {
        CallGenerator.getFarmList().enqueue(new Callback<ResFarmList>() {
            @Override
            public void onResponse(Call<ResFarmList> call, Response<ResFarmList> response) {
                if(response.isSuccessful())
                {
                    ResFarmList resFarmList =response.body();
                    insertIntoFarm(resFarmList);
                }
                else
                {

                }
            }

            @Override
            public void onFailure(Call<ResFarmList> call, Throwable t) {

            }
        });
    }

    private void insertIntoFarm(ResFarmList resFarmList) {
        arrayList = new ArrayList();
        List<ResFarmList.CropEntity> listFarm=resFarmList.getList();
        for (int i=0;i<listFarm.size();i++) {
            ResFarmList.CropEntity farm =listFarm.get(i);
            arrayList.add(new ModelFeilds(farm.getFarm_name(),farm.getFarm_area(),farm.getSub_crop_name(), R.drawable.sugarcane, "#09A9FF"));
        }
        /*arrayList.add(new ModelFeilds("Sugar Cane", R.drawable.sugarcane, "#09A9FF"));
        arrayList.add(new ModelFeilds("Tomato", R.drawable.tomato, "#3E51B1"));
        arrayList.add(new ModelFeilds("Item 3", R.drawable.wsslid2, "#673BB7"));
        arrayList.add(new ModelFeilds("Item 4", R.drawable.mind, "#4BAA50"));
        arrayList.add(new ModelFeilds("Item 5", R.drawable.tomato, "#F94336"));
        arrayList.add(new ModelFeilds("Item 6", R.drawable.sugarcane, "#0A9B88"));*/

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), arrayList,this);
        recyclerView.setAdapter(adapter);
    }
}
