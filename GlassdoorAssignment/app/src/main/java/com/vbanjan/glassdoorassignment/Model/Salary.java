package com.vbanjan.glassdoorassignment.Model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Salary implements Serializable {
    private String attributionURL, employerId, employerName, employmentStatus, id, jobTitle,
            location, payDeltaLocationType, payPeriod, reviewDateTime, sqLogoUrl;
    private Pay basePay, meanBasePay;
    private BigDecimal payDeltaPercent;

    public class Pay implements Serializable {
        BigDecimal amount;
        String currencyCode, name, symbol;

        public Pay() {
        }

        @Override
        public String toString() {
            return "Pay{" +
                    "amount=" + amount +
                    ", currencyCode='" + currencyCode + '\'' +
                    ", name='" + name + '\'' +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public Salary() {
    }

    @Override
    public String toString() {
        return "Salary{" +
                "attributionURL='" + attributionURL + '\'' +
                ", employerId='" + employerId + '\'' +
                ", employerName='" + employerName + '\'' +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", id='" + id + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", location='" + location + '\'' +
                ", payDeltaLocationType='" + payDeltaLocationType + '\'' +
                ", payPeriod='" + payPeriod + '\'' +
                ", reviewDateTime='" + reviewDateTime + '\'' +
                ", sqLogoUrl='" + sqLogoUrl + '\'' +
                ", basePay=" + basePay +
                ", meanBasePay=" + meanBasePay +
                ", payDeltaPercent=" + payDeltaPercent +
                '}';
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

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPayDeltaLocationType() {
        return payDeltaLocationType;
    }

    public void setPayDeltaLocationType(String payDeltaLocationType) {
        this.payDeltaLocationType = payDeltaLocationType;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
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

    public Pay getBasePay() {
        return basePay;
    }

    public void setBasePay(Pay basePay) {
        this.basePay = basePay;
    }

    public Pay getMeanBasePay() {
        return meanBasePay;
    }

    public void setMeanBasePay(Pay meanBasePay) {
        this.meanBasePay = meanBasePay;
    }

    public BigDecimal getPayDeltaPercent() {
        return payDeltaPercent;
    }

    public void setPayDeltaPercent(BigDecimal payDeltaPercent) {
        this.payDeltaPercent = payDeltaPercent;
    }
}
