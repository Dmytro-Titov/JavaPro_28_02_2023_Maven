package com.hillel.lesson24.hw17.repository;

import com.hillel.lesson24.hw17.SingletonConnection;
import com.hillel.lesson24.hw17.model.Question;
import com.hillel.lesson24.hw17.repository.dao.QuestionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRepositoryImpl implements QuestionRepository {
    private final Connection connection;
    private static final String get = "SELECT * from question where id = ?";
    private static final String save = "INSERT INTO public.question(text, topic_id) VALUES (?, ?)";
    private static final String remove = "DELETE FROM public.question WHERE id = ?";
    private static final String update = "UPDATE public.question SET text = ?, topic_id = ? WHERE id = ?";

    public QuestionRepositoryImpl() {
        connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public boolean save(Question question) {
        try (PreparedStatement statement = this.connection.prepareStatement(save)) {
            statement.setString(1, question.getText());
            statement.setInt(2, question.getTopicId());
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(remove)) {
            statement.setInt(1, id);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }
}
