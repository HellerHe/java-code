package com.heller.iterator;

import org.junit.jupiter.api.Test;

public class UniversityTest {
    @Test
    public void test() {
        Department[] departments = new Department[2];
        departments[0] = new Department("计算机科学与技术", "计算机科学与技术");
        departments[1] = new Department("软件工程", "软件工程");
        ComputerCollege computerCollege = new ComputerCollege(departments);
        InfoColleage infoColleage = new InfoColleage(departments);
        College[] colleges = new College[2];
        colleges[0] = computerCollege;
        colleges[1] = infoColleage;
        University university = new University(colleges);
        university.printCollege();
    }
}