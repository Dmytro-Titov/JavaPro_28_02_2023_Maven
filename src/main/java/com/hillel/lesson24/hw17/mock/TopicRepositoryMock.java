package com.hillel.lesson24.hw17.mock;

import com.hillel.lesson24.hw17.model.Topic;
import com.hillel.lesson24.hw17.repository.dao.TopicRepository;

import java.util.List;

public class TopicRepositoryMock {
    private List<Topic> topicsMock;

    public TopicRepositoryMock(List<Topic> topicsMock) {
        this.topicsMock = topicsMock;
    }

    public TopicRepository getMock() {
        return new TopicRepository() {
            @Override
            public Topic save(Topic topic) {
                topicsMock.add(topic);
                return topic;
            }

            @Override
            public Topic get(int id) {
                for (Topic topic : topicsMock) {
                    if (topic.getId() == id) {
                        return topic;
                    }
                }
                return null;
            }

            @Override
            public Topic remove(int id) {
                for (Topic topic : topicsMock) {
                    if (topic.getId() == id) {
                        Topic removedTopic = topic;
                        topicsMock.remove(topic);
                        return removedTopic;
                    }
                }
                return null;
            }

            @Override
            public int update(Topic updateTopic) {
                for (Topic topic : topicsMock) {
                    if (updateTopic.getId() == topic.getId()) {
                        topic.setName(updateTopic.getName());
                        return 1;
                    }
                }
                return 0;
            }

            @Override
            public List<Topic> getAll() {
                return topicsMock;
            }
        };
    }
}
