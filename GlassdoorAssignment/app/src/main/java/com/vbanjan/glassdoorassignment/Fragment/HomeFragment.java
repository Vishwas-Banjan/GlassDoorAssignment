package com.vbanjan.glassdoorassignment.Fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.vbanjan.glassdoorassignment.Adapter.SectionPagerAdapter;
import com.vbanjan.glassdoorassignment.Model.Data;
import com.vbanjan.glassdoorassignment.Model.Interview;
import com.vbanjan.glassdoorassignment.Model.Review;
import com.vbanjan.glassdoorassignment.Model.Salary;
import com.vbanjan.glassdoorassignment.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class HomeFragment extends Fragment {

    private static final String TAG = "demo";
    ProgressBar progressBar;
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;
    private OnFragmentInteractionListener mListener;
    NavController navController;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        new fetchData().execute();
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
    }

    private void setUpTabs() {
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ReviewFragment(dataList.getReviews()), "Reviews (" + dataList.getReviews().size() + ")");
        adapter.addFragment(new InterviewFragment(dataList.getInterviews()), "Interviews (" + dataList.getInterviews().size() + ")");
        adapter.addFragment(new SalaryFragment(dataList.getSalaries()), "Salary (" + dataList.getSalaries().size() + ")");
        viewPager.setAdapter(adapter);
        progressBar.setVisibility(View.INVISIBLE);
    }

    Data dataList = new Data();

    public class fetchData extends AsyncTask<Void, Void, Data> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Data data) {
            super.onPostExecute(data);
            progressBar.setVisibility(View.INVISIBLE);
            if (data != null) {
                dataList = data;
                setUpTabs();
            } else {
                Toast.makeText(getContext(), "Oops! Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected Data doInBackground(Void... voids) {
            Data data = new Data();
            ArrayList<Review> reviews = new ArrayList<>();
            ArrayList<Interview> interviews = new ArrayList<>();
            ArrayList<Salary> salaries = new ArrayList<>();

            final OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(getResources().getString(R.string.getData))
                    .build();
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);

                    String json = responseBody.string();
                    JSONObject root = new JSONObject(json);
                    JSONObject responseJSON = new JSONObject(root.getString("response"));
                    JSONArray resultsJSON = new JSONArray(responseJSON.getString("results"));
                    for (int i = 0; i < resultsJSON.length(); i++) {
                        JSONObject resultObject = resultsJSON.getJSONObject(i);
                        Gson gson = new Gson();
                        if (!resultObject.optString("interview").equals("")) {
                            JSONObject interviewJSON = new JSONObject(resultObject.getString("interview"));
                            Interview interview = gson.fromJson(String.valueOf(interviewJSON), Interview.class);
                            interviews.add(interview);
                        }
                        if (!resultObject.optString("review").equals("")) {
                            JSONObject reviewJSON = new JSONObject(resultObject.getString("review"));
                            Review review = gson.fromJson(String.valueOf(reviewJSON), Review.class);
                            reviews.add(review);
                        }
                        if (!resultObject.optString("salary").equals("")) {
                            JSONObject salaryJSON = new JSONObject(resultObject.getString("salary"));
                            Salary salary = gson.fromJson(String.valueOf(salaryJSON), Salary.class);
                            salaries.add(salary);
                        }
                        data.setInterviews(interviews);
                        data.setReviews(reviews);
                        data.setSalaries(salaries);
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
    }

}

