package com.i4p.auth.authservice.services;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("deletingService")
public class DeletingService extends Service {

    private static final String DELETING_QUERY =
            "UPDATE users " +
            "SET delete_at = :delete_at " +
            "WHERE username = :username;";

    @Override
    public String execute() {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(databaseDAO.getDataSource());
        user.setDelete_at(9999999999999l);

        try {
            template.update(DELETING_QUERY, user.getUserMap());
        } catch (DataAccessException ex) {
            return ex.getLocalizedMessage();
        }

        return null;
    }
}
