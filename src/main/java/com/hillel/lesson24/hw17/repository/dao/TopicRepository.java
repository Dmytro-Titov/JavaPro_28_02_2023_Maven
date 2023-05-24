package com.hillel.lesson24.hw17.repository.dao;

import com.hillel.lesson24.hw17.model.Topic;

public interface TopicRepository {
    boolean save(Topic topic);

    Topic get(int id);

    boolean remove(int id);

    int update(Topic topic);
}
