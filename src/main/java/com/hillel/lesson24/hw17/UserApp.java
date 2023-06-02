package com.hillel.lesson24.hw17;

import com.hillel.lesson24.hw17.model.Question;
import com.hillel.lesson24.hw17.model.Topic;
import com.hillel.lesson24.hw17.repository.QuestionRepositoryImpl;
import com.hillel.lesson24.hw17.repository.TopicRepositoryImpl;
import com.hillel.lesson24.hw17.service.QuestionService;
import com.hillel.lesson24.hw17.service.TopicService;

import java.util.Scanner;

public class UserApp {
    private static int option = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, User!");
        do {
            while (true) {
                showMenu();
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                    if (option >= 1 && option <= 7) {
                        break;
                    }
                } else {
                    scanner.nextLine();
                }
            }
            implementOption(scanner, option);
        } while (option != 7);
    }

    public static void implementOption(Scanner scanner, int option) {
        TopicService topicService = new TopicService(new TopicRepositoryImpl());
        QuestionService questionService = new QuestionService(new QuestionRepositoryImpl());
        switch (option) {
            case 1:
                System.out.println("Enter the name of topic from which you want to get a question:");
                topicService.printTopicNames();
                String name = scanner.nextLine();
                System.out.println(questionService.getRandomByTopicName(name));
                System.out.println();
                break;
            case 2:
                System.out.println(questionService.getRandom());
                System.out.println();
                break;
            case 3:
                System.out.println("Enter a new question:");
                String questionText = scanner.nextLine();
                System.out.println("Choose the correct topic id from the list below. Use integers only:");
                topicService.printAll();
                int topicId = scanner.nextInt();
                Question question = new Question(questionText, topicId);
                questionService.add(question);
                break;
            case 4:
                System.out.println("Enter id of question you want to delete. Use integers only:");
                questionService.printAll();
                int questionId = scanner.nextInt();
                questionService.remove(questionId);
                break;
            case 5:
                System.out.println("Here is the list of available topics:");
                topicService.printAll();
                System.out.println();
                break;
            case 6:
                System.out.println("Enter a new topic name:");
                String topicName = scanner.nextLine();
                Topic topic = new Topic(topicName);
                topicService.add(topic);
                break;
            case 7:
                System.out.println("Goodbye!");
                break;
        }
    }

    private static void showMenu() {
        System.out.println("Using the commands below choose what you want to do:\n" +
                "1 - get a random question by specific topic\n" +
                "2 - get a random question by all topics\n" +
                "3 - add a new question\n" +
                "4 - delete a question\n" +
                "5 - get topics\n" +
                "6 - add a new topic\n" +
                "7 - exit\n");
    }
}

