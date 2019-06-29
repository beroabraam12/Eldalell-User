package com.project.eldalell.user.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
        curruntHistory.setOrderName(HistoryList.get(i).getOrderName());
        curruntHistory.setOrderDate(HistoryList.get(i).getOrderDate());
        curruntHistory.setOrderID(HistoryList.get(i).getOrderID());
        curruntHistory.setOrderStatus(HistoryList.get(i).isOrderStatus());

        historyViewHolder.tvName.setText(curruntHistory.getOrderName());
        historyViewHolder.tvDate.setText(curruntHistory.getOrderDate());
        historyViewHolder.tvID.setText(curruntHistory.getOrderID());
        if (HistoryList.get(i).isOrderStatus()) {
            historyViewHolder.tvStatue.setText("Successful");
            historyViewHolder.tvStatue.setTextColor(Color.GREEN);
        } else {
            historyViewHolder.tvStatue.setText("Failed");
            historyViewHolder.tvStatue.setTextColor(Color.RED);
        }


    }


    @Override
    public int getItemCount() {
        return HistoryList.size();
    }

    class HistoryViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDate, tvID, tvStatue;

        public HistoryViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvOrder);
            tvDate = (TextView) itemView.findViewById(R.id.tvOrderDateAndTime);
            tvID = (TextView) itemView.findViewById(R.id.tvOrderID);
            tvStatue = (TextView) itemView.findViewById(R.id.tvOrderStatus);

        }
    }
}
