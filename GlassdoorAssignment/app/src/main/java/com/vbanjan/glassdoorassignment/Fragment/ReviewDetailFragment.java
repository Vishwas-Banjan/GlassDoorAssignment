package com.vbanjan.glassdoorassignment.Fragment;

import android.content.Context;
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
import com.vbanjan.glassdoorassignment.Model.Review;
import com.vbanjan.glassdoorassignment.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReviewDetailFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Review review;
    private ImageView reviewImageView;
    private ProgressBar reviewProgressBar;
    private TextView employerNameTextView, reviewDateTimeTextView, jobTitleTextView, headlineTextView, careerOpportunitiesRatingTextView,
            ceoRatingTextView, compensationAndBenefitsRatingTextView, cultureAndValuesRatingTextView, seniorLeadershipRatingTextView,
            workLifeBalanceRatingTextView, overallNumericTextView, overallStringTextView, prosTextView, consTextView, adviceTextView,
            lengthOfEmploymentTextView, helpfulCount, notHelpfulCount, recommendTextView, titleTextView;
    private MaterialButton viewMoreBtn;

    public ReviewDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            if (getArguments().getSerializable("reviewDetail") != null) {
                review = (Review) getArguments().getSerializable("reviewDetail");
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapLayoutObjects(view);
        updateLayoutValue();

        viewMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.openInCustomTab(review.getAttributionURL());
            }
        });
    }


    private void mapLayoutObjects(View view) {
        viewMoreBtn = view.findViewById(R.id.viewMoreBtn);
        reviewImageView = view.findViewById(R.id.imageView);
        reviewProgressBar = view.findViewById(R.id.progressBar);
        employerNameTextView = view.findViewById(R.id.employerNameTextView);
        reviewDateTimeTextView = view.findViewById(R.id.dateTimeTextView);
        jobTitleTextView = view.findViewById(R.id.jobTitleTextView);
        headlineTextView = view.findViewById(R.id.headlineTextView);
        careerOpportunitiesRatingTextView = view.findViewById(R.id.careerOpportunitiesRatingTextView);
        ceoRatingTextView = view.findViewById(R.id.ceoRatingTextView);
        compensationAndBenefitsRatingTextView = view.findViewById(R.id.compensationAndBenefitsRatingTextView);
        cultureAndValuesRatingTextView = view.findViewById(R.id.cultureAndValuesRatingTextView);
        seniorLeadershipRatingTextView = view.findViewById(R.id.seniorLeadershipRatingTextView);
        workLifeBalanceRatingTextView = view.findViewById(R.id.workLifeBalanceRatingTextView);
        overallNumericTextView = view.findViewById(R.id.overallNumericTextView);
        overallStringTextView = view.findViewById(R.id.overallStringTextView);
        prosTextView = view.findViewById(R.id.prosTextView);
        consTextView = view.findViewById(R.id.consTextView);
        adviceTextView = view.findViewById(R.id.adviceTextView);
        lengthOfEmploymentTextView = view.findViewById(R.id.lengthOfEmploymentTextView);
        helpfulCount = view.findViewById(R.id.helpfulCountTextView);
        notHelpfulCount = view.findViewById(R.id.notHelpfulCountTextView);
        recommendTextView = view.findViewById(R.id.recommendTextView);
        titleTextView = view.findViewById(R.id.titleTextView);
    }

    public void updateLayoutValue() {
        titleTextView.setText(review.getEmployerName() + " Reviews");
        headlineTextView.setText((review.getHeadline() != null) ?
                review.getHeadline() : "N/A");
        careerOpportunitiesRatingTextView.setText(String.valueOf(review.getCareerOpportunitiesRating()));
        ceoRatingTextView.setText(String.valueOf(review.getCeoRating()));
        compensationAndBenefitsRatingTextView.setText(String.valueOf(review.getCompensationAndBenefitsRating()));
        cultureAndValuesRatingTextView.setText(String.valueOf(review.getCultureAndValuesRating()));
        seniorLeadershipRatingTextView.setText(String.valueOf(review.getSeniorLeadershipRating()));
        workLifeBalanceRatingTextView.setText(String.valueOf(review.getWorkLifeBalanceRating()));
        overallNumericTextView.setText((review.getOverallNumeric() != null) ?
                String.valueOf(review.getOverallNumeric()) : "N/A");
        overallStringTextView.setText((review.getOverall() != null) ?
                review.getOverall() : "N/A");
        prosTextView.setText((review.getPros() != null) ?
                review.getPros() : "N/A");
        consTextView.setText((review.getCons() != null) ?
                review.getCons() : "N/A");
        adviceTextView.setText((review.getAdvice() != null) ?
                review.getAdvice() : "N/A");
        lengthOfEmploymentTextView.setText((review.getLengthOfEmployment() != null) ?
                review.getLengthOfEmployment() : "N/A");
        helpfulCount.setText(String.valueOf(review.getHelpfulCount()));
        notHelpfulCount.setText(String.valueOf(review.getNotHelpfulCount()));
        employerNameTextView.setText(review.getEmployerName());
        recommendTextView.setText(review.getRecommendToFriend().equals("true") ? "YES" : "NO");
        String currentJob = "Former";
        if (review.getCurrentJob().equals("true")) {
            currentJob = "Current";
        }
        jobTitleTextView.setText(currentJob + " - " + review.getJobTitle());
        headlineTextView.setText("\"" + review.getHeadline() + "\"");
        setDateTime(review.getReviewDateTime(), reviewDateTimeTextView);
        setImage(review.getSqLogoUrl(), reviewImageView);
    }

    private void setImage(String sqLogoUrl, final ImageView reviewImageView) {
        final Resources res = getContext().getResources();
        if (!review.getSqLogoUrl().equals("null")) { //Set image
            Picasso.get().load(sqLogoUrl).into(reviewImageView, new Callback() {
                @Override
                public void onSuccess() {
                    reviewProgressBar.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError(Exception e) {
                    //Set default Image
                    reviewProgressBar.setVisibility(View.INVISIBLE);
                    Log.d("demo", "Picasso onError: Error! " + e.toString());
                    reviewImageView.setImageDrawable(res.getDrawable(R.drawable.no_image_found));
                }
            });
        } else {
            reviewProgressBar.setVisibility(View.INVISIBLE);
            reviewImageView.setImageDrawable(res.getDrawable(R.drawable.no_image_found));
        }
    }

    private void setDateTime(String reviewDateTime, TextView reviewDateTimeTextView) {
        Date out = null;// Set date
        try {
//            2017-04-09 23:17:33.997
            out = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(reviewDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PrettyTime prettyTime = new PrettyTime();
        reviewDateTimeTextView.setText(prettyTime.format(out));
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
