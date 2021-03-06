package org.basecampcodingacademy.reflections.db;

import org.basecampcodingacademy.reflections.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ResponseRepository {
    @Autowired
    public JdbcTemplate jdbc;

    public List<Response> all() {
        return jdbc.query("SELECT id, reflectionId, userUsername FROM responses", this::mapper);
    }

    public Response create(Response response) {
        return jdbc.queryForObject(
                "INSERT INTO responses (userUsername, reflectionId) VALUES (?, ?) RETURNING id, userUsername, reflectionId",
                this::mapper,
                response.userUsername,
                response.reflectionId

        );
    }

    public Response find() {
        try {
            return jdbc.queryForObject("SELECT id, reflectionId FROM responses WHERE reflectionId = ? LIMIT 1", this::mapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    public List<Response> getResponses(Response response) {
        return jdbc.query("SELECT id, reflectionId, userUsername, answers FROM responses WHERE reflectionId = ?", this::mapper, response.reflectionId);
    }

    public List<Response> findForReflection(Response response) {
        return jdbc.query("SELECT id, reflectionId, userUsername FROM responses WHERE reflectionId = ?", this::mapper, response.reflectionId);
    }

    public Response update(Response response) {
        return jdbc.queryForObject(
                "UPDATE responses SET userUsername = ? WHERE id = ? RETURNING id, reflectionId",
                this::mapper, response.reflectionId, response.id);
    }

    public void delete(Integer id) {
        jdbc.query("DELETE FROM responses WHERE id = ? RETURNING id, reflectionId", this::mapper, id);
    }

    private Response mapper(ResultSet resultSet, int i) throws SQLException {
        return new Response(
                resultSet.getInt("id"),
                resultSet.getInt("reflectionId"),
                resultSet.getString("userUsername"),
                null
        );
    }
}