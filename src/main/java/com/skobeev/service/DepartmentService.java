package com.skobeev.service;

import com.skobeev.exceptions.MyException;
import com.skobeev.exceptions.ValidationException;
import com.skobeev.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartmentsList() throws MyException;

    void saveDepartment(Department department) throws MyException, ValidationException;

    void deleteDepartment(Long id) throws MyException;

    Department getDepartmentById(Long id) throws MyException;
}
