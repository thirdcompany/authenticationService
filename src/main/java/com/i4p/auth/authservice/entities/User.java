package com.i4p.auth.authservice.entities;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.HashMap;

@Component("user")
public class User {

    private HashMap<String, Object> userMap;

    public void setUserFromMap(HashMap<String, Object> map) {
        login = (String) map.get("login");
        password = (String) map.get("password");
        username = (String) map.get("username");
        email = (String) map.get("email");
        rating = (int) map.get("rating");
        about = (String) map.get("about");
        role = (String) map.get("role");
        create_at = (Date) map.get("create_at");
        update_at = (Date) map.get("update_at");
        delete_at = (Date) map.get("delete_at");
    }

    public HashMap<String, Object> getUserMap() {
        checkUpdateTime();

        HashMap<String, Object> map = new HashMap<>();
        map.put("login", login);
        map.put("password", password);
        map.put("username", username);
        map.put("email", email);
        map.put("rating", rating);
        map.put("about", about);
        map.put("role", role);
        map.put("create_at", create_at);
        map.put("update_at", update_at);
        map.put("delete_at", delete_at);

        return map;
    }

    private int id;

    private String login;

    private String password;

    private String username;

    private String email;

    private int rating;

    private String about;

    private String role;

    private Date create_at;

    private Date delete_at;

    private Date update_at;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCreate_at(Date create_at) {
        checkUpdateTime();
        this.create_at = create_at;
    }

    public void setDelete_at(Date delete_at) {
        this.delete_at = delete_at;
    }

    public void setDelete_at(long milis) {
        this.delete_at = new Date(milis);
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getRating() {
        return rating;
    }

    public String getAbout() {
        return about;
    }

    public String getRole() {
        return role;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public Date getDelete_at() {
        return delete_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    private void checkUpdateTime() {
        if(update_at == null) {
            update_at = create_at;
        }
    }
}
