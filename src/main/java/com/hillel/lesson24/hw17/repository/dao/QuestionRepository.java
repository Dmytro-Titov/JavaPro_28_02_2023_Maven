package com.hillel.lesson24.hw17.repository.dao;

import com.hillel.lesson24.hw17.model.Question;

public interface QuestionRepository {
    boolean save(Question question);

    Question get(int id);

    boolean remove(int id);

    int update(Question question);
}
