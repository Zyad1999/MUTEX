package org.ieeezsb;

public class FeedBackModel {
    private String comment;
    private double  overall;

    public FeedBackModel(String comment, double overall) {
        this.comment = comment;
        this.overall = overall;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getOverall() {
        return overall;
    }

    public void setOverall(double overall) {
        this.overall = overall;
    }

    @Override
    public String toString() {
        return "FeedBackModel{" +
                "comment='" + comment + '\'' +
                ", overall=" + overall +
                '}';
    }
}