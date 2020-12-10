package com.wt.myspringcloud.common.base;

import java.util.Arrays;

/**
 * Employee
 */
public class Employee implements Comparable<Employee> {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("One", 100);
        staff[1] = new Employee("Two", 200);
        staff[2] = new Employee("Three", 300);

        Arrays.sort(staff);
        for (Employee e : staff) {
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
        }
    }

}