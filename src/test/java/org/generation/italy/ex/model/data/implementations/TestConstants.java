package org.generation.italy.ex.model.data.implementations;

import java.time.LocalDate;

public class TestConstants {
    public static final String NAME1 = "NAME1_TEST";
    public static final String NAME2 = "NAME2_TEST";
    public static final String ADDRESS1 = "ADDRESS1_TEST";
    public static final String ADDRESS2 = "ADDRESS2_TEST";
    public static final int MAX_CAPACITY1 = 100;
    public static final int MAX_CAPACITY2 = 1000;
    public static final String FIRSTNAME1 = "FIRSTNAME1_TEST";
    public static final String FIRSTNAME2 = "FIRSTNAME2_TEST";
    public static final String LASTNAME1 = "LASTNAME1_TEST";
    public static final String LASTNAME2 = "LASTNAME2_TEST";
    public static final LocalDate HIREDATE1 = LocalDate.now();
    public static final LocalDate HIREDATE2 = LocalDate.now().minusMonths(1);
    public static final String SEX1 = "M";
    public static final String SEX2 = "F";
    public static final String FIND_DEPARTMENT_BY_ID = """
            SELECT id_department, name, address, max_capacity
            FROM department
            WHERE id_department = ?
            """;

}
