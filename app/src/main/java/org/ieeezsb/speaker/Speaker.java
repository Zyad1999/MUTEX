package org.ieeezsb.speaker;

public class Speaker {

    private int imageResource;
    private String name, description, facebookLink, twitterLink, LinkedinLink, githubLink;


    public Speaker(int imageResource, String name, String description, String facebookLink, String twitterLink, String linkedinLink, String githubLink) {
        this.name = name;
        this.imageResource = imageResource;
        this.description = description;
        this.facebookLink = facebookLink;
        this.twitterLink = twitterLink;
        this.LinkedinLink = linkedinLink;
        this.githubLink = githubLink;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public String getLinkedinLink() {
        return LinkedinLink;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public int getImageResource() {
        return imageResource;
    }
}
