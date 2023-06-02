package com.hillel.lesson24.hw17.repository.dao;

import com.hillel.lesson24.hw17.model.Topic;

import java.util.List;

public interface TopicRepository {
    Topic save(Topic topic);

    Topic get(int id);

    Topic remove(int id);

    int update(Topic topic);
    List<Topic> getAll();
}
