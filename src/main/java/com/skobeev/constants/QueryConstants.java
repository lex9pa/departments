package com.skobeev.constants;

public class QueryConstants {

    public static final String INSERT_USER_QUERY = "Insert into users (firstName,lastName,mail,birthDay,salary,depId) values(?,?,?,?,?,?)";
    public static final String SELECT_ALL_USER_QUERY = "select * from users";
    public static final String UPDATE_USER_QUERY = "update users set firstName=? ,lastName=?,mail=?,birthDay=?,salary=?,depId=? where id=?";
    public static final String SELECT_USER_ID_QUERY = "select * from users where id=?";
    public static final String SELECT_USER_DEPARTMENT_ID_QUERY = "select * from users where depId=?";
    public static final String SELECT_USER_MAIL_QUERY = "select * from users where mail=?";
    public static final String DELETE_USER_QUERY = "delete from users where id=?";

    public static final String INSERT_DEPARTMENT_QUERY = "Insert into departments (name) values(?)";
    public static final String SELECT_ALL_DEPARTMENT_QUERY = "select * from departments";
    public static final String UPDATE_DEPARTMENT_QUERY = "update departments set name=? where id=?";
    public static final String SELECT_DEPARTMENT_ID_QUERY = "select * from departments where id=?";
    public static final String SELECT_DEPARTMENT_NAME_QUERY = "select * from departments where name=?";
    public static final String DELETE_DEPARTMENT_QUERY = "delete from departments where id=?";
}

