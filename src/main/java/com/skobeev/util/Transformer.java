package com.skobeev.util;

import com.skobeev.model.Department;
import com.skobeev.model.User;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Transformer {

    private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static Department getDepartment(HttpServletRequest req) {
        Department department = new Department();
        department.setName(req.getParameter("name"));
        if (!req.getParameter("id").equals("")) {
            department.setId(Long.parseLong(req.getParameter("id")));
        }
        return department;
    }

    public static User getUser(HttpServletRequest req) {
        User user = new User();
        if (!req.getParameter("id").equals("")) {
            user.setId(Long.parseLong(req.getParameter("id")));
        }
        user.setLastName(req.getParameter("lastName"));
        user.setFirstName(req.getParameter("firstName"));
        user.setMail(req.getParameter("mail"));
        try {
            user.setBirthDay(format.parse((req.getParameter("birthDay"))));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Long salary = Long.parseLong(req.getParameter("salary"));
        user.setSalary(salary);
        Long depId = Long.parseLong(req.getParameter("depId"));
        user.setDepId(depId);
        return user;
    }

//    public static Department deleteDepartment(HttpServletRequest req){
//        Department department = new Department();
//        String table
//        department.setId(Long.parseLong(req.getParameter("id")));
//        return department;
}

