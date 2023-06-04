package com.hillel.lesson24.hw17.service;

import com.hillel.lesson24.hw17.model.Topic;
import com.hillel.lesson24.hw17.repository.dao.TopicRepository;

import java.util.List;

public class TopicService {
    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic get(int id) {
        return topicRepository.get(id);
    }

    public Topic add(Topic topic) {
        return topicRepository.save(topic);
    }
    public void printAll() {
        List<Topic> all = topicRepository.getAll();
        for (Topic topic : all) {
            System.out.format("Topic: %s, id: %d\n", topic.getName(), topic.getId());
        }
    }
    public void printTopicNames() {
        List<Topic> all = topicRepository.getAll();
        for (Topic topic : all) {
            System.out.println(topic.getName());
        }
    }
}
