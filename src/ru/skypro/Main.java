package ru.skypro;

public class Main {

    public static void main(String[] args) {

        Employee employee[] = new Employee[10];

        employee[0] = new Employee("Ivanov", "Ivan", "Ivanovich", 1, 60_000 );
        employee[1] = new Employee("Peytorov", "Peytor", "Petrovich", 1, 65_000);
        employee[2] = new Employee("Alexandrov", "Alexandr", "Alexandrovich", 1, 50_000);
        employee[3] = new Employee("Krylova", "Nadegda", "Ivanovna", 2, 67_000);
        employee[4] = new Employee("Petrova", "Ekaterina", "Danilovna", 3, 100_000);
        employee[5] = new Employee("Sergeev", "Sergey", "Sergeevich", 4, 105_000);
        employee[6] = new Employee("Kononova", "Julia", "Alexandrpvna", 5, 110_000);
        employee[7] = new Employee("Danilova", "Anna", "Anatolievna", 2, 59_000);

        System.out.println(employee[0]);
        System.out.println(employee[2].getId());

        printEmployee(employee);
        totalSalaryEmployees(employee);
        minSalaryEmployee(employee);
        maxSalaryEmployee(employee);
        mediumSalaryEmployee(employee);
        printFullNameEmployees(employee);

        indexSalaryAllEmployees(employee, 8);
        totalSalaryEmployees(employee);

        System.out.println(employee[0].getSalary());

        Employee[] emp1 = employeesDepartment(employee, 1);
        System.out.println(emp1[0]);

        minSalaryEmployeeOfDepartment(employee, 1);
        maxSalaryEmployeeOfDepartment(employee, 1);
        totalSalaryEmployeesOfDepartment(employee, 1);
        mediumSalaryEmployeeOfDepartment(employee, 1);
        indexSalaryAllEmployeesOfDepartment(employee, 1, 10);

        System.out.println(employee[0].getSalary());
        printDataOfDepartment(employee, 2);

        foundEmployeesLessOfSalary(employee, 80_000);
        foundEmployeesMoreOfSalary(employee, 80_000);



    }

    public static void printEmployee(Employee[] employee) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null){
                System.out.println("employee = " + employee[i]);
            }
        }
    }

    public static int totalSalaryEmployees(Employee[] employee) {
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null){
                sum += employee[i].getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц: " + sum + " руб.");
        return sum;
    }

    public static int minSalaryEmployee(Employee[] employee) {
        if (employee == null) {
            System.out.println("Список работников пуст! Невозможно вычислить минимальную зарплату!");
            return 0;
        }
        int minSalary = employee[0].getSalary();
        int indexEmployee = 0;
        for (int i = 1; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < minSalary){
                minSalary = employee[i].getSalary();
                indexEmployee = i;
            }
        }
        System.out.println("Работник: " + employee[indexEmployee] + " получает минимальную зарплату");
        return minSalary;
    }

    public static int maxSalaryEmployee(Employee[] employee) {
        if (employee == null) {
            System.out.println("Список работников пуст! Невозможно вычислить максимальную зарплату!");
            return 0;
        }
        int maxSalary = employee[0].getSalary();
        int indexEmployee = 0;
        for (int i = 1; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > maxSalary){
                maxSalary = employee[i].getSalary();
                indexEmployee = i;
            }
        }
        System.out.println("Работник: " + employee[indexEmployee] + " получает максимальную зарплату");
        return maxSalary;
    }

    public static int mediumSalaryEmployee(Employee[] employee) {
        if (employee == null) {
            System.out.println("Список работников пуст! Невозможно вычислить среднюю зарплату!");
            return 0;
        }
        int numberEmployee = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null){
                numberEmployee++;
            }
        }
        int mediumSalary = (int) totalSalaryEmployees(employee) / numberEmployee;
        System.out.println("Средняя зарпалата: " + mediumSalary + " руб.");
        return mediumSalary;
    }

    public static void printFullNameEmployees(Employee[] employee) {
        System.out.println("Список всех сотрудников Ф.И.О:");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                printNameEmployee(employee[i]);
            }
        }
    }

    public static void printNameEmployee(Employee employee) {
        if (employee != null) {
            System.out.println(employee.getMiddleName() + " " + employee.getFirstName() + " " + employee.getLastName());
        }
    }

    public static void indexSalaryAllEmployees(Employee[] employee, int percent) {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                employee[i].setSalary((int) (employee[i].getSalary() * (1f + percent / 100f)));
            }
        }
    }

    public static Employee[] employeesDepartment (Employee[] employee, int department) {
        Employee[] employeeDepartment = new Employee[10];
        if (department < 0 || department > 5) {
            System.out.println("Не существует отдела с номером: " + department);
            return null;
        }
        int j = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getDepartment() == department) {
                employeeDepartment[j++] = employee[i];
            }
        }
        if (employeeDepartment == null) {
            System.out.println("Список работников пуст! Никто не работает в отделе: " + department);
            return null;
        }
        return employeeDepartment;
    }

    public static int minSalaryEmployeeOfDepartment(Employee[] employee, int department) {
        return minSalaryEmployee(employeesDepartment(employee, department));
    }

    public static int maxSalaryEmployeeOfDepartment(Employee[] employee, int department) {
        return maxSalaryEmployee(employeesDepartment(employee, department));
    }

    public static int totalSalaryEmployeesOfDepartment(Employee[] employee, int department) {
        return totalSalaryEmployees(employeesDepartment(employee, department));
    }

    public static int mediumSalaryEmployeeOfDepartment(Employee[] employee, int department) {
        return mediumSalaryEmployee(employeesDepartment(employee, department));
    }

    public static void indexSalaryAllEmployeesOfDepartment(Employee[] employee, int department, int percent) {
        indexSalaryAllEmployees(employeesDepartment(employee, department), percent);
    }

    public static void printDataOfEmployee(Employee employee) {
        if (employee != null) {
            System.out.println(employee.getId() + " " + employee.getMiddleName()
                    + " " + employee.getFirstName() + " " + employee.getLastName() + " "
                    + employee.getSalary());
        }
    }

    public static void printDataOfDepartment(Employee[] employee, int department) {
        System.out.println("Данные о сотрудниках в отделе номер: " + department);
        Employee[] employeeDepartment = employeesDepartment(employee, department);
        for (int i = 0; i < employeeDepartment.length; i++) {
            printDataOfEmployee(employeeDepartment[i]);
            }
    }

    public static void foundEmployeesLessOfSalary(Employee[] employee, int salary) {
        System.out.println("Список сотрудников с зарплатой меньше: " + salary + " руб.");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() < salary) {
                printDataOfEmployee(employee[i]);
            }
        }
    }

    public static void foundEmployeesMoreOfSalary(Employee[] employee, int salary) {
        System.out.println("Список сотрудников с зарплатой больше: " + salary + " руб.");
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null && employee[i].getSalary() > salary) {
                printDataOfEmployee(employee[i]);
            }
        }
    }
}
//    Создать дополнительные статические методы для решения следующих задач.
//
//        1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
//        2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
//        1. Сотрудника с минимальной зарплатой.
//        2. Сотрудника с максимальной зарплатой.
//        3. Сумму затрат на зарплату по отделу.
//        4. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
//        5. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
//        6. Напечатать всех сотрудников отдела (все данные, кроме отдела).
//        3. Получить в качестве параметра число и найти:
//        1. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
//        2. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).