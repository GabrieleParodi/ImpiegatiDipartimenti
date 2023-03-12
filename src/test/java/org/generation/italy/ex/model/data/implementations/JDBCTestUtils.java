package org.generation.italy.ex.model.data.implementations;

import org.generation.italy.ex.model.data.exceptions.DataException;
import org.generation.italy.ex.model.entities.Department;
import org.generation.italy.ex.model.entities.Employee;

import java.sql.*;
import java.util.Optional;

import static org.generation.italy.ex.model.data.implementations.TestConstants.*;

public class JDBCTestUtils {
    public static Optional<Department> findDepartmentById(long id, Connection con){
        try(PreparedStatement st = con.prepareStatement(FIND_DEPARTMENT_BY_ID)){
            st.setLong(1, id);
            try(ResultSet rs = st.executeQuery()){
                if(rs.next()){
                    return Optional.of(new Department(rs.getLong("id_department"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getInt("max_capacity")));
                }
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
