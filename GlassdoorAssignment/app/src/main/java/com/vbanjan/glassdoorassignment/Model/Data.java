package com.vbanjan.glassdoorassignment.Model;

import java.util.ArrayList;

public class Data {
    private ArrayList<Review> reviews = new ArrayList<>();
    private ArrayList<Interview> interviews = new ArrayList<>();
    private ArrayList<Salary> salaries = new ArrayList<>();

    public Data() {
    }

    @Override
    public String toString() {
        return "Data{" +
                "reviews=" + reviews +
                ", interviews=" + interviews +
                ", salaries=" + salaries +
                '}';
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(ArrayList<Interview> interviews) {
        this.interviews = interviews;
    }

    public ArrayList<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(ArrayList<Salary> salaries) {
        this.salaries = salaries;
    }
}
