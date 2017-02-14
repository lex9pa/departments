package com.skobeev.util;

import com.skobeev.dao.DepartmentDao;
import com.skobeev.dao.impl.DepartmentDaoImpl;
import com.skobeev.exceptions.MyException;
import com.skobeev.model.Department;
import net.sf.oval.constraint.CheckWithCheck;

public class CheckDepName implements CheckWithCheck.SimpleCheck {

    public boolean isSatisfied(Object validatedObject, Object value) {

        DepartmentDao departmentDao = new DepartmentDaoImpl();
        Department department = null;
        if (validatedObject instanceof Department) {
            try {
                department = departmentDao.getDepartmentByName(value.toString());
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        return (department != null ? department.getId() : null) == null;
    }
}

