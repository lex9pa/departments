package com.skobeev.dao;

import com.skobeev.exceptions.MyException;

public interface CommonDeleteDao {

    void delete(String query, Long id) throws MyException;

}
