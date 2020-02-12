package com.vbanjan.glassdoorassignment.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.vbanjan.glassdoorassignment.Model.Salary;
import com.vbanjan.glassdoorassignment.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SalaryDetailFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Salary salary;
    private TextView titleTextView, employmentStatusTextView, payPeriodTextView, baseCurrencyCodeTextView, basePaySymbolTextView, baseAmtTextView,
            meanAmtTextView, meanCurrencyCodeTextView, meanPaySymbolTextView;
    private ImageView salaryImageView;
    private TextView employerNameTextView, salaryDateTimeTextView, jobTitleTextView, locationTextView;
    private ProgressBar salaryProgressBar;
    private MaterialButton viewMoreBtn;

    public SalaryDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_salary_detail, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if (getArguments().getSerializable("salaryDetail") != null) {
                salary = (Salary) getArguments().getSerializable("salaryDetail");
            } else {
                Log.d("demo", "onCreate: ERROR");
                Toast.makeText(getContext(), "Oops! Something went wrong", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
            }
        } else {
            Toast.makeText(getContext(), "Oops! Something went wrong", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapLayoutObjects(view);
        updateLayoutValues();

        viewMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.openInCustomTab(salary.getAttributionURL());
            }
        });
    }


    private void updateLayoutValues() {
        setImageView(salary, salaryImageView, salaryProgressBar);
        setDateTime(salary.getReviewDateTime(), salaryDateTimeTextView);
        employerNameTextView.setText(salary.getEmployerName());
        jobTitleTextView.setText(salary.getJobTitle());
        locationTextView.setText(salary.getLocation());
        titleTextView.setText(salary.getEmployerName() + " Salaries");
        employmentStatusTextView.setText(salary.getEmploymentStatus());
        payPeriodTextView.setText(salary.getPayPeriod());

        baseCurrencyCodeTextView.setText(salary.getBasePay().getCurrencyCode());
        basePaySymbolTextView.setText(salary.getBasePay().getSymbol());
        baseAmtTextView.setText(salary.getBasePay().getAmount().toString());

        meanAmtTextView.setText(salary.getMeanBasePay().getAmount().toString());
        meanCurrencyCodeTextView.setText(salary.getMeanBasePay().getCurrencyCode());
        meanPaySymbolTextView.setText(salary.getMeanBasePay().getSymbol());

    }

    private void setDateTime(String reviewDateTime, TextView salaryDateTimeTextView) {
        Date out = null;// Set date
        try {
//            2017-04-09 23:17:33.997
            out = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(reviewDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PrettyTime prettyTime = new PrettyTime();
        salaryDateTimeTextView.setText(prettyTime.format(out));
    }

    private void setImageView(Salary salary, final ImageView salaryImageView, final ProgressBar salaryProgressBar) {
        if (!salary.getSqLogoUrl().equals("null")) { //Set image
            Picasso.get().load(salary.getSqLogoUrl()).into(salaryImageView, new Callback() {
                @Override
                public void onSuccess() {
                    salaryProgressBar.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError(Exception e) {
                    //Set default Image
                    salaryProgressBar.setVisibility(View.INVISIBLE);
                    Log.d("demo", "Picasso onError: Error! " + e.toString());
                    salaryImageView.setImageDrawable(getResources().getDrawable(R.drawable.no_image_found));
                }
            });
        } else {
            salaryProgressBar.setVisibility(View.INVISIBLE);
            salaryImageView.setImageDrawable(getResources().getDrawable(R.drawable.no_image_found));
        }
    }

    private void mapLayoutObjects(View view) {
        viewMoreBtn = view.findViewById(R.id.viewMoreBtn);
        salaryImageView = view.findViewById(R.id.imageView);
        employerNameTextView = view.findViewById(R.id.employerNameTextView);
        salaryDateTimeTextView = view.findViewById(R.id.dateTimeTextView);
        jobTitleTextView = view.findViewById(R.id.jobTitleTextView);
        locationTextView = view.findViewById(R.id.headlineTextView);
        salaryProgressBar = view.findViewById(R.id.progressBar);
        titleTextView = view.findViewById(R.id.titleTextView);
        employmentStatusTextView = view.findViewById(R.id.employmentStatusTextView);
        payPeriodTextView = view.findViewById(R.id.payPeriodTextView);

        baseCurrencyCodeTextView = view.findViewById(R.id.baseCurrencyCodeTextView);
        basePaySymbolTextView = view.findViewById(R.id.basePaySymbolTextView);
        baseAmtTextView = view.findViewById(R.id.baseAmtTextView);

        meanAmtTextView = view.findViewById(R.id.meanAmtTextView);
        meanCurrencyCodeTextView = view.findViewById(R.id.meanCurrencyCodeTextView);
        meanPaySymbolTextView = view.findViewById(R.id.meanPaySymbolTextView);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void openInCustomTab(String attributionURL);
    }
}
