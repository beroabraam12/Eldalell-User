package com.project.eldalell.user.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.project.eldalell.user.Classes.Upcoming;
import com.project.eldalell.user.R;

import java.util.ArrayList;


public class UpcomingAdapter extends RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder> {
    private ArrayList<Upcoming> upcomings;
    private Activity activity;

    public UpcomingAdapter(ArrayList<Upcoming> upcomings, Activity activity) {
        this.upcomings = upcomings;
        this.activity = activity;
    }

    @NonNull
    @Override
    public UpcomingAdapter.UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View historyrow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upcoming_row
                , viewGroup, false);

        UpcomingAdapter.UpcomingViewHolder holder = new UpcomingAdapter.UpcomingViewHolder(historyrow);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingAdapter.UpcomingViewHolder upcomingViewHolder, int i) {

        Upcoming upcoming = new Upcoming();
        upcoming.setShopName(upcomings.get(i).getShopName());
        upcoming.setOrderDate(upcomings.get(i).getOrderDate());
        upcoming.setOrderID(upcomings.get(i).getOrderID());
        upcoming.setOrderStatus(upcomings.get(i).isOrderStatus());

        upcomingViewHolder.tvName.setText(upcoming.getShopName());
        upcomingViewHolder.tvDate.setText(upcoming.getOrderDate());
        upcomingViewHolder.tvID.setText(upcoming.getOrderID());
        if (upcoming.isOrderStatus()) {
            upcomingViewHolder.tvStatue.setText("Delivery Take Order");
            upcomingViewHolder.tvStatue.setTextColor(Color.GREEN);
        } else {
            upcomingViewHolder.tvStatue.setText("order Submitted");
            upcomingViewHolder.tvStatue.setTextColor(Color.RED);
        }
        Glide.with(activity)
                .load(upcoming.getImage())
                .centerCrop()
                .placeholder(R.drawable.carfor)
                .into(upcomingViewHolder.imgUpcoming);

        upcomingViewHolder.upcomingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.traceOrderFragment);
            }
        });


    }


    @Override
    public int getItemCount() {
        return upcomings.size();
    }

    class UpcomingViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvDate, tvID, tvStatue;
        CardView upcomingCard;
        ImageView imgUpcoming;

        public UpcomingViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvOrderUp);
            tvDate = itemView.findViewById(R.id.tvOrderDateAndTimeUp);
            tvID = itemView.findViewById(R.id.tvOrderIDUp);
            tvStatue = itemView.findViewById(R.id.tvOrderStatusUp);
            upcomingCard = itemView.findViewById(R.id.upcomingCard);
            imgUpcoming = itemView.findViewById(R.id.imgUpcoming);

        }
    }
}