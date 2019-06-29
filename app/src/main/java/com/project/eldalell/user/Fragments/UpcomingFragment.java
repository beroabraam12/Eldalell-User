package com.project.eldalell.user.Fragments;

import android.content.Context;
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

import java.util.ArrayList;

import androidx.navigation.Navigation;

import com.project.eldalell.user.Activity.MainActivity;
import com.project.eldalell.user.Adapter.UpcomingAdapter;
import com.project.eldalell.user.Classes.Upcoming;
import com.project.eldalell.user.R;


public class UpcomingFragment extends Fragment {
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";


  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  public UpcomingFragment() {
  }

  public static UpcomingFragment newInstance(String param1, String param2) {
    UpcomingFragment fragment = new UpcomingFragment();
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

  TextView tvTitle, tvHistory;
  RecyclerView rvUpcoming;
  ArrayList<Upcoming> upcomingList;
  Toolbar mainbar;
  ImageView imgBackBar;
  public static boolean fromUpcoming = false;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_upcoming, container, false);
    tvTitle = getActivity().findViewById(R.id.tvTitleMain);
    rvUpcoming = v.findViewById(R.id.rvOrdersUpcoming);
    tvHistory = v.findViewById(R.id.tvHistory);
    mainbar = getActivity().findViewById(R.id.mainToolBar);
    mainbar.setVisibility(View.VISIBLE);
    MainActivity.setDrawerState(true);
    imgBackBar = getActivity().findViewById(R.id.imgBackBar);
    imgBackBar.setVisibility(View.GONE);

    tvHistory.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Navigation.findNavController(v).popBackStack(R.id.upcomingFragment, true);
        Navigation.findNavController(v).navigate(R.id.orderHistoryFragment);
      }
    });

    upcomingList = new ArrayList<>();

    upcomingList.add(new Upcoming("Carrefour_Maadi", true,
            "#12365", "25/4/2019  5:10am"));
    upcomingList.add(new Upcoming("Carrefour_Maadi", false,
            "#89654", "25/4/2019  5:10am"));
    upcomingList.add(new Upcoming("Carrefour_Maadi", true,
            "#56892", "25/4/2019  5:10am"));


    rvUpcoming.setLayoutManager(new LinearLayoutManager(getContext()));
    UpcomingAdapter adapter = new UpcomingAdapter(upcomingList, getActivity());
    rvUpcoming.setAdapter(adapter);
    tvTitle.setText("Orders");

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
