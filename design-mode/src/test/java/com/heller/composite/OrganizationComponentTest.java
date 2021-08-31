package com.heller.composite;

import org.junit.jupiter.api.Test;

public class OrganizationComponentTest {
    @Test
    public void test() {
        University university = new University("普林斯顿", "大学");
        College college1 = new College("数学", "学院");
        College college2 = new College("计算机", "学院");
        Department department1 = new Department("应用数学", "专业");
        Department department2 = new Department("几何数学", "专业");
        Department department3 = new Department("计算机科学与技术", "专业");
        Department department4 = new Department("软件工程", "专业");

        college1.add(department1);
        college1.add(department2);
        college2.add(department3);
        college2.add(department4);
        college2.remove(department3);
        university.add(college1);
        university.add(college2);

        university.print();
    }
}