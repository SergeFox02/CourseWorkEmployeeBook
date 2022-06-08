package ru.skypro;

import java.util.Arrays;

public class EmployeeBook {

    private final Employee [] employeeBook;

    public EmployeeBook(int length) {
        this.employeeBook = new Employee[length];
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] == null) {
                this.employeeBook[i] = employee;
                return true;
            }
        }
        System.out.println("Мы не можем принять нового сотрудника, у нас нет ваксансий.");
        return false;
    }

    public boolean deleteEmployee(String middleName, String firstName, String lastName, int id) {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i].getMiddleName().equals(middleName) && this.employeeBook[i].getFirstName().equals(firstName)
                    && this.employeeBook[i].getLastName().equals(lastName) && this.employeeBook[i].getId() == id) {
                this.employeeBook[i] = null;
                System.out.println("Струдник успешно удален из списка!");
                return true;
            }
        }
        System.out.println("Такого сотрудника нет в нашем списке!");
        return false;
    }

    public boolean deleteEmployee(String middleName, String firstName, String lastName) {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i].getMiddleName().equals(middleName) && this.employeeBook[i].getFirstName().equals(firstName)
                    && this.employeeBook[i].getLastName().equals(lastName)) {
                this.employeeBook[i] = null;
                System.out.println("Струдник успешно удален из списка!");
                return true;
            }
        }
        System.out.println("Такого сотрудника нет в нашем списке!");
        return false;
    }
    public boolean deleteEmployee(int id) {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i].getId() == id) {
                this.employeeBook[i] = null;
                System.out.println("Струдник успешно удален из списка!");
                return true;
            }
        }
        System.out.println("Такого сотрудника нет в нашем списке!");
        return false;
    }


    public void printEmployee() {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null){
                System.out.println("работник " + i + " = " + this.employeeBook[i]);
            }
        }
    }

    public int totalSalaryEmployees() {
        int sum = 0;
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null){
                sum += this.employeeBook[i].getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum + " руб.");
        return sum;
    }

    public int minSalaryEmployee() {
        if (this.employeeBook == null) {
            System.out.println("Список работников пуст! Невозможно вычислить минимальную зарплату!");
            return 0;
        }
        int minSalary = this.employeeBook[0].getSalary();
        int indexEmployee = 0;
        for (int i = 1; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getSalary() < minSalary){
                minSalary = this.employeeBook[i].getSalary();
                indexEmployee = i;
            }
        }
        System.out.println("Работник: " + this.employeeBook[indexEmployee] + " получает минимальную зарплату");
        return minSalary;
    }

    public int maxSalaryEmployee() {
        if (this.employeeBook == null) {
            System.out.println("Список работников пуст! Невозможно вычислить максимальную зарплату!");
            return 0;
        }
        int maxSalary = this.employeeBook[0].getSalary();
        int indexEmployee = 0;
        for (int i = 1; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getSalary() > maxSalary){
                maxSalary = this.employeeBook[i].getSalary();
                indexEmployee = i;
            }
        }
        System.out.println("Работник: " + this.employeeBook[indexEmployee] + " получает максимальную зарплату");
        return maxSalary;
    }

    public int mediumSalaryEmployee() {
        if (this.employeeBook == null) {
            System.out.println("Список работников пуст! Невозможно вычислить среднюю зарплату!");
            return 0;
        }
        int numberEmployee = 0;
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null){
                numberEmployee++;
            }
        }
        int mediumSalary = (int) totalSalaryEmployees() / numberEmployee;
        System.out.println("Средняя зарпалата: " + mediumSalary + " руб.");
        return mediumSalary;
    }

    public void printFullNameEmployees() {
        System.out.println("\nСписок всех сотрудников Ф.И.О:");
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null) {
                System.out.println(this.employeeBook[i].getMiddleName() + " " + this.employeeBook[i].getFirstName() + " " + this.employeeBook[i].getLastName());
            }
        }
    }

    public void indexSalaryAllEmployees(int percent) {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null) {
                this.employeeBook[i].setSalary((int) (this.employeeBook[i].getSalary() * (1f + percent / 100f)));
            }
        }
    }

    public Employee[] employeesDepartment (int department) {
        Employee[] employeeDepartment = new Employee[this.employeeBook.length];
        if (department < 0 || department > 5) {
            System.out.println("Не существует отдела с номером: " + department);
            return null;
        }
        int j = 0;
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getDepartment() == department) {
                employeeDepartment[j++] = this.employeeBook[i];
            }
        }
        if (employeeDepartment == null) {
            System.out.println("Список работников пуст! Никто не работает в отделе: " + department);
            return null;
        }
        return employeeDepartment;
    }

    public int minSalaryEmployeeOfDepartment(int department) {
        Employee[] employeeDepartment = employeesDepartment(department);
        if (employeeDepartment != null) {
            int minSalary = employeeDepartment[0].getSalary();
            for (int i = 1; i < employeeDepartment.length; i++) {
                if (employeeDepartment[i] != null && minSalary > employeeDepartment[i].getSalary()) {
                    minSalary = employeeDepartment[i].getSalary();
                }
            }
            System.out.println("Минимальная зарплата в отделе: " + department + " составила: " + minSalary);
            return minSalary;
        } else {
            System.out.println("Список работников пуст! Никто не работает в отделе: " + department);
            return 0;
        }
    }

    public int maxSalaryEmployeeOfDepartment(int department) {
        Employee[] employeeDepartment = employeesDepartment(department);
        if (employeeDepartment != null) {
            int maxSalary = employeeDepartment[0].getSalary();
            for (int i = 1; i < employeeDepartment.length; i++) {
                if (employeeDepartment[i] != null && maxSalary < employeeDepartment[i].getSalary()) {
                    maxSalary = employeeDepartment[i].getSalary();
                }
            }
            System.out.println("Максимальная зарплата в отделе: " + department + " составила: " + maxSalary);
            return maxSalary;
        } else {
            System.out.println("Список работников пуст! Никто не работает в отделе: " + department);
            return 0;
        }
    }

    public int totalSalaryOfDepartment(int department) {
        Employee[] employeeDepartment = employeesDepartment(department);
        if (employeeDepartment != null) {
            int sum = 0;
            for (int i = 0; i < employeeDepartment.length; i++) {
                if (employeeDepartment[i] != null) {
                    sum += employeeDepartment[i].getSalary();
                }
            }
            System.out.println("Общая зарплата в отделе: " + department + " составила: " + sum);
            return sum;
        } else {
            System.out.println("Список работников пуст! Никто не работает в отделе: " + department);
            return 0;
        }
    }

    public int mediumSalaryOfDepartment(int department) {
        Employee[] employeeDepartment = employeesDepartment(department);
        if (employeeDepartment == null) {
            System.out.println("В отделе " + department + " никто не работает! Невозможно вычислить среднюю зарплату! ");
            return 0;
        }
        int numberEmployee = 0;
        for (int i = 0; i < employeeDepartment.length; i++) {
            if (employeeDepartment[i] != null){
                numberEmployee++;
            }
        }
        int mediumSalary = (int) totalSalaryOfDepartment(department) / numberEmployee;
        System.out.println("Средняя зарпалата в отделе: " + department + " составила: " + mediumSalary + " руб.");
        return mediumSalary;
    }

    public void indexSalaryAllEmployeesOfDepartment(int department, int percent) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null && employeeBook[i].getDepartment() == department) {
                employeeBook[i].setSalary(employeeBook[i].getSalary()*(1 + percent / 100));
            }
        }
    }

    public void printDataOfEmployee(Employee employee) {
        System.out.println(employee.getId() + " " + employee.getMiddleName() + " " + employee.getFirstName() + " "
                + employee.getLastName() + " " + employee.getSalary());
    }

    public void printDataOfDepartment(int department) {
        System.out.println("\nДанные о сотрудниках в отделе номер: " + department);
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getDepartment() == department) {
                printDataOfEmployee(this.employeeBook[i]);
            }
        }
    }

    public void foundEmployeesLessOfSalary(int salary) {
        System.out.println("\nСписок сотрудников с зарплатой меньше: " + salary + " руб.");
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getSalary() < salary) {
                printDataOfEmployee(this.employeeBook[i]);
            }
        }
    }

    public void foundEmployeesMoreOfSalary(int salary) {
        System.out.println("\nСписок сотрудников с зарплатой больше: " + salary + " руб.");
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getSalary() > salary) {
                printDataOfEmployee(this.employeeBook[i]);
            }
        }
    }

    public boolean changeSalaryOfEmployee(String middleName, String firstName, String lastName, int newSalary) {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getMiddleName().equals(middleName)
                    && this.employeeBook[i].getFirstName().equals(firstName) && this.employeeBook[i].getLastName().equals(lastName)) {
                this.employeeBook[i].setSalary(newSalary);
                System.out.println("Зарплата изменена");
                return true;
            }
        }
        System.out.println("Такого работника у нас нет.");
        return false;
    }

    public boolean changeDepartmentOfEmployee(String middleName, String firstName, String lastName, int newDepartment) {
        for (int i = 0; i < this.employeeBook.length; i++) {
            if (this.employeeBook[i] != null && this.employeeBook[i].getMiddleName().equals(middleName)
                    && this.employeeBook[i].getFirstName().equals(firstName) && this.employeeBook[i].getLastName().equals(lastName)) {
                this.employeeBook[i].setDepartment(newDepartment);
                System.out.println("Сотрудник переведен в новый отдел");
                return true;
            }
        }
        System.out.println("Такого работника у нас нет.");
        return false;
    }

    public void printAllEmployeesByDepartment() {
        for (int i = 1; i < 6; i++) {
            System.out.println("\nСписок сторудников отдела: " + i);
            for (int j = 0; j < employeeBook.length; j++) {
                if (this.employeeBook[j] != null && this.employeeBook[j].getDepartment() == i) {
                    System.out.println(this.employeeBook[j].getMiddleName() + " " + this.employeeBook[j].getFirstName() + " "
                            + this.employeeBook[j].getLastName());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employeeBook=" + Arrays.toString(employeeBook) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Arrays.equals(employeeBook, that.employeeBook);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employeeBook);
    }
}