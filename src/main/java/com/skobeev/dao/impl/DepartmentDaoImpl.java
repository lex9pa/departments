package com.skobeev.dao.impl;

import com.skobeev.dao.DepartmentDao;
import com.skobeev.dataBase.DataBaseWorker;
import com.skobeev.exceptions.MyException;
import com.skobeev.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.skobeev.constants.ErrorConstants.*;
import static com.skobeev.constants.QueryConstants.*;

public class DepartmentDaoImpl implements DepartmentDao {

    private Connection connection;

    public List<Department> listDepartments() throws MyException {
        List<Department> departments = new ArrayList<Department>();
        connection = DataBaseWorker.getConn();
        try {
            ResultSet rs = connection.createStatement().executeQuery(SELECT_ALL_DEPARTMENT_QUERY);
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getLong(1));
                department.setName(rs.getString(2));
                departments.add(department);
            }
        } catch (Exception e) {
            throw new MyException(SELECT_DEPARTMENT_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }
        return departments;
    }

    public void createDepartment(Department department) throws MyException {
        connection = DataBaseWorker.getConn();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_DEPARTMENT_QUERY);
            preparedStatement.setString(1, department.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new MyException(CREATE_DEPARTMENT_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }

    }

    public void updateDepartment(Department department) throws MyException {
        connection = DataBaseWorker.getConn();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_QUERY);
            preparedStatement.setString(1, department.getName());
            preparedStatement.setLong(2, department.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new MyException(UPDATE_DEPARTMENT_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }
    }

    public Department getDepartmentById(Long id) throws MyException {
        connection = DataBaseWorker.getConn();
        Department department = new Department();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_ID_QUERY);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                department.setId(rs.getLong(1));
                department.setName(rs.getString(2));
            }
        } catch (Exception e) {
            throw new MyException(GET_BY_DEPARTMENT_ERR);
        } finally {
            DataBaseWorker.connClose(connection);
        }
        return department;
    }

    public Department getDepartmentByName(String name) throws MyException {
        connection = DataBaseWorker.getConn();
        Department department = new Department();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(SELECT_DEPARTMENT_NAME_QUERY);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                department.setId(rs.getLong(1));
            }
        } catch (Exception e) {
            throw new MyException(GET_BY_DEPARTMENT_ERR);
        }
        return department;
    }
}

