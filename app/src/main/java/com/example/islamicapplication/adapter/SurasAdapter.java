package com.example.islamicapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.islamicapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurasAdapter extends RecyclerView.Adapter<SurasAdapter.SurasViewHolder> {

    private String[] mSurasNamesList;
    private OnItemClickListener onItemClickListener;

    public SurasAdapter(String[] mSurasNamesList) {
        this.mSurasNamesList = mSurasNamesList;
    }

    @NonNull
    @Override
    public SurasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SurasViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_sura, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SurasViewHolder surasViewHolder, int i) {
        final String name = mSurasNamesList[i];
        surasViewHolder.suraName.setText(name);
    }

    @Override
    public int getItemCount() {
        return mSurasNamesList.length;
    }

    class SurasViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sura_name)
        TextView suraName;

        private final View view;

        public SurasViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (onItemClickListener != null && position != RecyclerView.NO_POSITION) {
                        onItemClickListener.onItemClick(position, mSurasNamesList[position]);
                    }
                }
            });

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos,String suraName);
    }
}
