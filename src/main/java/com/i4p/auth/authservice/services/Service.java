package com.i4p.auth.authservice.services;

import com.i4p.auth.authservice.config.DatabaseDAO;
import com.i4p.auth.authservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public abstract class Service {

    @Autowired
    DatabaseDAO databaseDAO;

    @Autowired
    User user;

    public abstract String execute() throws DataAccessException;
}
