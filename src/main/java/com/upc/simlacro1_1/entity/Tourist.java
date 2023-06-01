package com.upc.simlacro1_1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private Integer dni;
    private Integer age;
    private String status;
    private  Integer salary;
    private String bag;

    public Tourist() {
    }

    public Tourist(Long id, String name, Integer dni, Integer age, String status, Integer salary, String bag) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.age = age;
        this.status = status;
        this.salary = salary;
        this.bag = bag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getBag() {
        return bag;
    }

    public void setBag(String bag) {
        this.bag = bag;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dni=" + dni +
                ", age=" + age +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                ", bag='" + bag + '\'' +
                '}';
    }
}
