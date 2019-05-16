package com.example.islamicapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamicapplication.R;
import com.example.islamicapplication.custom_font.TextViewCustomFont;
import com.example.islamicapplication.helper.model.Hadeth;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HadethAdapter extends RecyclerView.Adapter<HadethAdapter.HadethHolder> {

    private List<Hadeth> allAhadeth;
    private OnItemClickListener onItemClickListener;

    public HadethAdapter(List<Hadeth> allAhadeth) {
        this.allAhadeth = allAhadeth;
    }

    @NonNull
    @Override
    public HadethHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HadethHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_verse, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HadethHolder hadethHolder, final int i) {

        final Hadeth hadeth=allAhadeth.get(i);
        hadethHolder.text.setText(hadeth.getmTitle());

        if(onItemClickListener!=null){
            hadethHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(i, hadeth);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return allAhadeth.size();
    }

    class HadethHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text)
        TextViewCustomFont text;

        private final View view;

        public HadethHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, view);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int pos, Hadeth hadeth);
    }
}
