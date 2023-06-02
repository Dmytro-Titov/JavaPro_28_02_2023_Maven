package com.hillel.lesson24.hw17.repository.dao;

import com.hillel.lesson24.hw17.model.Question;

import java.util.List;

public interface QuestionRepository {
    Question save(Question question);

    Question get(int id);

    Question remove(int id);

    int update(Question question);
    List<Question> getAll();
    List<Question> getAllByTopicId(int topicId);
    List<Question> getAllByTopicName(String topicName);
}
