package org.generation.italy.ex.model.data.abstractions;

import org.generation.italy.ex.model.data.exceptions.DataException;
import org.generation.italy.ex.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.ex.model.entities.Department;
import org.generation.italy.ex.model.entities.Employee;

import java.util.List;

public interface DepartmentRepository {
    Department addDepartment(Department department) throws DataException;
    void deleteDepartment(Long id)throws DataException, EntityNotFoundException;
    List<Employee> findByName(String part)throws DataException;
}
