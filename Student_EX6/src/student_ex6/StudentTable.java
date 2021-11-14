/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_ex6;

import student_ex6.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author naratcha.s
 */
public class StudentTable {
    public static void insertStudent(Student stu) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("Student_EX6PU");
        EntityManager st = stf.createEntityManager();
        st.getTransaction().begin();
        try {
            st.persist(stu);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
    }
    public static void updateStudent(Student stu) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("Student_EX6PU");
        EntityManager st = stf.createEntityManager();
        Student fromDb = st.find(Student.class, stu.getId());
        fromDb.setName(stu.getName());
        fromDb.setGpa(stu.getGpa());
        st.getTransaction().begin();
        try {
            st.persist(fromDb);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
    }
    public static Student findStudentById(Integer id) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("Student_EX6PU");
        EntityManager st = stf.createEntityManager();
        Student stu = st.find(Student.class, id);
        st.close();
        return stu;
    }
    public static void removeStudent(Student stu) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("Student_EX6PU");
        EntityManager st = stf.createEntityManager();
        Student fromDb = st.find(Student.class, stu.getId());
        st.getTransaction().begin();
        try {
            st.remove(fromDb);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
                
    }
}
