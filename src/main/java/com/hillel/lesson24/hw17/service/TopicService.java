package com.hillel.lesson24.hw17.service;

import com.hillel.lesson24.hw17.model.Topic;
import com.hillel.lesson24.hw17.repository.dao.TopicRepository;

public class TopicService {
    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic get(int id) {
        return topicRepository.get(id);
    }

    public void save(Topic topic) {
        topicRepository.save(topic);
    }
}
