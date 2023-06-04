package com.hillel.lesson24.hw17.repository;

import com.hillel.lesson24.hw17.SingletonConnection;
import com.hillel.lesson24.hw17.exception.*;
import com.hillel.lesson24.hw17.model.Question;
import com.hillel.lesson24.hw17.repository.dao.QuestionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final Connection connection;
    private static final String get = "SELECT * FROM question WHERE id = ?";
    private static final String getAll = "SELECT * FROM question";
    private static final String getAllByTopicId = "SELECT * FROM question WHERE topic_id = ?";
    private static final String getAllByTopicName = "SELECT question.* FROM question JOIN topic ON " +
            "question.topic_id = topic.id WHERE topic.name = ?";
    private static final String save = "INSERT INTO public.question(text, topic_id) VALUES (?, ?)";
    private static final String remove = "DELETE FROM public.question WHERE id = ?";
    private static final String update = "UPDATE public.question SET text = ?, topic_id = ? WHERE id = ?";

    public QuestionRepositoryImpl() {
        connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public Question save(Question question) {
        try (PreparedStatement statement = this.connection.prepareStatement(save)) {
            statement.setString(1, question.getText());
            statement.setInt(2, question.getTopicId());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                question.setId(generatedKeys.getInt(1));
            }
            return question;
        } catch (SQLException e) {
            throw new UnsuccessfulSaveException(e.getMessage());
        }
    }

    @Override
    public Question get(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(get)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return new Question(resultSet.getInt("id"), resultSet.getString("text"),
                        resultSet.getInt("topic_id"));
            }
        } catch (SQLException e) {
            throw new NoSuchSQLIdException(e.getMessage());
        }
    }

    @Override
    public Question remove(int id) {
        Question removedQuestion = get(id);
        try (PreparedStatement statement = this.connection.prepareStatement(remove)) {
            statement.setInt(1, id);
            statement.execute();
            return removedQuestion;
        } catch (SQLException e) {
            throw new UnsuccessfulRemoveException(e.getMessage());
        }
    }

    @Override
    public int update(Question question) {
        try (PreparedStatement statement = this.connection.prepareStatement(update)) {
            statement.setString(1, question.getText());
            statement.setInt(2, question.getTopicId());
            statement.setInt(3, question.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new UnsuccessfulUpdateException(e.getMessage());
        }
    }

    @Override
    public List<Question> getAll() {
        List<Question> all = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(getAll)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                all.add(new Question(resultSet.getInt("id"), resultSet.getString("text"),
                        resultSet.getInt("topic_id")));
            }
            return all;
        } catch (SQLException e) {
            throw new RetrieveAllException(e.getMessage());
        }
    }

    @Override
    public List<Question> getAllByTopicId(int topicId) {
        List<Question> allByTopic = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(getAllByTopicId)) {
            statement.setInt(1, topicId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allByTopic.add(new Question(resultSet.getInt("id"), resultSet.getString("text"),
                        resultSet.getInt("topic_id")));
            }
            return allByTopic;
        } catch (SQLException e) {
            throw new RetrieveAllByTopicIdException(e.getMessage());
        }
    }

    @Override
    public List<Question> getAllByTopicName(String topicName) {
        List<Question> allByTopic = new ArrayList<>();
        try (PreparedStatement statement = this.connection.prepareStatement(getAllByTopicName)) {
            statement.setString(1, topicName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allByTopic.add(new Question(resultSet.getInt("id"), resultSet.getString("text"),
                        resultSet.getInt("topic_id")));
            }
            return allByTopic;
        } catch (SQLException e) {
            throw new RetrieveAllByTopicNameException(e.getMessage());
        }
    }
}
