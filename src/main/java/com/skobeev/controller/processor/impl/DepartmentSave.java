package com.skobeev.controller.processor.impl;

import com.skobeev.controller.processor.Processor;
import com.skobeev.exceptions.MyException;
import com.skobeev.exceptions.ValidationException;
import com.skobeev.model.Department;
import com.skobeev.service.DepartmentService;
import com.skobeev.service.impl.DepartmentServiceImpl;
import com.skobeev.util.Transformer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.constants.CommonConstants.DEPARTMENT_LIST;
import static com.skobeev.constants.ErrorConstants.*;
import static com.skobeev.constants.PathConstants.*;

public class DepartmentSave implements Processor {

    private DepartmentService departmentService=new DepartmentServiceImpl();

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department department = Transformer.getDepartment(req);
        try {
            departmentService.saveDepartment(department);
            resp.sendRedirect(DEPARTMENTS);
        } catch (MyException e) {
            req.setAttribute(ERROR,e.getError());
            req.getRequestDispatcher(PAGE_ERROR).forward(req,resp);
        } catch (ValidationException e) {
            req.setAttribute(ERROR,e.getError());
            req.setAttribute(DEPARTMENT_LIST, department);
            req.getRequestDispatcher(PAGES_DEPARTMENT_EDIT_JSP).forward(req, resp);
        }
    }
}