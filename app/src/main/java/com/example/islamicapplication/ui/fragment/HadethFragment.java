package com.example.islamicapplication.ui.fragment;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.islamicapplication.R;
import com.example.islamicapplication.adapter.HadethAdapter;
import com.example.islamicapplication.custom_font.TextViewCustomFont;
import com.example.islamicapplication.helper.model.Hadeth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class HadethFragment extends Fragment {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;

    //var
    private List<Hadeth> mAhadethName;
    private HadethAdapter mHadethAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public HadethFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hadeth, container, false);
        unbinder = ButterKnife.bind(this, view);

        readFile();
        layoutManager = new LinearLayoutManager(getActivity());
        mHadethAdapter = new HadethAdapter(mAhadethName);
        mHadethAdapter.setOnItemClickListener(new HadethAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Hadeth hadeth) {
                showCustomDialog(hadeth);
            }
        });
        recyclerView.setAdapter(mHadethAdapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    public void showCustomDialog(Hadeth hadeth) {

        Dialog dialog = new Dialog(getContext());

        // before
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorYellowT)));
        dialog.setCancelable(true);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;

        final TextViewCustomFont mTextViewCustomFontTitle = dialog.findViewById(R.id.title);
        final TextViewCustomFont mTextViewCustomFontCntent = dialog.findViewById(R.id.content);

        mTextViewCustomFontTitle.setText(hadeth.getmTitle());
        mTextViewCustomFontCntent.setText(hadeth.getmContent());

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    public void readFile(){
        mAhadethName = new ArrayList<>();
        BufferedReader reader;

        try{
            final InputStream file = getActivity().getAssets().open("ahadeth.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = null;

            while((line = reader.readLine())!= null){
                String title = line;
                String content = "";

                while((line = reader.readLine())!= null){

                    if(line.equals("#")) {
                        break;
                    }

                    content = content + "\n" + line;
                }
                Hadeth hadeth = new Hadeth(title,content);
                mAhadethName.add(hadeth);
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
