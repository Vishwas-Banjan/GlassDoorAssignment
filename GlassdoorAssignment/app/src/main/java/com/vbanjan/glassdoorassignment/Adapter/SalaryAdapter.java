package com.vbanjan.glassdoorassignment.Adapter;

import android.annotation.SuppressLint;
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
import com.vbanjan.glassdoorassignment.Model.Salary;
import com.vbanjan.glassdoorassignment.R;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SalaryAdapter extends RecyclerView.Adapter<SalaryAdapter.ViewHolder> {
    private ArrayList<Salary> salaries;
    private NavController navController;

    public SalaryAdapter(ArrayList<Salary> salaries, NavController navController) {
        this.salaries = salaries;
        this.navController = navController;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.salary_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Salary salary = salaries.get(position);
        setImageView(holder.itemView, salary, holder.salaryImageView, holder.salaryProgressBar);
        setDateTime(salary.getReviewDateTime(), holder.salaryDateTimeTextView);
        holder.employerNameTextView.setText(salary.getEmployerName());
        holder.jobTitleTextView.setText(salary.getJobTitle());
        holder.locationTextView.setText(salary.getLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("salaryDetail", salary);
                navController.navigate(R.id.salaryDetailFragment, bundle,
                        new NavOptions.Builder()
                                .setEnterAnim(R.anim.slide_in_right)
                                .setEnterAnim(R.anim.slide_out_left)
                                .setPopEnterAnim(R.anim.slide_in_left)
                                .setPopExitAnim(R.anim.slide_out_right)
                                .build());
            }
        });
    }

    @SuppressLint("SimpleDateFormat")
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

    private void setImageView(View itemView, Salary salary, final ImageView salaryImageView, final ProgressBar salaryProgressBar) {
        final Resources res = itemView.getContext().getResources();

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
                    salaryImageView.setImageDrawable(res.getDrawable(R.drawable.no_image_found));
                }
            });
        } else {
            salaryProgressBar.setVisibility(View.INVISIBLE);
            salaryImageView.setImageDrawable(res.getDrawable(R.drawable.no_image_found));
        }
    }

    @Override
    public int getItemCount() {
        return salaries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView salaryImageView;
        TextView employerNameTextView, salaryDateTimeTextView, jobTitleTextView, locationTextView;
        ProgressBar salaryProgressBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            salaryImageView = itemView.findViewById(R.id.imageView);
            employerNameTextView = itemView.findViewById(R.id.employerNameTextView);
            salaryDateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
            jobTitleTextView = itemView.findViewById(R.id.jobTitleTextView);
            locationTextView = itemView.findViewById(R.id.headlineTextView);
            salaryProgressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
