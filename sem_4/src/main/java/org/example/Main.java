package org.example;

import java.util.List;

import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/*
Задание: Настройте связь между вашим приложением и базой данных MySQL с использованием Hibernate.
Создайте несколько объектов Person и сохраните их в базу данных.
 */
public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();
            Student student4 = new Student("Kristi", "Bu", 33);
            session.save(student4);
            Student student5 = new Student("Michail", "Run", 39);
            session.save(student5);
            System.out.println("Student saved successfully");

            Student rStudent = session.get(Student.class, student4.getId());
            System.out.println("Student retrieved successfully");
            System.out.println(rStudent);

            rStudent.setName("Kristi");
            rStudent.setSurname("Bu");
            rStudent.setAge(33);
            session.update(rStudent);
            System.out.println("Student updated successfully");

            // HQL-запрос для получения всех записей из таблицы
            String hql = "FROM Student"; 
            Query<Student> query = session.createQuery(hql, Student.class);
            List<Student> resultList = query.getResultList();
            
            // Вывод всех записей в терминал
            for (Student student : resultList) {
                System.out.println(student);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
        }
    }
}