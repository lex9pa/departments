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
import java.util.List;

import static com.skobeev.constants.CommonConstants.DEPARTMENT_LIST;
import static com.skobeev.constants.ErrorConstants.ERROR;
import static com.skobeev.constants.ErrorConstants.PAGE_ERROR;
import static com.skobeev.constants.PathConstants.PAGES_DEPARTMENTS_JSP;

public class DepartmentList implements Processor {

    private DepartmentService departmentService=new DepartmentServiceImpl();

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        List<Department> departments = null;
        try {
            departments = departmentService.getDepartmentsList();
        } catch (MyException e) {
            req.setAttribute(ERROR,e.getError());
            req.getRequestDispatcher(PAGE_ERROR).forward(req,resp);
        }
        req.setAttribute(DEPARTMENT_LIST, departments);
        req.getRequestDispatcher(PAGES_DEPARTMENTS_JSP).forward(req, resp);
    }
}
