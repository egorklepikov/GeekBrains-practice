package com.geekbrains.training;

public class Main {
  public static void main(String[] args) {
    Employee[] employees = new Employee[5];
    employees[0] = new Employee(
        "Egor Ivanov",
        "Support Engineer",
        "somemail@gmail.com",
        "+79139999999",
        120000, 30
    );
    employees[1] = new Employee(
        "Ivan Ivanov",
        "Software Engineer",
        "somemail@gmail.com",
        "+12329999999",
        130000,
        45
    );
    employees[2] = new Employee(
        "Petr Ivanov",
        "Software Engineer",
        "somemail@gmail.com",
        "+79139999999",
        170000,
        55
    );
    employees[3] = new Employee(
        "Alexey Ivanov",
        "Software Engineer",
        "somemail@gmail.com",
        "+79139999999",
        120000,
        52
    );
    employees[4] = new Employee(
        "Andrey Ivanov",
        "QA Engineer",
        "somemail@gmail.com",
        "+79139999999",
        110000,
        21
    );

    findEmployeesByAge(employees);
  }

  private static void findEmployeesByAge(Employee[] employees) {
    for (Employee employee : employees) {
      if (employee.getAge() > 40) {
        System.out.println(employee);
      }
    }
  }
}