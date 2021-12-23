package ru.skypro;

public class Main {

    public static void main(String[] args) {

        Employee employee[] = new Employee[10];

        employee[0] = new Employee("Ivanov", "Ivan", "Ivanovich", 1, 60_000 );
        employee[1] = new Employee("Peytorov", "Peytor", "Petrovich", 1, 65_000);
        employee[2] = new Employee("Alexandrov", "Alexandr", "Alexandrovich", 2, 78_000);
        employee[3] = new Employee("Krylova", "Nadegda", "Ivanovna", 2, 67_000);
        employee[4] = new Employee("Petrova", "Ekaterina", "Danilovna", 3, 100_000);
        employee[5] = new Employee("Sergeev", "Sergey", "Sergeevich", 4, 105_000);
        employee[6] = new Employee("Kononova", "Julia", "Alexandrpvna", 5, 110_000);
        employee[7] = new Employee("Danilova", "Anna", "Anatolievna", 2, 90_000);

        System.out.println(employee[0]);
        System.out.println(employee[2].getId());

        printEmployee(employee);
        totalSalaryEmployees(employee);
        minSalaryEmployee(employee);
        maxSalaryEmployee(employee);
        mediumSalaryEmployee(employee);
        printFullNameEmployees(employee);

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

    public static float mediumSalaryEmployee(Employee[] employee) {
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
        float mediumSalary = (float) totalSalaryEmployees(employee) / numberEmployee;
        System.out.println("Средняя зарпалата в нашей организации: " + mediumSalary + " руб.");
        return mediumSalary;
    }

    public static void printFullNameEmployees(Employee[] employee) {
        System.out.println("Список всех сотрудников Ф.И.Ф:");
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
}
