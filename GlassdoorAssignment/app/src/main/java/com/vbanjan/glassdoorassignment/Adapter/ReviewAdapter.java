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
import com.vbanjan.glassdoorassignment.Model.Review;
import com.vbanjan.glassdoorassignment.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    private ArrayList<Review> reviews;
    private NavController navController;

    public ReviewAdapter(ArrayList<Review> reviews, NavController navController) {
        this.reviews = reviews;
        this.navController = navController;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Review review = reviews.get(position);
        holder.empNameTextView.setText(review.getEmployerName());
        String currentJob = "Former";
        if (review.getCurrentJob().equals("true")) {
            currentJob = "Current";
        }
        holder.jobTitleTextView.setText(currentJob + " - " + review.getJobTitle());
        holder.headlineTextView.setText("\"" + review.getHeadline() + "\"");
        setDateTime(review.getReviewDateTime(), holder.reviewDateTimeTextView);
        setImageView(holder.itemView, review, holder.reviewImageView, holder.reviewProgressBar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("reviewDetail", review);
                navController.navigate(R.id.reviewDetailFragment, bundle,
                        new NavOptions.Builder()
                                .setEnterAnim(R.anim.slide_in_right)
                                .setEnterAnim(R.anim.slide_out_left)
                                .setPopEnterAnim(R.anim.slide_in_left)
                                .setPopExitAnim(R.anim.slide_out_right)
                                .build());
            }
        });
    }


    private void setImageView(View itemView, Review review, final ImageView reviewImageView, final ProgressBar reviewProgressBar) {
        final Resources res = itemView.getContext().getResources();
        if (!review.getSqLogoUrl().equals("null")) { //Set image
            Picasso.get().load(review.getSqLogoUrl()).into(reviewImageView, new Callback() {
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
    public int getItemCount() {
        return reviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView jobTitleTextView, reviewDateTimeTextView, empNameTextView, headlineTextView;
        ImageView reviewImageView;
        ProgressBar reviewProgressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jobTitleTextView = itemView.findViewById(R.id.jobTitleTextView);
            reviewDateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
            empNameTextView = itemView.findViewById(R.id.employerNameTextView);
            reviewImageView = itemView.findViewById(R.id.imageView);
            reviewProgressBar = itemView.findViewById(R.id.progressBar);
            headlineTextView = itemView.findViewById(R.id.headlineTextView);
        }
    }
}
