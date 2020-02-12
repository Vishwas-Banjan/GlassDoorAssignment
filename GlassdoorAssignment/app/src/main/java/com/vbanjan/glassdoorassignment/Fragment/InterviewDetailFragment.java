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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.vbanjan.glassdoorassignment.Model.Interview;
import com.vbanjan.glassdoorassignment.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterviewDetailFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ImageView interviewImageView;
    private TextView employerNameTextView, interviewDateTimeTextView, jobTitleTextView, sourceTextView, outcomeTextView,
            processDifficultyTextView, processOverallExperienceTextView, processAnswerTextView, titleTextView;
    private ProgressBar interviewProgressBar;
    private LinearLayout questionsRootView;
    private MaterialButton viewMoreBtn;
    private Interview interview;

    public InterviewDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            if (getArguments().getSerializable("interviewDetail") != null) {
                interview = (Interview) getArguments().getSerializable("interviewDetail");
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
        return inflater.inflate(R.layout.fragment_interview_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapLayoutObjects(view);
        updateLayoutValue();

        viewMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.openInCustomTab(interview.getAttributionURL());
            }
        });
    }


    private void mapLayoutObjects(View view) {
        viewMoreBtn = view.findViewById(R.id.viewMoreBtn);
        titleTextView = view.findViewById(R.id.titleTextView);
        interviewImageView = view.findViewById(R.id.imageView);
        employerNameTextView = view.findViewById(R.id.employerNameTextView);
        interviewDateTimeTextView = view.findViewById(R.id.dateTimeTextView);
        jobTitleTextView = view.findViewById(R.id.jobTitleTextView);
        interviewProgressBar = view.findViewById(R.id.progressBar);
        sourceTextView = view.findViewById(R.id.headlineTextView);
        outcomeTextView = view.findViewById(R.id.outcomeTextView);
        processDifficultyTextView = view.findViewById(R.id.processDifficultyTextView);
        processOverallExperienceTextView = view.findViewById(R.id.processOverallExperienceTextView);
        processAnswerTextView = view.findViewById(R.id.processAnswerTextView);
        questionsRootView = view.findViewById(R.id.questionsRootView);
    }

    public void addQuestions(int index, Interview.Question question) {
        View view = questionsRootView.getChildAt(index);
        if (view == null) {
            view = LayoutInflater.from(questionsRootView.getContext())
                    .inflate(R.layout.interview_question, questionsRootView, false);
            questionsRootView.addView(view);
        }
        TextView questionTextView = view.findViewById(R.id.questionTextView);
        questionTextView.setText(question.getQuestion());

        LinearLayout responseRootView = view.findViewById(R.id.responseRootView);
        for (int i = 0; i < question.getResponses().size(); i++) {
            Interview.Response response = question.getResponses().get(i);
            addResponse(responseRootView, i, response);
        }
    }

    public void addResponse(LinearLayout responseRootView, int index, Interview.Response response) {
        View view = responseRootView.getChildAt(index);
        if (view == null) {
            view = LayoutInflater.from(responseRootView.getContext())
                    .inflate(R.layout.interview_response, responseRootView, false);
            responseRootView.addView(view);
        }
        TextView responseTextView = view.findViewById(R.id.responseTextView);
        TextView userHandleTextView = view.findViewById(R.id.userHandleTextView);
        TextView responseDateTimeTxtView = view.findViewById(R.id.responseDateTimeTxtView);
        responseTextView.setText(response.getResponseText());
        userHandleTextView.setText(response.getUserHandle());
        setDateTime(response.getCreatedDate(), responseDateTimeTxtView);
    }

    private void updateLayoutValue() {
        titleTextView.setText(interview.getEmployerName() + " Interviews");
        outcomeTextView.setText(interview.getOutcome());
        processDifficultyTextView.setText(interview.getProcessDifficulty());
        processOverallExperienceTextView.setText(interview.getProcessOverallExperience());
        processAnswerTextView.setText(interview.getProcessAnswer());
        setImageView(interview, interviewImageView, interviewProgressBar);
        setDateTime(interview.getReviewDateTime(), interviewDateTimeTextView);
        employerNameTextView.setText(interview.getEmployerName());
        jobTitleTextView.setText(interview.getJobTitle());
        sourceTextView.setText("Source: " + interview.getInterviewSource());
        for (int i = 0; i < interview.getQuestions().size(); i++) {
            Interview.Question question = interview.getQuestions().get(i);
            addQuestions(i, question);
        }
    }

    private void setImageView(Interview interview, final ImageView interviewImageView, final ProgressBar interviewProgressBar) {
        final Resources res = getContext().getResources();

        if (!interview.getSqLogoUrl().equals("null")) { //Set image
            Picasso.get().load(interview.getSqLogoUrl()).into(interviewImageView, new Callback() {
                @Override
                public void onSuccess() {
                    interviewProgressBar.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onError(Exception e) {
                    //Set default Image
                    interviewProgressBar.setVisibility(View.INVISIBLE);
                    Log.d("demo", "Picasso onError: Error! " + e.toString());
                    interviewImageView.setImageDrawable(res.getDrawable(R.drawable.no_image_found));
                }
            });
        } else {
            interviewProgressBar.setVisibility(View.INVISIBLE);
            interviewImageView.setImageDrawable(res.getDrawable(R.drawable.no_image_found));
        }
    }


    public void setDateTime(String dateTime, TextView dateTimeTextView) {
        Date out = null;// Set date
        try {
//            2017-04-09 23:17:33.997
            out = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PrettyTime prettyTime = new PrettyTime();
        dateTimeTextView.setText(prettyTime.format(out));
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
        void openInCustomTab(String url);
    }
}
