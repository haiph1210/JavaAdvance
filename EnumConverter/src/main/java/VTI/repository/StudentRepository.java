package VTI.repository;

import VTI.entity.Student;
import VTI.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;


public class StudentRepository {
    public List<Student> getAll() {
        try (Session session = HibernateUtils.openSeesion()) {
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            return (query).getResultList();
        }
    }

//    public Student getById(int id) {
//        try (Session session = HibernateUtils.openSeesion()) {
//            return ((org.hibernate.Session) session).get(Student.class, id);
//        }
//    }
//
//    public Student getByName(String name) {
//        try (Session session = HibernateUtils.openSeesion()) {
//            Query<Student> query = session.createQuery("FROM Student WHERE name = :name", Student.class);
//            query.setParameter("name", name);
//            return query.uniqueResult();
//        }
//    }

    public void create(Student student) {
        try (Session session = HibernateUtils.openSeesion()) {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        }
    }

//    public void update(Student student) {
//        try (Session session = HibernateUtils.openSession()) {
//            session.beginTransaction();
//            session.merge(student);
//            session.getTransaction().commit();
//        }
//    }
//
//    public void deleteById(int id) {
//        try (Session session = HibernateUtils.openSession()) {
//            session.beginTransaction();
//            Student old = session.get(Student.class, id);
//            session.remove(old);
//            session.getTransaction().commit();
//        }
//    }
//
//    public boolean existsById(int id) {
//        return getById(id) != null;
//    }
//
//    public boolean existsByName(String name) {
//        return getByName(name) != null;
//    }
}