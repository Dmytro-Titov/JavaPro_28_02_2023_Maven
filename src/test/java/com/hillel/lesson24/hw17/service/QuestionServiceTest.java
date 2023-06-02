package com.hillel.lesson24.hw17.service;

import com.hillel.lesson24.hw17.mock.QuestionRepositoryMock;
import com.hillel.lesson24.hw17.model.Question;
import com.hillel.lesson24.hw17.repository.QuestionRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuestionServiceTest {
    private QuestionService questionService;
    private List<Question> questionsMock = new ArrayList<>();

    @Before
    public void init() {
        questionsMock.clear();
        questionsMock.add(new Question(1, "Mock1.1", 1));
        questionsMock.add(new Question(2, "Mock1.2", 1));
        questionsMock.add(new Question(3, "Mock1.3", 1));
        questionsMock.add(new Question(4, "Mock2.1", 2));
        questionsMock.add(new Question(5, "Mock2.2", 2));
        questionsMock.add(new Question(6, "Mock2.3", 2));
        questionsMock.add(new Question(7, "Mock3.1", 3));
        questionService = new QuestionService(new QuestionRepositoryMock(questionsMock).getMock());
    }

    @Test
    public void getRandomTest() {
        init();
        System.out.println(questionService.getRandom());
    }
    @Test
    public void getRandomByTopicTest() {
        init();
        int topicId = 2;
        System.out.println(questionService.getRandomByTopic(topicId));
    }
    @Test
    public void addTest() {
        init();
        int expected = questionsMock.size() + 1;
        Question question = new Question(8, "Mock.4.1", 4);
        questionService.add(question);
        int actual = questionsMock.size();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void removeTest() {
        init();
        int removeId = 4;
        int expected = questionsMock.size() - 1;
        questionService.remove(removeId);
        int actual = questionsMock.size();
        Assert.assertEquals(expected, actual);
    }

}
