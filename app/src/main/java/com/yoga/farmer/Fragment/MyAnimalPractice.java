package com.yoga.farmer.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoga.farmer.FarmTips;
import com.yoga.farmer.KidManagementActivity;
import com.yoga.farmer.QuestionActivity;
import com.yoga.farmer.R;
import com.yoga.farmer.SuccessStoryActivity;
import com.yoga.farmer.activity.DisesesManagementActivity;
import com.yoga.farmer.activity.ExperimentActivity;
import com.yoga.farmer.activity.FarmPlanActivity;

public class MyAnimalPractice extends Fragment {
    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_animal_practice, container, false);
        cardView1=view.findViewById(R.id.card_registration);
        cardView2=view.findViewById(R.id.card_fram1);
        cardView3=view.findViewById(R.id.card_fram2);
        cardView4=view.findViewById(R.id.card_fram3);
        cardView5=view.findViewById(R.id.card_fram4);
        cardView6=view.findViewById(R.id.card_fram5);
        cardView7=view.findViewById(R.id.card_fram6);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plan=new Intent(getContext(), FarmPlanActivity.class);
                startActivity(plan);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kid=new Intent(getContext(), KidManagementActivity.class);
                startActivity(kid);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dises=new Intent(getContext(), DisesesManagementActivity.class);
                startActivity(dises);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), FarmTips.class);
                startActivity(intent);
                }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent experiment=new Intent(getContext(), ExperimentActivity.class);
                startActivity(experiment);

            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent success=new Intent(getContext(), SuccessStoryActivity.class);
                startActivity(success);

            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent question=new Intent(getContext(), QuestionActivity.class);
                startActivity(question);
            }
        });

        return view;
    }

   }
