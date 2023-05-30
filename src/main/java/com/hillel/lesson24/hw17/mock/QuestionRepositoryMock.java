package com.hillel.lesson24.hw17.mock;

import com.hillel.lesson24.hw17.model.Question;
import com.hillel.lesson24.hw17.repository.dao.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryMock {
    private List<Question> questionsMock;

    public QuestionRepositoryMock(List<Question> questionsMock) {
        this.questionsMock = questionsMock;
    }

    public QuestionRepository getMock() {
        return new QuestionRepository() {
            @Override
            public boolean save(Question question) {
                return questionsMock.add(question);
            }

            @Override
            public Question get(int id) {
                for (Question question : questionsMock) {
                    if (question.getId() == id) {
                        return question;
                    }
                }
                return null;
            }

            @Override
            public boolean remove(int id) {
                for (Question question : questionsMock) {
                    if (question.getId() == id) {
                        return questionsMock.remove(question);
                    }
                }
                return false;
            }

            @Override
            public int update(Question updateQuestion) {
                for (Question question : questionsMock) {
                    if (updateQuestion.getId() == question.getId()) {
                        question.setText(updateQuestion.getText());
                        question.setTopicId(updateQuestion.getTopicId());
                        return 1;
                    }
                }
                return 0;
            }

            @Override
            public List<Question> getAll() {
                return questionsMock;
            }

            @Override
            public List<Question> getAllByTopic(int topicId) {
                List<Question> allByTopic = new ArrayList<>();
                for (Question question : questionsMock) {
                    if (question.getTopicId() == topicId) {
                        allByTopic.add(question);
                    }
                }
                return allByTopic;
            }
        };
    }
}
