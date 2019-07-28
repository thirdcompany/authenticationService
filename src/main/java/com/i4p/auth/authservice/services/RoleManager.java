package com.i4p.auth.authservice.services;

import com.i4p.auth.authservice.config.DatabaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

@Component("roleManager")
public class RoleManager {

    @Autowired
    DatabaseDAO databaseDAO;

    private static final String CHANGE_ROLE_QUERY =
            "UPDATE users" +
                    "SET role = ?" +
                    "WHERE username = ?";

    public String changeRole(String username, String role) {
        JdbcTemplate template = new JdbcTemplate(databaseDAO.getDataSource());
        return template.execute(con -> con.prepareStatement(CHANGE_ROLE_QUERY), (PreparedStatementCallback<String>) ps -> {
            ps.setString(1, role);
            ps.setString(2, username);
            ps.execute();
            return null;
        });
    }
}

