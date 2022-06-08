package ru.skypro;

import java.util.Objects;

public class Employee {

    private final int id;
    private static int counter;
    private final String middleName;
    private final String firstName;
    private final String lastName;
    private int department;
    private int salary;


    public Employee(String middleName, String firstName, String lastName, int department, int salary) {
        this.middleName = middleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    public int getId(){
        return id;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return middleName + " " + firstName + " " + lastName + " из отдела: " + department + " зарплата: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && salary == employee.salary && middleName.equals(employee.middleName) && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, middleName, firstName, lastName, department, salary);
    }
}