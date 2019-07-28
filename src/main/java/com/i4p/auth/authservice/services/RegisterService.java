package com.i4p.auth.authservice.services;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component("registerService")
public class RegisterService extends Service {

    private static final String INSERT_QUERY =
            "INSERT INTO Users (login, password, username, email, rating, " +
                    "about, role, create_at, update_at, delete_at)" +
                    "VALUES (:login, :password, :username, :email, :rating, " +
                    ":about, :role, :create_at, :update_at, :delete_at);";

    @Override
    public String execute() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(databaseDAO.getDataSource());

        try {
            template.update(INSERT_QUERY, user.getUserMap());
        } catch (DataAccessException ex) {
            return ex.getLocalizedMessage();
        }

        return null;
    }
}
