/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tambalbanservice.muhammadfauzi;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void simpan(OrderEntity order) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(order);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<OrderEntity> semua() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM OrderEntity o ORDER BY o.id DESC", OrderEntity.class).list();
        }
    }

    @Override
    public List<OrderEntity> cariByUser(int userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                "FROM OrderEntity o WHERE o.user.id = :uid ORDER BY o.id DESC", OrderEntity.class)
                .setParameter("uid", userId)
                .list();
        }
    }

    @Override
    public OrderEntity cariById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(OrderEntity.class, id);
        }
    }

    @Override
    public void ubah(OrderEntity order) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(order);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
