package com.project.eldalell.user.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import androidx.navigation.Navigation;

import com.project.eldalell.user.Adapter.HistoryAdapter;
import com.project.eldalell.user.Classes.History;
import com.project.eldalell.user.R;


public class OrderHistoryFragment extends Fragment {

  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  public OrderHistoryFragment() {
  }

  public static OrderHistoryFragment newInstance(String param1, String param2) {
    OrderHistoryFragment fragment = new OrderHistoryFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  RecyclerView rvOrders;
  ArrayList<History> ordersList;
  TextView tvTitle, tvUpcoming;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_order_history, container, false);
    rvOrders = v.findViewById(R.id.rvOrders);
    tvTitle = getActivity().findViewById(R.id.tvTitleMain);
    tvUpcoming = v.findViewById(R.id.tvUpcoming);

    tvUpcoming.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(v).popBackStack(R.id.orderHistoryFragment, true);
        Navigation.findNavController(v).navigate(R.id.upcomingFragment);
      }
    });

    tvTitle.setText("Orders");
    ordersList = new ArrayList<>();


    //TODO Get Order History Form DataBase

    ordersList.add(new History("Carrefour_Maadi", true,
            "#12365", "25/4/2019  5:10am"));
    ordersList.add(new History("Carrefour_Maadi", false,
            "#89654", "25/4/2019  5:10am"));
    ordersList.add(new History("Carrefour_Maadi", false,
            "#56892", "25/4/2019  5:10am"));
    ordersList.add(new History("Carrefour_Maadi", true,
            "#21198", "25/4/2019  5:10am"));


    rvOrders.setLayoutManager(new LinearLayoutManager(getContext()));
    HistoryAdapter adapter = new HistoryAdapter(ordersList, getActivity());
    rvOrders.setAdapter(adapter);

    return v;
  }

  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  public interface OnFragmentInteractionListener {
    void onFragmentInteraction(Uri uri);
  }
}
