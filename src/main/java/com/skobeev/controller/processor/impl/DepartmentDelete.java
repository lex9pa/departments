package com.skobeev.controller.processor.impl;

import com.skobeev.controller.processor.Processor;
import com.skobeev.exceptions.MyException;
import com.skobeev.service.DepartmentService;
import com.skobeev.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.constants.CommonConstants.ID;
import static com.skobeev.constants.ErrorConstants.ERROR;
import static com.skobeev.constants.ErrorConstants.PAGE_ERROR;
import static com.skobeev.constants.PathConstants.DEPARTMENTS;

public class DepartmentDelete implements Processor {

    private DepartmentService departmentService=new DepartmentServiceImpl();

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            departmentService.deleteDepartment(Long.parseLong(req.getParameter(ID)));
        } catch (MyException e) {
            req.setAttribute(ERROR,e.getError());
            req.getRequestDispatcher(PAGE_ERROR).forward(req,resp);
        }
        resp.sendRedirect(DEPARTMENTS);
    }
}
