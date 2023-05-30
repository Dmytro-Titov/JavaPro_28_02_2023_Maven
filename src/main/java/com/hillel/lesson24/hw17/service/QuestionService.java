package com.hillel.lesson24.hw17.service;

import com.hillel.lesson24.hw17.model.Question;
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
        int random = ThreadLocalRandom.current().nextInt(0, all.size());
        return all.get(random);
    }
    public Question getRandomByTopic(int topiId) {
        List<Question> allByTopic = questionRepository.getAllByTopic(topiId);
        int random = ThreadLocalRandom.current().nextInt(0, allByTopic.size());
        return allByTopic.get(random);
    }
    public void add(Question question) {
        questionRepository.save(question);
    }
    public void remove(int id) {
        questionRepository.remove(id);
    }
}
