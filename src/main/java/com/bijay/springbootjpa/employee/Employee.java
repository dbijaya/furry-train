package com.bijay.springbootjpa.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {

    @Id
    private Long id;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer age;
    private String designation;
    private double salary;
    private Date dateOfJoining;

    public Employee() {
        super();
    }

    public Employee(Long id, String firstName, String lastName, Date dateOfBirth, Integer age,
                    String designation, double salary, Date dateOfJoining) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
