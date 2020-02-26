package org.ieeezsb.Registration;

public class InterestsModel {

    private String text;
    private boolean isSelect;

    public InterestsModel() {
    }

    public InterestsModel(String text, boolean isSelect) {
        this.text = text;
        this.isSelect = isSelect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
