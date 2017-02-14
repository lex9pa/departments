package com.skobeev.controller.processor.impl;

import com.skobeev.controller.processor.Processor;
import com.skobeev.exceptions.MyException;
import com.skobeev.model.User;
import com.skobeev.service.UserService;
import com.skobeev.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.constants.CommonConstants.ID;
import static com.skobeev.constants.CommonConstants.USER_LIST;
import static com.skobeev.constants.ErrorConstants.ERROR;
import static com.skobeev.constants.ErrorConstants.PAGE_ERROR;
import static com.skobeev.constants.PathConstants.PAGES_USER_EDIT_JSP;

public class UserForm implements Processor {

    private UserService userService = new UserServiceImpl();

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = (req.getParameter(ID));
        User user = new User();
        if (id != null) {
            try {
                user = userService.getUserById(Long.parseLong(id));
            } catch (MyException e) {
                req.setAttribute(ERROR, e.getError());
                req.getRequestDispatcher(PAGE_ERROR).forward(req, resp);
            }
        }
        req.setAttribute(USER_LIST, user);
        req.getRequestDispatcher(PAGES_USER_EDIT_JSP).forward(req, resp);
    }
}
