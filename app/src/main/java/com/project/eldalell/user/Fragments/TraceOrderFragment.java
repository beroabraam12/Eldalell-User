package com.project.eldalell.user.Fragments;

import android.content.Context;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.project.eldalell.user.Activity.MainActivity;
import com.project.eldalell.user.Adapter.OrderReviewAdapter;
import com.project.eldalell.user.Classes.Order;
import com.project.eldalell.user.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class TraceOrderFragment extends Fragment {

  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  public TraceOrderFragment() {
  }


  public static TraceOrderFragment newInstance(String param1, String param2) {
    TraceOrderFragment fragment = new TraceOrderFragment();
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

  CircleImageView imgStep1, imgStep2, imgStep3;
  TextView tvStep1, tvStep2, tvStep3, tvTitle, tvSelectedAddress;
  ImageView imgBackBar, search;
  RecyclerView rvOrderPreview;
  Toolbar mainToolBar;
  public static ArrayList<Order> orders;
  public static TextView tvSubTotalTrace, tvTotalReviewPriceTrace;
  public NavController navController;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_trace_order, container, false);

    rvOrderPreview = v.findViewById(R.id.rvOrderPreview);
    tvSubTotalTrace = v.findViewById(R.id.tvSubTotalTrace);
    tvSelectedAddress = getActivity().findViewById(R.id.tvSelectedAddress);
    tvTotalReviewPriceTrace = v.findViewById(R.id.tvTotalReviewPriceTrace);
    imgStep1 = v.findViewById(R.id.imgStep1);
    imgStep2 = v.findViewById(R.id.imgStep2);
    imgStep3 = v.findViewById(R.id.imgStep3);
    tvStep1 = v.findViewById(R.id.tvStep1);
    tvStep2 = v.findViewById(R.id.tvStep2);
    tvStep3 = v.findViewById(R.id.tvStep3);
    navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
    tvTitle = getActivity().findViewById(R.id.tvTitleMain);
    imgBackBar = getActivity().findViewById(R.id.imgBackBar);
    search = getActivity().findViewById(R.id.search);
    mainToolBar = getActivity().findViewById(R.id.mainToolBar);

    tvSelectedAddress.setVisibility(View.GONE);
    tvTitle.setText("Order Progress");
    tvTitle.setVisibility(View.VISIBLE);
    imgBackBar.setVisibility(View.VISIBLE);
    search.setVisibility(View.GONE);
    mainToolBar.setVisibility(View.VISIBLE);

    MainActivity.setDrawerState(false);

    imgBackBar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        navController.popBackStack(R.id.traceOrderFragment, true);
        navController.navigate(R.id.upcomingFragment);
        imgBackBar.setVisibility(View.GONE);
        MainActivity.setDrawerState(true);
        UpcomingFragment.fromUpcoming = true;
      }
    });

    Drawable background = getContext().getResources().getDrawable(R.drawable.btn_filter_shape);
    imgStep1.setBackground(background);

    if (orders == null) {
      orders = new ArrayList<>();
    }

    rvOrderPreview.setLayoutManager(new LinearLayoutManager(getActivity()));
    OrderReviewAdapter adapter = new OrderReviewAdapter(getActivity(), orders, false);
    rvOrderPreview.setAdapter(adapter);


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
