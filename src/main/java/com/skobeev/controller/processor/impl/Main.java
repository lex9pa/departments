package com.skobeev.controller.processor.impl;

import com.skobeev.controller.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.skobeev.constants.PathConstants.PAGES_MAIN_JSP;

public class Main implements Processor {

    public void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(PAGES_MAIN_JSP).forward(req, resp);
    }
}
