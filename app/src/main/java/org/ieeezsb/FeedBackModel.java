package org.ieeezsb;

public class FeedBackModel {
    private String comment;
    private double speakers, posters, flowOfEvent, volunteers, overall;

    public FeedBackModel(String comment, double speakers, double posters, double flowOfEvent, double volunteers, double overall) {
        this.comment = comment;
        this.speakers = speakers;
        this.posters = posters;
        this.flowOfEvent = flowOfEvent;
        this.volunteers = volunteers;
        this.overall = overall;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getSpeakers() {
        return speakers;
    }

    public void setSpeakers(double speakers) {
        this.speakers = speakers;
    }

    public double getPosters() {
        return posters;
    }

    public void setPosters(double posters) {
        this.posters = posters;
    }

    public double getFlowOfEvent() {
        return flowOfEvent;
    }

    public void setFlowOfEvent(double flowOfEvent) {
        this.flowOfEvent = flowOfEvent;
    }

    public double getVolunteers() {
        return volunteers;
    }

    public void setVolunteers(double volunteers) {
        this.volunteers = volunteers;
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
                ", speakers=" + speakers +
                ", posters=" + posters +
                ", flowOfEvent=" + flowOfEvent +
                ", volunteers=" + volunteers +
                ", overall=" + overall +
                '}';
    }
}
