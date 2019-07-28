package com.i4p.auth.authservice;

import com.i4p.auth.authservice.entities.User;
import com.i4p.auth.authservice.services.DeletingService;
import com.i4p.auth.authservice.services.RegisterService;
import com.i4p.auth.authservice.services.RestoringService;
import com.i4p.auth.authservice.services.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class AuthServiceApplication {

    static User user;

    static private Service registerService;

    static private Service deletingService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        user = context.getBean("user", User.class);
        user.setLogin("asd");
        user.setPassword("asd");
        user.setUsername("dsa");
        user.setRating(0);
        user.setRole("adm");
        user.setCreate_at(new Date(1563734303558l));
        registerService = context.getBean("registerService", RegisterService.class);
        registerService.execute();
        deletingService = context.getBean("restoringService", RestoringService.class);
        deletingService.execute();
        context.close();
    }

}
