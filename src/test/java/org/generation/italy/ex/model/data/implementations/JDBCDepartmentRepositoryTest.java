package org.generation.italy.ex.model.data.implementations;

import org.generation.italy.ex.model.data.exceptions.DataException;
import org.generation.italy.ex.model.data.exceptions.EntityNotFoundException;
import org.generation.italy.ex.model.entities.Department;
import org.generation.italy.ex.model.entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;

import static org.generation.italy.ex.model.servicies.JDBCConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.generation.italy.ex.model.data.implementations.TestConstants.*;
import static org.generation.italy.ex.model.data.implementations.JDBCTestUtils.*;


class JDBCDepartmentRepositoryTest {
    private Department d1;
    private Department d2;
    private Employee e1;
    private Employee e2;
    private Connection con;
    private JDBCDepartmentRepository repo;
    @BeforeEach
    void setUp() throws SQLException {
        d1 = new Department(0,NAME1,ADDRESS1,MAX_CAPACITY1);
        d2 = new Department(0,NAME2,ADDRESS2,MAX_CAPACITY2, new HashSet<>());
        e1 = new Employee(0, FIRSTNAME1, LASTNAME1, HIREDATE1, SEX1, d2);
        e2 = new Employee(0, FIRSTNAME2, LASTNAME2, HIREDATE2, SEX2, d2);
        d2.addEmployee(e1);
        d2.addEmployee(e2);
        con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        con.setAutoCommit(false);
        repo = new JDBCDepartmentRepository(con);
    }

    @AfterEach
    void tearDown() {
        try{
            if(con != null){
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addDepartment() {
        try {
            Department department1 = repo.addDepartment(d1);
            Department department2 = repo.addDepartment(d2);
            assertNotEquals(d1.getId(), d2.getId());
            assertEquals(NAME1,department1.getName());
            assertEquals(ADDRESS1,department1.getAddress());
            assertEquals(MAX_CAPACITY1,department1.getMaxCapacity());
        } catch (DataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void deleteDepartment() {
        try {
            repo.addDepartment(d1);
            long id = d1.getId();
            assertTrue(findDepartmentById(id, con).isPresent());
            repo.deleteDepartment(d1.getId());
            assertFalse(findDepartmentById(id, con).isPresent());
        } catch (EntityNotFoundException | DataException e) {
            fail(e);
        }
    }

    @Test
    void findByName(){
        try {
            repo.addDepartment(d2);
            List<Employee> le = repo.findByName("ME2_T");
            assertTrue(le.isEmpty()); //C'È QUALCOSA CHE NON VA, NEL CORSO DELLA DOMENICA CERCO DI FIXARLO, SE CI RIESCO PIÙ AVANTI LO PUSHO SU GITHUB
            le.forEach(e -> assertEquals(d2.getId(), e.getDepartment().getId()));
        } catch (DataException e) {
            fail("errore",e);
        }

    }
}