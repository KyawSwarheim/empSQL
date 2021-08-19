package com.emp.mydb.Empdb.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="salary_id")
    private long salary_id;

    private String price;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "salary_id")
    private Set<Teacher> teacher;

    public Salary() {
    }

    public long getId() {
        return salary_id;
    }

    public void setId(long id) {
        this.salary_id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Set<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(Set<Teacher> teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Salary [id=" + salary_id + ", price=" + price + ", teacher=" + teacher + "]";
    }

}
