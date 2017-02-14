package com.skobeev.controller.processor.impl;

import com.skobeev.controller.processor.Processor;
import com.skobeev.exceptions.MyException;
import com.skobeev.model.Department;
import com.skobeev.service.DepartmentService;
import com.skobeev.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.constants.CommonConstants.*;
import static com.skobeev.constants.ErrorConstants.*;
import static com.skobeev.constants.PathConstants.*;

public class DepartmentForm implements Processor {

    private DepartmentService departmentService=new DepartmentServiceImpl();

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=(req.getParameter(ID));
        Department department = new Department();
        if (id != null) {
            try {
                department = departmentService.getDepartmentById(Long.parseLong(id));
            } catch (MyException e) {
                req.setAttribute(ERROR,e.getError());
                req.getRequestDispatcher(PAGE_ERROR).forward(req,resp);
            }
        }
        req.setAttribute(DEPARTMENT_LIST, department);
        req.getRequestDispatcher(PAGES_DEPARTMENT_EDIT_JSP).forward(req, resp);
    }
}
