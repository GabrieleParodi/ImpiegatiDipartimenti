package org.generation.italy.ex.model.data.implementations;

import org.generation.italy.ex.model.data.abstractions.DepartmentRepository;
import org.generation.italy.ex.model.data.exceptions.DataException;
import org.generation.italy.ex.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.ex.model.entities.Department;
import org.generation.italy.ex.model.entities.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.generation.italy.ex.model.servicies.JDBCConstants.*;

public class JDBCDepartmentRepository implements DepartmentRepository {
    private Connection con;
    public JDBCDepartmentRepository(Connection con){
        this.con = con;
    }

    @Override
    public Department addDepartment(Department department) throws DataException{
        try(PreparedStatement st = con.prepareStatement(INSERT_DEPARTMENT, Statement.RETURN_GENERATED_KEYS))
        {
           st.setString(1, department.getName());
           st.setString(2, department.getAddress());
           st.setInt(3, department.getMaxCapacity());
           st.executeUpdate();
           try(ResultSet keys = st.getGeneratedKeys()){
               keys.next();
               long key = keys.getLong(1);
               department.setId(key);
               return department;
           }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("Errore nell'aggiunta del dipartimento", e);
        }
    }

    @Override
    public void deleteDepartment(Long id) throws EntityNotFoundException, DataException{
        try (PreparedStatement st = con.prepareStatement(DELETE_DEPARTMENT_BY_ID)) {
            st.setLong(1, id);
            int numLines = st.executeUpdate();
            if(numLines != 1){
                throw new EntityNotFoundException("Non è stato trovato un dipartimento con quel id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataException("Errore nella lettura dei dipartimenti",e);
        }
    }

    @Override
    public List<Employee> findByName(String part) throws DataException{
        try(PreparedStatement st = con.prepareStatement(FIND_DEPARTMENT_BY_NAME)){
            st.setString(1, "%" + part + "%");
            try(ResultSet rs = st.executeQuery()){
                List<Employee> el = new ArrayList<>();
                while(rs.next()){
                    el.add(new Employee(rs.getLong("id_employee"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getDate("hiredate").toLocalDate(),
                            rs.getString("sex")));
                }
                return el;
            }
        } catch (SQLException e) {
            throw new DataException("Errore nella lettura dei dipartimenti",e);
        }
    }
}
