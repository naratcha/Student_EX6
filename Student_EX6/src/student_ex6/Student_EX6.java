/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_ex6;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author naratcha.s
 */
public class Student_EX6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student stu1 = new Student(1, "Tossakorn", 3.99);
       Student stu2 = new Student(2, "Nirattisai", 3.99);
       Student stu3 = new Student(3, "Naratcha", 4.00);
       StudentTable.insertStudent(stu1);
       StudentTable.insertStudent(stu2);
       StudentTable.insertStudent(stu3);
       Student stu;
       stu = StudentTable.findStudentById(1);
       //if (stu != null) {
           //stu.setName("Poramet");
           //StudentTable.updateStudent(stu);
           //StudentTable.removeStudent(stu);
       //}
    }
    public static void persist(Object object) {
        EntityManagerFactory stf = Persistence.createEntityManagerFactory("Student_EX6PU");
        EntityManager st = stf.createEntityManager();
        st.getTransaction().begin();
        try {
            st.persist(object);
            st.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            st.getTransaction().rollback();
        } finally {
            st.close();
        }
    }
    
    
}
