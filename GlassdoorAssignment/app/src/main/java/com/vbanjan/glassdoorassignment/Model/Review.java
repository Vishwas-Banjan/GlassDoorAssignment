package com.vbanjan.glassdoorassignment.Model;

import java.io.Serializable;

public class Review implements Serializable {
    private String advice, approvalStatus, attributionURL, ceoApproval, cons, employerId, employerName, employerResponse, employmentStatus,
            headline, id, jobInformation, jobTitle, jobTitleFromDb, lengthOfEmployment, location, overall, pros, reviewDateTime, sqLogoUrl;
    private Double careerOpportunitiesRating, ceoRating, compensationAndBenefitsRating, cultureAndValuesRating, seniorLeadershipRating,
            overallNumeric, workLifeBalanceRating;
    private String currentJob, featuredReview, newReview, recommendToFriend;
    private int helpfulCount, notHelpfulCount, totalHelpfulCount;

    public Review() {
    }

    @Override
    public String toString() {
        return "Review{" +
                "advice='" + advice + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", attributionURL='" + attributionURL + '\'' +
                ", ceoApproval='" + ceoApproval + '\'' +
                ", cons='" + cons + '\'' +
                ", employerId='" + employerId + '\'' +
                ", employerName='" + employerName + '\'' +
                ", employerResponse='" + employerResponse + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", headline='" + headline + '\'' +
                ", id='" + id + '\'' +
                ", jobInformation='" + jobInformation + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobTitleFromDb='" + jobTitleFromDb + '\'' +
                ", lengthOfEmployment='" + lengthOfEmployment + '\'' +
                ", location='" + location + '\'' +
                ", overall='" + overall + '\'' +
                ", pros='" + pros + '\'' +
                ", reviewDateTime='" + reviewDateTime + '\'' +
                ", sqLogoUrl='" + sqLogoUrl + '\'' +
                ", careerOpportunitiesRating=" + careerOpportunitiesRating +
                ", ceoRating=" + ceoRating +
                ", compensationAndBenefitsRating=" + compensationAndBenefitsRating +
                ", cultureAndValuesRating=" + cultureAndValuesRating +
                ", seniorLeadershipRating=" + seniorLeadershipRating +
                ", currentJob=" + currentJob +
                ", featuredReview=" + featuredReview +
                ", newReview=" + newReview +
                ", overallNumeric=" + overallNumeric +
                ", recommendToFriend=" + recommendToFriend +
                ", workLifeBalanceRating=" + workLifeBalanceRating +
                ", helpfulCount=" + helpfulCount +
                ", notHelpfulCount=" + notHelpfulCount +
                ", totalHelpfulCount=" + totalHelpfulCount +
                '}';
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
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

    public String getCeoApproval() {
        return ceoApproval;
    }

    public void setCeoApproval(String ceoApproval) {
        this.ceoApproval = ceoApproval;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
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

    public String getEmployerResponse() {
        return employerResponse;
    }

    public void setEmployerResponse(String employerResponse) {
        this.employerResponse = employerResponse;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobInformation() {
        return jobInformation;
    }

    public void setJobInformation(String jobInformation) {
        this.jobInformation = jobInformation;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitleFromDb() {
        return jobTitleFromDb;
    }

    public void setJobTitleFromDb(String jobTitleFromDb) {
        this.jobTitleFromDb = jobTitleFromDb;
    }

    public String getLengthOfEmployment() {
        return lengthOfEmployment;
    }

    public void setLengthOfEmployment(String lengthOfEmployment) {
        this.lengthOfEmployment = lengthOfEmployment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOverall() {
        return overall;
    }

    public void setOverall(String overall) {
        this.overall = overall;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
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

    public Double getCareerOpportunitiesRating() {
        return careerOpportunitiesRating;
    }

    public void setCareerOpportunitiesRating(Double careerOpportunitiesRating) {
        this.careerOpportunitiesRating = careerOpportunitiesRating;
    }

    public Double getCeoRating() {
        return ceoRating;
    }

    public void setCeoRating(Double ceoRating) {
        this.ceoRating = ceoRating;
    }

    public Double getCompensationAndBenefitsRating() {
        return compensationAndBenefitsRating;
    }

    public void setCompensationAndBenefitsRating(Double compensationAndBenefitsRating) {
        this.compensationAndBenefitsRating = compensationAndBenefitsRating;
    }

    public Double getCultureAndValuesRating() {
        return cultureAndValuesRating;
    }

    public void setCultureAndValuesRating(Double cultureAndValuesRating) {
        this.cultureAndValuesRating = cultureAndValuesRating;
    }

    public Double getSeniorLeadershipRating() {
        return seniorLeadershipRating;
    }

    public void setSeniorLeadershipRating(Double seniorLeadershipRating) {
        this.seniorLeadershipRating = seniorLeadershipRating;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
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

    public Double getOverallNumeric() {
        return overallNumeric;
    }

    public void setOverallNumeric(Double overallNumeric) {
        this.overallNumeric = overallNumeric;
    }

    public Double getWorkLifeBalanceRating() {
        return workLifeBalanceRating;
    }

    public void setWorkLifeBalanceRating(Double workLifeBalanceRating) {
        this.workLifeBalanceRating = workLifeBalanceRating;
    }

    public String getRecommendToFriend() {
        return recommendToFriend;
    }

    public void setRecommendToFriend(String recommendToFriend) {
        this.recommendToFriend = recommendToFriend;
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

    public int getTotalHelpfulCount() {
        return totalHelpfulCount;
    }

    public void setTotalHelpfulCount(int totalHelpfulCount) {
        this.totalHelpfulCount = totalHelpfulCount;
    }
}

