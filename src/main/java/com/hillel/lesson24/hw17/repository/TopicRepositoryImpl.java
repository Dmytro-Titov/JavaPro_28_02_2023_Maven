package com.hillel.lesson24.hw17.repository;

import com.hillel.lesson24.hw17.SingletonConnection;
import com.hillel.lesson24.hw17.model.Topic;
import com.hillel.lesson24.hw17.repository.dao.TopicRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicRepositoryImpl implements TopicRepository {

    private final Connection connection;
    private static final String get = "SELECT * from topic where id = ?";
    private static final String save = "INSERT INTO public.topic(name) VALUES (?)";
    private static final String remove = "DELETE FROM public.topic WHERE id = ?";
    private static final String update = "UPDATE public.topic SET name = ? WHERE id = ?";

    public TopicRepositoryImpl() {
        this.connection = SingletonConnection.getInstance().getConnection();
    }

    @Override
    public boolean save(Topic topic) {
        try (PreparedStatement statement = this.connection.prepareStatement(save)) {
            statement.setString(1, topic.getName());
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Topic get(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(get)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                return new Topic(resultSet.getInt("id"), resultSet.getString("name"));
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
    public int update(Topic topic) {
        try (PreparedStatement statement = this.connection.prepareStatement(update)){
            statement.setString(1, topic.getName());
            statement.setInt(2, topic.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
