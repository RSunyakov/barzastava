package ru.kpfu.repositories;

import ru.kpfu.models.Role;
import ru.kpfu.models.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrudRoleRepositoryImpl implements CrudRepository<Role> {
    private Connection connection;

    public CrudRoleRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    private RowMapper<Role>userRowMapper = rs ->
            new Role(
                    rs.getInt("user_id"),
                    rs.getInt("id"),
                    rs.getString("address")
            );


    @Override
    public void save(Role role) {
        Integer user_id = role.getUser_id();
        String address = role.getRole();
        String sql = "INSERT INTO bar_role(address, user_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, user_id);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void update(Role role) {
        Optional<Role> roleOptional = find(role.getId());
        roleOptional.ifPresent(this::delete);
        save(role);
    }
    public void update(Integer userId, String[] role) {
        List<Role> roles = findByUserId(userId);
        for (int i = 0; i < roles.size(); i++) {
            delete(roles.get(i));
        }
        for (int i = 0; i < role.length; i++) {
            save(new Role(null, userId, role[i]));
        }
    }
    @Override
    public Optional<Role> find(Integer id) {
        Role role = null;
        String sql = "SELECT * FROM bar_role WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                role = userRowMapper.mapRow(rs);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return Optional.ofNullable(role) ;
    }

    @Override
    public void delete(Role role) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM bar_role WHERE user_id = ?");
            preparedStatement.setInt(1, role.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Role> findAll() {
        String sqlQuery = "SELECT * FROM bar_user";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM bar_role");
             ResultSet rs = preparedStatement.executeQuery(sqlQuery)) {
            List<Role> roles = new ArrayList<>();
            while (rs.next()) {
                roles.add(userRowMapper.mapRow(rs));
            }
            return roles;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public List<Role> findByUserId(Integer user_id) {
        String sqlQuery = "SELECT * FROM bar_role WHERE user_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            List<Role> roles = new ArrayList<>();
            while (rs.next()) {
                roles.add(userRowMapper.mapRow(rs));
            }
            return roles;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
