package com.example.islamicapplication.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapplication.R;
import com.example.islamicapplication.adapter.SurasAdapter;
import com.example.islamicapplication.helper.HelperMethod;
import com.example.islamicapplication.ui.SuraDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.islamicapplication.helper.Constant.ArSuras;
import static com.example.islamicapplication.helper.Constant.FILE_NAME;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends Fragment {


    @BindView(R.id.QuranFragmentRecyclerView)
    RecyclerView QuranFragmentRecyclerView;
    Unbinder unbinder;

    // var
    private SurasAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public QuranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quran, container, false);
        unbinder = ButterKnife.bind(this, view);

        mLayoutManager = new GridLayoutManager(getActivity(),3, LinearLayoutManager.HORIZONTAL,false);
        mAdapter = new SurasAdapter(ArSuras);
        QuranFragmentRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setOnItemClickListener(new SurasAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String suraName) {
                Intent intent = new Intent(getActivity(), SuraDetailsActivity.class);
                intent.putExtra(FILE_NAME,(pos + 1) + ".txt");
                startActivity(intent);
            }
        });
        QuranFragmentRecyclerView.setAdapter(mAdapter);




        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
