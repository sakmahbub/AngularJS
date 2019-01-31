package com.bean;

import com.entity.Student;
import com.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentBean {

    private StudentService service = new StudentService();
    private Student student;
    private List<Student> list;
    private String[] ccourse;

    public void save() {
        String cc = "";
        for (String s : ccourse) {
            cc += s + " ";

        }
        student.setCourse(cc);
        service.saveOrUpdate(student);

    }

    public void update() {
        String cc = "";
        for (String s : ccourse) {
            cc += s + " ";

        }
        student.setCourse(cc);
        service.saveOrUpdate(student);

    }

    public void dalete() {
        service.delete(student);

    }

    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();

        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getList() {
        list= new ArrayList<>();
        list=service.getList();
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public String[] getCcourse() {
        return ccourse;
    }

    public void setCcourse(String[] ccourse) {
        this.ccourse = ccourse;
    }
    public void reset(){
    student=new Student();
    }

}
