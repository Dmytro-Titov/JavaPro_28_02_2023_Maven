package com.hillel.lesson24.hw17.model;

public class Question {
    private int id;
    private String text;
    private int topicId;

    public Question(int id, String text, int topicId) {
        this.id = id;
        this.text = text;
        this.topicId = topicId;
    }

    public Question(String text, int topicId) {
        this.text = text;
        this.topicId = topicId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", topicId=" + topicId +
                '}';
    }
}
