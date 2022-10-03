package com.repository;


import com.entity.Group;
import com.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {
    public List<Group> getAll() {
        try (Session session = HibernateUtils.openSeesion()) {
            String hql = "FROM Group";
            Query<Group> query = session.createQuery(hql, Group.class);
            return query.getResultList();
        }
    }

    public Group getById(int id) {
        try (Session session = HibernateUtils.openSeesion()) {
            return session.get(Group.class, id);
        }
    }

    public void create(Group group) {
        try (Session session = HibernateUtils.openSeesion()) {
            session.beginTransaction();
            session.persist(group);
            session.getTransaction().commit();
        }
    }
}