package com.emp.mydb.Empdb.request;

import java.io.Serializable;

public class TeacherRequest implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String subject;
    private String development;
    private long salary_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDevelopment() {
        return development;
    }

    public void setDevelopment(String development) {
        this.development = development;
    }

    public long getSalary_id() {
        return salary_id;
    }

    public void setSalary_id(int salary_id) {
        this.salary_id = salary_id;
    }

}
