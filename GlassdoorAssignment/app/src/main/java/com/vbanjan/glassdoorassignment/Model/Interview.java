package com.vbanjan.glassdoorassignment.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Interview implements Serializable {
    private String approvalStatus, attributionURL, employerId, employerName, id, interviewDate, interviewSource, interviewSteps,
            jobTitle, location, negotiationDetails, otherSteps, outcome, processAnswer, processDifficulty, processInterviewExperience,
            processOverallExperience, reasonForDeclining, reviewDateTime, sqLogoUrl;
    private String featuredReview, newReview;
    private int helpfulCount, notHelpfulCount, processLength, testSteps, totalHelpfulCount;
    private ArrayList<Question> questions;

    public Interview() {
    }

    @Override
    public String toString() {
        return "Interview{" +
                "approvalStatus='" + approvalStatus + '\'' +
                ", attributionURL='" + attributionURL + '\'' +
                ", employerId='" + employerId + '\'' +
                ", employerName='" + employerName + '\'' +
                ", id='" + id + '\'' +
                ", interviewDate='" + interviewDate + '\'' +
                ", interviewSource='" + interviewSource + '\'' +
                ", interviewSource='" + interviewSource + '\'' +
                ", interviewSteps='" + interviewSteps + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", location='" + location + '\'' +
                ", negotiationDetails='" + negotiationDetails + '\'' +
                ", otherSteps='" + otherSteps + '\'' +
                ", outcome='" + outcome + '\'' +
                ", processAnswer='" + processAnswer + '\'' +
                ", processDifficulty='" + processDifficulty + '\'' +
                ", processInterviewExperience='" + processInterviewExperience + '\'' +
                ", processOverallExperience='" + processOverallExperience + '\'' +
                ", reasonForDeclining='" + reasonForDeclining + '\'' +
                ", reviewDateTime='" + reviewDateTime + '\'' +
                ", sqLogoUrl='" + sqLogoUrl + '\'' +
                ", featuredReview='" + featuredReview + '\'' +
                ", newReview='" + newReview + '\'' +
                ", helpfulCount=" + helpfulCount +
                ", notHelpfulCount=" + notHelpfulCount +
                ", processLength=" + processLength +
                ", testSteps=" + testSteps +
                ", totalHelpfulCount=" + totalHelpfulCount +
                ", questions=" + questions +
                '}';
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getAttributionURL() {
        return attributionURL;
    }

    public void setAttributionURL(String attributionURL) {
        this.attributionURL = attributionURL;
    }

    public String getEmployerId() {
        return employerId;
    }

    public void setEmployerId(String employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewSource() {
        return interviewSource;
    }

    public void setInterviewSource(String interviewSource) {
        this.interviewSource = interviewSource;
    }

    public String getInterviewSteps() {
        return interviewSteps;
    }

    public void setInterviewSteps(String interviewSteps) {
        this.interviewSteps = interviewSteps;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNegotiationDetails() {
        return negotiationDetails;
    }

    public void setNegotiationDetails(String negotiationDetails) {
        this.negotiationDetails = negotiationDetails;
    }

    public String getOtherSteps() {
        return otherSteps;
    }

    public void setOtherSteps(String otherSteps) {
        this.otherSteps = otherSteps;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getProcessAnswer() {
        return processAnswer;
    }

    public void setProcessAnswer(String processAnswer) {
        this.processAnswer = processAnswer;
    }

    public String getProcessDifficulty() {
        return processDifficulty;
    }

    public void setProcessDifficulty(String processDifficulty) {
        this.processDifficulty = processDifficulty;
    }

    public String getProcessInterviewExperience() {
        return processInterviewExperience;
    }

    public void setProcessInterviewExperience(String processInterviewExperience) {
        this.processInterviewExperience = processInterviewExperience;
    }

    public String getProcessOverallExperience() {
        return processOverallExperience;
    }

    public void setProcessOverallExperience(String processOverallExperience) {
        this.processOverallExperience = processOverallExperience;
    }

    public String getReasonForDeclining() {
        return reasonForDeclining;
    }

    public void setReasonForDeclining(String reasonForDeclining) {
        this.reasonForDeclining = reasonForDeclining;
    }

    public String getReviewDateTime() {
        return reviewDateTime;
    }

    public void setReviewDateTime(String reviewDateTime) {
        this.reviewDateTime = reviewDateTime;
    }

    public String getSqLogoUrl() {
        return sqLogoUrl;
    }

    public void setSqLogoUrl(String sqLogoUrl) {
        this.sqLogoUrl = sqLogoUrl;
    }

    public String getFeaturedReview() {
        return featuredReview;
    }

    public void setFeaturedReview(String featuredReview) {
        this.featuredReview = featuredReview;
    }

    public String getNewReview() {
        return newReview;
    }

    public void setNewReview(String newReview) {
        this.newReview = newReview;
    }

    public int getHelpfulCount() {
        return helpfulCount;
    }

    public void setHelpfulCount(int helpfulCount) {
        this.helpfulCount = helpfulCount;
    }

    public int getNotHelpfulCount() {
        return notHelpfulCount;
    }

    public void setNotHelpfulCount(int notHelpfulCount) {
        this.notHelpfulCount = notHelpfulCount;
    }

    public int getProcessLength() {
        return processLength;
    }

    public void setProcessLength(int processLength) {
        this.processLength = processLength;
    }

    public int getTestSteps() {
        return testSteps;
    }

    public void setTestSteps(int testSteps) {
        this.testSteps = testSteps;
    }

    public int getTotalHelpfulCount() {
        return totalHelpfulCount;
    }

    public void setTotalHelpfulCount(int totalHelpfulCount) {
        this.totalHelpfulCount = totalHelpfulCount;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public class Question implements Serializable {
        String attributionURL, date, employer, id, jobTitle, locationCity, locationCountry, locationState, question, squareLogo;
        int helpfulCount, totalHelpfulCount;
        ArrayList<Response> responses;

        public Question() {
        }

        @Override
        public String toString() {
            return "Question{" +
                    "attributionURL='" + attributionURL + '\'' +
                    ", date='" + date + '\'' +
                    ", employer='" + employer + '\'' +
                    ", id='" + id + '\'' +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", locationCity='" + locationCity + '\'' +
                    ", locationCountry='" + locationCountry + '\'' +
                    ", locationState='" + locationState + '\'' +
                    ", question='" + question + '\'' +
                    ", squareLogo='" + squareLogo + '\'' +
                    ", helpfulCount=" + helpfulCount +
                    ", totalHelpfulCount=" + totalHelpfulCount +
                    ", responses=" + responses +
                    '}';
        }

        public String getAttributionURL() {
            return attributionURL;
        }

        public void setAttributionURL(String attributionURL) {
            this.attributionURL = attributionURL;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getEmployer() {
            return employer;
        }

        public void setEmployer(String employer) {
            this.employer = employer;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getLocationCity() {
            return locationCity;
        }

        public void setLocationCity(String locationCity) {
            this.locationCity = locationCity;
        }

        public String getLocationCountry() {
            return locationCountry;
        }

        public void setLocationCountry(String locationCountry) {
            this.locationCountry = locationCountry;
        }

        public String getLocationState() {
            return locationState;
        }

        public void setLocationState(String locationState) {
            this.locationState = locationState;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getSquareLogo() {
            return squareLogo;
        }

        public void setSquareLogo(String squareLogo) {
            this.squareLogo = squareLogo;
        }

        public int getHelpfulCount() {
            return helpfulCount;
        }

        public void setHelpfulCount(int helpfulCount) {
            this.helpfulCount = helpfulCount;
        }

        public int getTotalHelpfulCount() {
            return totalHelpfulCount;
        }

        public void setTotalHelpfulCount(int totalHelpfulCount) {
            this.totalHelpfulCount = totalHelpfulCount;
        }

        public ArrayList<Response> getResponses() {
            return responses;
        }

        public void setResponses(ArrayList<Response> responses) {
            this.responses = responses;
        }
    }

    public class Response implements Serializable {
        String approvalStatus, createdDate, id, responseText, userHandle;
        String empRep;
        int helpfulCount, notHelpfulCount;

        public Response() {
        }

        @Override
        public String toString() {
            return "Response{" +
                    "approvalStatus='" + approvalStatus + '\'' +
                    ", createdDate='" + createdDate + '\'' +
                    ", id='" + id + '\'' +
                    ", responseText='" + responseText + '\'' +
                    ", userHandle='" + userHandle + '\'' +
                    ", empRep='" + empRep + '\'' +
                    ", helpfulCount=" + helpfulCount +
                    ", notHelpfulCount=" + notHelpfulCount +
                    '}';
        }

        public String getApprovalStatus() {
            return approvalStatus;
        }

        public void setApprovalStatus(String approvalStatus) {
            this.approvalStatus = approvalStatus;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getResponseText() {
            return responseText;
        }

        public void setResponseText(String responseText) {
            this.responseText = responseText;
        }

        public String getUserHandle() {
            return userHandle;
        }

        public void setUserHandle(String userHandle) {
            this.userHandle = userHandle;
        }

        public String getEmpRep() {
            return empRep;
        }

        public void setEmpRep(String empRep) {
            this.empRep = empRep;
        }

        public int getHelpfulCount() {
            return helpfulCount;
        }

        public void setHelpfulCount(int helpfulCount) {
            this.helpfulCount = helpfulCount;
        }

        public int getNotHelpfulCount() {
            return notHelpfulCount;
        }

        public void setNotHelpfulCount(int notHelpfulCount) {
            this.notHelpfulCount = notHelpfulCount;
        }
    }
}
