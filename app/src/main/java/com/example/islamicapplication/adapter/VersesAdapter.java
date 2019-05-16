package com.example.islamicapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapplication.R;
import com.example.islamicapplication.custom_font.TextViewCustomFont;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.VersesHolder> {


    private ArrayList<String> verses;

    public VersesAdapter(ArrayList<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public VersesHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VersesHolder(LayoutInflater.from(
                viewGroup.getContext()).inflate(R.layout.item_view_verse, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VersesHolder versesHolder, int i) {
        String aya = verses.get(i)+"("+(i + 1)+")";
        versesHolder.text.setText(aya);
    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    class VersesHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text)
        TextViewCustomFont text;

        private final View view;

        VersesHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
