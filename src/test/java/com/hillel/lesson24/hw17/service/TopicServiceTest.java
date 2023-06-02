package com.hillel.lesson24.hw17.service;

import com.hillel.lesson24.hw17.mock.TopicRepositoryMock;
import com.hillel.lesson24.hw17.model.Topic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TopicServiceTest {
    public TopicService topicService;
    List<Topic> topicsMock = new ArrayList<>();
    @Before
    public void init() {
        topicsMock.clear();
        topicsMock.add(new Topic(1, "Physics"));
        topicsMock.add(new Topic(2, "Literature"));
        topicsMock.add(new Topic(3, "Math"));
        topicsMock.add(new Topic(4, "Informatics"));
        topicService = new TopicService(new TopicRepositoryMock(topicsMock).getMock());
    }

    @Test
    public void get() {
        init();
        int id = 2;
        Topic expected = new Topic(id, "Literature");
        Topic actual = topicService.get(id);
        Assert.assertEquals(expected.toString(), actual.toString());
    }
    @Test
    public void add() {
        init();
        Topic expected = new Topic(7, "Dancing");
        Topic actual = topicService.add(expected);
        Assert.assertEquals(expected, actual);
    }
}
