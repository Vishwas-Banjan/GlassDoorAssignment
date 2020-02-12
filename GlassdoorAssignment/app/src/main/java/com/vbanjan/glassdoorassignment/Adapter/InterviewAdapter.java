package com.vbanjan.glassdoorassignment.Adapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.vbanjan.glassdoorassignment.Model.Interview;
import com.vbanjan.glassdoorassignment.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InterviewAdapter extends RecyclerView.Adapter<InterviewAdapter.ViewHolder> {
    private NavController navController;
    private ArrayList<Interview> interviews;

    public InterviewAdapter(ArrayList<Interview> interviews, NavController navController) {
        this.interviews = interviews;
        this.navController = navController;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.interview_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Interview interview = interviews.get(position);
        setImageView(holder.itemView, interview, holder.interviewImageView, holder.interviewProgressBar);
        setDateTime(interview.getReviewDateTime(), holder.interviewDateTimeTextView);
        holder.employerNameTextView.setText(interview.getEmployerName());
        holder.jobTitleTextView.setText(interview.getJobTitle());
        holder.sourceTextView.setText("Source: " + interview.getInterviewSource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("interviewDetail", interview);
                navController.navigate(R.id.interviewDetailFragment, bundle,
                        new NavOptions.Builder()
                                .setEnterAnim(R.anim.slide_in_right)
                                .setEnterAnim(R.anim.slide_out_left)
                                .setPopEnterAnim(R.anim.slide_in_left)
                                .setPopExitAnim(R.anim.slide_out_right)
                                .build());
            }
        });
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

    private void setImageView(View itemView, Interview interview, final ImageView interviewImageView, final ProgressBar interviewProgressBar) {
        final Resources res = itemView.getContext().getResources();
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


    @Override
    public int getItemCount() {
        return interviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView interviewImageView;
        TextView employerNameTextView, interviewDateTimeTextView, jobTitleTextView, sourceTextView;
        ProgressBar interviewProgressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            interviewImageView = itemView.findViewById(R.id.imageView);
            employerNameTextView = itemView.findViewById(R.id.employerNameTextView);
            interviewDateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
            jobTitleTextView = itemView.findViewById(R.id.jobTitleTextView);
            interviewProgressBar = itemView.findViewById(R.id.progressBar);
            sourceTextView = itemView.findViewById(R.id.headlineTextView);

        }
    }
}
