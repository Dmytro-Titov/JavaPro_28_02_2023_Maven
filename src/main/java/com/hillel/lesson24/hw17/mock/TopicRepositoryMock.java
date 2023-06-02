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
            public boolean save(Topic topic) {
                return topicsMock.add(topic);
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
            public boolean remove(int id) {
                for (Topic topic : topicsMock) {
                    if (topic.getId() == id) {
                        return topicsMock.remove(topic);
                    }
                }
                return false;
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
        };
    }
}
