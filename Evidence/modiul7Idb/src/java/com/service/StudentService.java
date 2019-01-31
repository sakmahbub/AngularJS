package com.service;

import com.entity.Student;

import com.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

    public void saveOrUpdate(Student student) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(student);
        System.out.println("Success");
        tr.commit();

    }

    public void delete(Student student) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.delete(student);
        System.out.println("Delete Success");
        tr.commit();

    }

    public static List<Student> getList() {
        List<Student> list = new ArrayList<>();
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            list=session.createQuery("FROM Student").list();
            
            tr.commit();
        } catch (Exception e) {
            System.out.println("Something Worng");
        }
        return list;
    }
}
