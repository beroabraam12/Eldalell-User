package com.project.eldalell.user.Fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;


import com.project.eldalell.user.R;

import java.util.Calendar;


public class AccountInfoFragment extends Fragment {

  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  public AccountInfoFragment() {
    // Required empty public constructor
  }

  public static AccountInfoFragment newInstance(String param1, String param2) {
    AccountInfoFragment fragment = new AccountInfoFragment();
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

  TextView tvTitle;
  private TextView tvDateOfBirth;
  private DatePickerDialog.OnDateSetListener dateDialog;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_account_info, container, false);
    tvTitle = getActivity().findViewById(R.id.tvTitleMain);
    tvDateOfBirth = v.findViewById(R.id.tvDateOfBirth);

    tvDateOfBirth.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getContext(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                dateDialog, year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
      }
    });
    dateDialog = new DatePickerDialog.OnDateSetListener() {
      @SuppressLint("SetTextI18n")
      @Override
      public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month = month + 1;
        tvDateOfBirth.setText(dayOfMonth + "/" + month + "/" + year);
      }
    };
    tvTitle.setText("Account Info");

    //TODO Get The Account Info from DataBase

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
