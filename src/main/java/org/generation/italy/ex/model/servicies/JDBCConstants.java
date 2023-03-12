package org.generation.italy.ex.model.servicies;

public class JDBCConstants {
    public static final String URL = "jdbc:postgresql://localhost:5432/department";
    public static final String USER_NAME = "postgresMaster";
    public static final String PASSWORD = "goPostgresGo";
    public static final String INSERT_DEPARTMENT = """
            INSERT INTO department(id_department, name, address, max_capacity)
            VALUES(nextval('department_sequence'), ?, ?, ?)
            RETURNING id_department;
            """;
    public static final String DELETE_DEPARTMENT_BY_ID = """
            DELETE FROM department
            WHERE id_department = ?
            """;
    public static final String FIND_DEPARTMENT_BY_NAME = """
            SELECT id_department, d.name, d.address, d.max_capacity, e.id_employee,
                   e.firstname, e.lastname, e.hiredate, e.sex
            FROM department as d
            JOIN employee as e
            USING(id_department)
            WHERE name LIKE ?
            """;
}
