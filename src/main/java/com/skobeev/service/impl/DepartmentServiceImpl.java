package com.skobeev.service.impl;

import com.skobeev.dao.CommonDeleteDao;
import com.skobeev.dao.DepartmentDao;
import com.skobeev.dao.impl.CommonDeleteDaoImpl;
import com.skobeev.dao.impl.DepartmentDaoImpl;
import com.skobeev.exceptions.MyException;
import com.skobeev.exceptions.ValidationException;
import com.skobeev.model.Department;
import com.skobeev.service.DepartmentService;
import com.skobeev.util.ValidateModel;

import java.util.List;
import java.util.Map;

import static com.skobeev.constants.QueryConstants.DELETE_DEPARTMENT_QUERY;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();
    private ValidateModel validator = new ValidateModel();
    private CommonDeleteDao commonDeleteDao= new CommonDeleteDaoImpl();

    public List<Department> getDepartmentsList() throws MyException {
        return departmentDao.listDepartments();
    }

    public void saveDepartment(Department department) throws MyException, ValidationException {
        Map<String, List<String>> map = validator.validateModel(department);
        if (map.isEmpty()) {
            if (department.getId() == null) {
                departmentDao.createDepartment(department);
            } else {
                departmentDao.updateDepartment(department);
            }
        } else {
            throw new ValidationException(map);
        }
    }

    public void deleteDepartment(Long id) throws MyException {
        commonDeleteDao.delete(DELETE_DEPARTMENT_QUERY,id);
    }

    public Department getDepartmentById(Long id) throws MyException {
        return departmentDao.getDepartmentById(id);
    }
}
