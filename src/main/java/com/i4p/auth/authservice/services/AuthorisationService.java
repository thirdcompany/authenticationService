package com.i4p.auth.authservice.services;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

@Component("authorisationService")
public class AuthorisationService extends Service {

    private static final String AUTH_QUERY =
            "SELECT * FROM users WHERE ";

    @Override
    public String execute() throws DataAccessException {
        /*  In entry point user will have login OR email(not both),
            cause people usually logs with login/email          */
        StringBuilder query = new StringBuilder(AUTH_QUERY);

        if(user.getEmail() != null) {
            query.append("email = '");
            query.append(user.getEmail());
            query.append("';");

        } else if (user.getLogin() != null) {
            query.append("login = '");
            query.append(user.getLogin());
            query.append("';");

        } else throw new IllegalArgumentException();

        JdbcTemplate template = new JdbcTemplate(databaseDAO.getDataSource());
        template.query(query.toString(), rs -> {
            user.setUserFromMap(getMapFromQuery(rs));
        });

        if(user.getUsername() == null) {
            return "No such user";
        } else {
            return null;
        }
    }

    private HashMap<String, Object> getMapFromQuery(ResultSet rs) throws SQLException {
        HashMap<String, Object> resultMap = new HashMap<>();
        ResultSetMetaData meta = rs.getMetaData();
        if(rs.next()) {
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                resultMap.put(meta.getColumnName(i), rs.getObject(i));
            }
        } else return null;
        return resultMap;
    }
}
