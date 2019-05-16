package com.example.islamicapplication.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.islamicapplication.R;
import com.example.islamicapplication.adapter.CustomSpinnerAdapter;
import com.example.islamicapplication.custom_font.TextViewCustomFont;
import com.example.islamicapplication.helper.model.CustomSpinnerItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.islamicapplication.helper.HelperMethod.showToast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SebhaFragment extends Fragment {


    @BindView(R.id.SpinnerSebhaFragment)
    Spinner SpinnerSebhaFragment;
    Unbinder unbinder;
    @BindView(R.id.MentionCount)
    TextViewCustomFont MentionCount;
    @BindView(R.id.MentionTotalCount)
    TextViewCustomFont MentionTotalCount;
    @BindView(R.id.textViewCustomFont2)
    TextViewCustomFont textViewCustomFont2;
    @BindView(R.id.MentionImageButton)
    ImageButton MentionImageButton;
    @BindView(R.id.RefreshIconImageButton)
    ImageButton RefreshIconImageButton;
    @BindView(R.id.textViewCustomFont3)
    TextViewCustomFont textViewCustomFont3;
    @BindView(R.id.textViewCustomFont4)
    TextViewCustomFont textViewCustomFont4;

    // var
    private ArrayList<CustomSpinnerItem> customList;

    private int mTotalCount = 0;
    private int mCounter;

    private Animation mFromTop, mFromBottom;

    public SebhaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sebha, container, false);
        unbinder = ButterKnife.bind(this, view);

        mFromTop = AnimationUtils.loadAnimation(getContext(), R.anim.fromtop);
        mFromBottom = AnimationUtils.loadAnimation(getContext(), R.anim.frombottom);

        textViewCustomFont2.setAnimation(mFromTop);
        MentionImageButton.setAnimation(mFromTop);
        RefreshIconImageButton.setAnimation(mFromTop);


        textViewCustomFont3.setAnimation(mFromBottom);
        textViewCustomFont4.setAnimation(mFromBottom);
        MentionTotalCount.setAnimation(mFromBottom);
        MentionCount.setAnimation(mFromBottom);
        SpinnerSebhaFragment.setAnimation(mFromBottom);


        customList = getCustomList();
        CustomSpinnerAdapter customAdapter = new CustomSpinnerAdapter(getContext(), customList);

        if (SpinnerSebhaFragment != null) {
            SpinnerSebhaFragment.setAdapter(customAdapter);
            SpinnerSebhaFragment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    CustomSpinnerItem customSpinnerItem = (CustomSpinnerItem) parent.getSelectedItem();
                    showToast(getContext(), customSpinnerItem.getSpinnerItemName());
                    mCounter = 0;
                    MentionCount.setText(String.valueOf(mCounter));

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

        return view;
    }

    private ArrayList<CustomSpinnerItem> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomSpinnerItem("استغفر الله"));
        customList.add(new CustomSpinnerItem("سبحان الله"));
        customList.add(new CustomSpinnerItem("الحمدلله"));
        customList.add(new CustomSpinnerItem("لا اله الا الله"));
        customList.add(new CustomSpinnerItem("الله اكبر"));

        return customList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.MentionImageButton, R.id.RefreshIconImageButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.MentionImageButton:
                mTotalCount++;
                mCounter++;
                MentionTotalCount.setText(String.valueOf(mTotalCount));
                MentionCount.setText(String.valueOf(mCounter));
                break;

            case R.id.RefreshIconImageButton:
                mTotalCount = 0;
                mCounter = 0;
                MentionTotalCount.setText(String.valueOf(mTotalCount));
                MentionCount.setText(String.valueOf(mCounter));
                break;
        }
    }
}
