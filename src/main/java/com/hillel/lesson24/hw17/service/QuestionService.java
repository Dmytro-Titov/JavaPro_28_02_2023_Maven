package com.hillel.lesson24.hw17.service;

import com.hillel.lesson24.hw17.exception.RetrieveAllByTopicIdException;
import com.hillel.lesson24.hw17.exception.RetrieveAllByTopicNameException;
import com.hillel.lesson24.hw17.exception.RetrieveAllException;
import com.hillel.lesson24.hw17.model.Question;
import com.hillel.lesson24.hw17.model.Topic;
import com.hillel.lesson24.hw17.repository.dao.QuestionRepository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getRandom() {
        List<Question> all = questionRepository.getAll();
        if (all == null || all.isEmpty()) {
            throw new RetrieveAllException("Arraylist was not filled");
        }
        int random = ThreadLocalRandom.current().nextInt(0, all.size());
        return all.get(random);
    }

    public Question getRandomByTopicId(int topicId) {
        List<Question> allByTopic = questionRepository.getAllByTopicId(topicId);
        if (allByTopic == null || allByTopic.isEmpty()) {
            throw new RetrieveAllByTopicIdException("Arraylist was not filled");
        }
        int random = ThreadLocalRandom.current().nextInt(0, allByTopic.size());
        return allByTopic.get(random);
    }

    public Question getRandomByTopicName(String topicName) {
        List<Question> allByTopicName = questionRepository.getAllByTopicName(topicName);
        if (allByTopicName == null || allByTopicName.isEmpty()) {
            throw new RetrieveAllByTopicNameException("Arraylist was not filled");
        }
        int random = ThreadLocalRandom.current().nextInt(0, allByTopicName.size());
        return allByTopicName.get(random);
    }

    public Question add(Question question) {
        return questionRepository.save(question);
    }

    public Question remove(int id) {
        return questionRepository.remove(id);
    }

    public void printAll() {
        List<Question> all = questionRepository.getAll();
        for (Question question : all) {
            System.out.format("Question: %s, id: %d\n", question.getText(), question.getId());
        }
    }
}
