package com.skobeev.dao;

import com.skobeev.exceptions.MyException;
import com.skobeev.model.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> listDepartments()throws MyException;

    void createDepartment(Department department)throws MyException;

    void updateDepartment(Department department)throws MyException;

    Department getDepartmentById(Long id)throws MyException;

    Department getDepartmentByName(String name)throws MyException;
}
