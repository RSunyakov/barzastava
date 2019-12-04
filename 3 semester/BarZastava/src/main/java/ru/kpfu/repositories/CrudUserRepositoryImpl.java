package ru.kpfu.repositories;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.models.User;
import ru.kpfu.models.UserForHw;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudUserRepositoryImpl implements CrudRepository<User> {
    private Connection connection;
    private PasswordEncoder passwordEncoder;

    public CrudUserRepositoryImpl(Connection connection) {
        this.connection = connection;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    private RowMapper<User>userRowMapper = rs ->
            new User(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("gender")
            );

    @Override
    public void save(User user) {
        String username = user.getUsername();
        String password = passwordEncoder.encode(user.getPassword());
        String email = user.getEmail();
        String gender = user.getGender();
        String sql = "INSERT INTO bar_user(email, username, password, gender) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, gender);
            preparedStatement.execute();
            user.setId(this.getUserId(email));
        } catch(SQLException e) {
            throw new IllegalStateException(e);
        }
    }


    @Override
    public void update(User user) {
        String sql = "UPDATE bar_user SET username=?, password=?, gender=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, passwordEncoder.encode(user.getPassword()));
            preparedStatement.setString(3, user.getGender());
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e)  {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> find(Integer id) {
        User user = null;
        String sql = "SELECT * FROM bar_user WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = userRowMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(user) ;
    }

    public Optional<User> find(String email) {
        User user = null;
        String sql = "SELECT * FROM bar_user WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = userRowMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(user) ;
    }

    @Override
    public void delete(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM bar_user WHERE id = ?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() {
        String sqlQuery = "SELECT * FROM bar_user";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bar_user");
             ResultSet rs = preparedStatement.executeQuery(sqlQuery)) {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(userRowMapper.mapRow(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Integer getUserId(String email) {
        Integer id = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id FROM bar_user WHERE email = ?")) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            id = rs.getInt("id");
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return id;
    }
}
