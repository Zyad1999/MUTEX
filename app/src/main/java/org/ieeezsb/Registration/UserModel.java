package org.ieeezsb.Registration;

import java.util.ArrayList;

public class UserModel {

    private String fName, lName, faculty, whatsapp, facebookLink, bio, profilePicLink, id, email, username;
    private ArrayList<String> interests, skills;

    public UserModel() {
    }

    public UserModel(String fName, String lName, String faculty, String whatsapp, String facebookLink, String bio, String profilePicLink, String id, String email, String username) {
        this.fName = fName;
        this.lName = lName;
        this.faculty = faculty;
        this.whatsapp = whatsapp;
        this.facebookLink = facebookLink;
        this.bio = bio;
        this.profilePicLink = profilePicLink;
        this.id = id;
        this.email = email;
        this.username = username;
        this.interests = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", whatsapp='" + whatsapp + '\'' +
                ", facebookLink='" + facebookLink + '\'' +
                ", bio='" + bio + '\'' +
                ", profilePicLink='" + profilePicLink + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", interests=" + interests +
                ", skills=" + skills +
                '}';
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicLink() {
        return profilePicLink;
    }

    public void setProfilePicLink(String profilePicLink) {
        this.profilePicLink = profilePicLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public void addInterest(String h) {
        this.interests.add(h);
    }

    public void addSkill(String s) {
        this.skills.add(s);
    }
}
