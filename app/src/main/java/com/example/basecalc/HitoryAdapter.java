package com.example.basecalc;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HitoryAdapter extends RecyclerView.Adapter<HitoryAdapter.HitoryViewHolder> {

    private HitModel myModel;

    public HitoryAdapter(HitModel myModel){
        super();
        this.myModel = myModel;
    }

    public static class HitoryViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout linView;

        public HitoryViewHolder(LinearLayout v){
            super(v);
            linView = v;
        }
    }

    @NonNull
    @Override
    public HitoryAdapter.HitoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.hitory_view, parent, false);

        HitoryViewHolder vh = new HitoryViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(@NonNull HitoryViewHolder holder, int position){
        LinearLayout held = holder.linView;
        TextView tvResult = held.findViewById(R.id.tvResult);
        TextView tvBase = held.findViewById(R.id.tvBase);

        tvResult.setText("Result: " + myModel.myHitory.get(position).value);
        tvBase.setText("Base: " + myModel.myHitory.get(position).base);
    }

    public int getItemCount(){return myModel.size();}
}
