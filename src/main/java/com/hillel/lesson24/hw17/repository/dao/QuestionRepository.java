package com.hillel.lesson24.hw17.repository.dao;

import com.hillel.lesson24.hw17.model.Question;

import java.util.List;

public interface QuestionRepository {
    boolean save(Question question);

    Question get(int id);

    boolean remove(int id);

    int update(Question question);
    List<Question> getAll();
    List<Question> getAllByTopic(int topicId);
}
