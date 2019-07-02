package com.project.eldalell.user.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.project.eldalell.user.Classes.History;
import com.project.eldalell.user.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private ArrayList<History> HistoryList;
    private Activity activity;

    public HistoryAdapter(ArrayList<History> historyList, Activity activity) {
        HistoryList = historyList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View historyrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.historyrow
                , viewGroup, false);

        HistoryViewHolder holder = new HistoryViewHolder(historyrow);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder historyViewHolder, int i) {

        History curruntHistory = new History();
        curruntHistory.setShopName(HistoryList.get(i).getShopName());
        curruntHistory.setOrderDate(HistoryList.get(i).getOrderDate());
        curruntHistory.setOrderID(HistoryList.get(i).getOrderID());
        curruntHistory.setOrderStatus(HistoryList.get(i).isOrderStatus());
        curruntHistory.setImage(HistoryList.get(i).getImage());

        historyViewHolder.tvName.setText(curruntHistory.getShopName());
        historyViewHolder.tvDate.setText(curruntHistory.getOrderDate());
        historyViewHolder.tvID.setText(curruntHistory.getOrderID());
        historyViewHolder.tvStatue.setText("Successful");
        historyViewHolder.tvStatue.setTextColor(Color.GREEN);
        Glide.with(activity)
                .load(curruntHistory.getImage())
                .centerCrop()
                .placeholder(R.drawable.carfor)
                .into(historyViewHolder.imgLogo);
        historyViewHolder.History.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.traceOrderFragment);
            }
        });

    }


    @Override
    public int getItemCount() {
        return HistoryList.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDate, tvID, tvStatue;
        ImageView imgLogo;
        LinearLayout History;
        public HistoryViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvOrder);
            tvDate = itemView.findViewById(R.id.tvOrderDateAndTime);
            tvID = itemView.findViewById(R.id.tvOrderID);
            tvStatue = itemView.findViewById(R.id.tvOrderStatus);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            History = itemView.findViewById(R.id.History);

        }
    }
}
