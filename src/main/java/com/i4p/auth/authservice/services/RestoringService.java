package com.i4p.auth.authservice.services;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("restoringService")
public class RestoringService extends Service {

    private static final String RESTORE_QUERY =
            "UPDATE users " +
            "SET delete_at = :delete_at " +
            "WHERE username = :username";

    @Override
    public String execute() throws DataAccessException {
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(databaseDAO.getDataSource());
        user.setDelete_at(null);

        try {
            template.update(RESTORE_QUERY, user.getUserMap());
        } catch (DataAccessException ex) {
            return ex.getLocalizedMessage();
        }

        return null;
    }
}
