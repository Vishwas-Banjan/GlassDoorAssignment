package com.vbanjan.glassdoorassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import android.net.Uri;
import android.os.Bundle;

import com.vbanjan.glassdoorassignment.Fragment.InterviewDetailFragment;
import com.vbanjan.glassdoorassignment.Fragment.InterviewFragment;
import com.vbanjan.glassdoorassignment.Fragment.ReviewDetailFragment;
import com.vbanjan.glassdoorassignment.Fragment.ReviewFragment;
import com.vbanjan.glassdoorassignment.Fragment.SalaryDetailFragment;
import com.vbanjan.glassdoorassignment.Fragment.SalaryFragment;
import com.vbanjan.glassdoorassignment.Fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener, ReviewFragment.OnFragmentInteractionListener,
        InterviewFragment.OnFragmentInteractionListener, SalaryFragment.OnFragmentInteractionListener,
        ReviewDetailFragment.OnFragmentInteractionListener, InterviewDetailFragment.OnFragmentInteractionListener,
        SalaryDetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.glassdoor_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void openInCustomTab(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
    }
}
