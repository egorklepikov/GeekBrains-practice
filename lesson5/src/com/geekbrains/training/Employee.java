package com.geekbrains.training;

public class Employee {
  private String fullName;
  private String jobTitle;
  private String email;
  private String phoneNumber;
  private int salary;
  private int age;

  public Employee(String fullName, String jobTitle, String email, String phoneNumber, int salary, int age) {
    this.fullName = fullName;
    this.jobTitle = jobTitle;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.salary = salary;
    this.age = age;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "fullName='" + fullName + '\'' +
        ", jobTitle='" + jobTitle + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", salary=" + salary +
        ", age=" + age +
        '}';
  }
}