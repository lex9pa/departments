package com.skobeev.controller.processor;

import com.skobeev.exceptions.MyException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Processor {
    void method(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, MyException;
}

