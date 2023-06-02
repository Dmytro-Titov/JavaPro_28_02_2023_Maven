package com.hillel.lesson24.hw17.mock;

import com.hillel.lesson24.hw17.model.Question;
import com.hillel.lesson24.hw17.model.Topic;
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
            public Question save(Question question) {
                questionsMock.add(question);
                return question;
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
            public Question remove(int id) {
                for (Question question : questionsMock) {
                    if (question.getId() == id) {
                        Question removedQuestion = question;
                        questionsMock.remove(question);
                        return removedQuestion;
                    }
                }
                return null;
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
            public List<Question> getAllByTopicId(int topicId) {
                List<Question> allByTopic = new ArrayList<>();
                for (Question question : questionsMock) {
                    if (question.getTopicId() == topicId) {
                        allByTopic.add(question);
                    }
                }
                return allByTopic;
            }

            @Override
            public List<Question> getAllByTopicName(String topicName) {
                List<Topic> topics = new ArrayList<>();
                topics.add(new Topic(1, "Math"));
                topics.add(new Topic(2, "History"));
                topics.add(new Topic(3, "Linguistics"));

                List<Question> allByTopic = new ArrayList<>();
                for (Topic topic : topics) {
                    if (topic.getName().equals(topicName)) {
                        for (Question question : questionsMock) {
                            if (question.getTopicId() == topic.getId()) {
                                allByTopic.add(question);
                            }
                        }
                        break;
                    }
                }
                return allByTopic;
            }
        };
    }
}
