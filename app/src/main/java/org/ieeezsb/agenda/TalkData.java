package org.ieeezsb.agenda;

public class TalkData {
    private String time;
    private String talk;
    private String speaker;
    private String description;
    private int image;

    public TalkData(String time, String talk, String speaker, String description, int image) {
        this.time = time;
        this.talk = talk;
        this.speaker = speaker;
        this.description = description;
        this.image = image;

    }

    public String getTime() {
        return time;
    }

    public String getTalk() {
        return talk;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

}
