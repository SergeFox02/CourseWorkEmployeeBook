package ru.skypro;

public class Main {

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.addEmployee(new Employee("Ivanov", "Ivan", "Ivanovich", 1, 60_000));
        employeeBook.addEmployee(new Employee("Peytorov", "Peytor", "Petrovich", 1, 65_000));
        employeeBook.addEmployee(new Employee("Alexandrov", "Alexandr", "Alexandrovich", 1, 50_000));
        employeeBook.addEmployee(new Employee("Krylova", "Nadegda", "Ivanovna", 2, 67_000));
        employeeBook.addEmployee(new Employee("Petrova", "Ekaterina", "Danilovna", 3, 100_000));
        employeeBook.addEmployee(new Employee("Sergeev", "Sergey", "Sergeevich", 4, 105_000));
        employeeBook.addEmployee(new Employee("Kononova", "Julia", "Alexandrpvna", 5, 110_000));
        employeeBook.addEmployee(new Employee("Danilova", "Anna", "Anatolievna", 2, 59_000));

        employeeBook.printEmployee();
        employeeBook.totalSalaryEmployees();
        employeeBook.minSalaryEmployee();
        employeeBook.maxSalaryEmployee();
        employeeBook.mediumSalaryEmployee();
        employeeBook.printFullNameEmployees();
        employeeBook.indexSalaryAllEmployees(11);
        employeeBook.minSalaryEmployeeOfDepartment(1);
        employeeBook.maxSalaryEmployeeOfDepartment(1);
        employeeBook.totalSalaryOfDepartment(1);
        employeeBook.mediumSalaryOfDepartment(1);
        employeeBook.indexSalaryAllEmployeesOfDepartment(1, 11);
        employeeBook.printDataOfDepartment(1);
        employeeBook.foundEmployeesLessOfSalary(80_000);
        employeeBook.foundEmployeesMoreOfSalary(80_000);
        employeeBook.addEmployee(new Employee("Bystrov", "Oleg", "Anatolievich", 2, 81_000));
        employeeBook.addEmployee(new Employee("Viktorova", "Olga", "Viktorovna", 2, 85_000));
        employeeBook.deleteEmployee(1);
        employeeBook.printDataOfDepartment(1);
        employeeBook.changeSalaryOfEmployee("Ivanov", "Ivan", "Ivanovich", 80_000);
        employeeBook.changeDepartmentOfEmployee("Viktorova", "Olga", "Viktorovna", 1);
        employeeBook.printDataOfDepartment(1);
        employeeBook.printAllEmployeesByDepartment();
    }
}