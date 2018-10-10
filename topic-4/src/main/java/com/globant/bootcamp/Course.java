package com.globant.bootcamp;

public class Course {
    
    private int id;
    private String name;
    private Teacher teacher;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public Teacher getTeacher() {
        return this.teacher;
    }
}
