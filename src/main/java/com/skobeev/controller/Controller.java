package com.skobeev.controller;

import com.skobeev.controller.processor.Processor;
import com.skobeev.controller.processor.impl.*;
import com.skobeev.exceptions.MyException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.skobeev.constants.PathConstants.*;

public class Controller extends HttpServlet {

    private static final Map<String, Processor> PARAMS = new HashMap<String, Processor>() {{
        put(MAIN, new Main());
        put(DEPARTMENTS, new DepartmentList());
        put(USERS, new UserList());
        put(DEPARTMENT_SAVE, new DepartmentSave());
        put(USER_DELETE, new UserDelete());
        put(DEPARTMENT_DELETE, new DepartmentDelete());
        put(USER_FORM, new UserForm());
        put(DEPARTMENT_FORM, new DepartmentForm());
        put(USER_SAVE, new UserSave());
    }};

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pr = req.getRequestURI();
        if (PARAMS.get(pr) != null) {
            try {
                PARAMS.get(pr).method(req, resp);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }
}

