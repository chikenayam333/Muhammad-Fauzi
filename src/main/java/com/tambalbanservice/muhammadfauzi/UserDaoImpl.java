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


/**
 *
 * @author user
 */
@Repository
public class UserDaoImpl implements UserDao {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public void simpan(UserEntity user) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<UserEntity> semua() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM UserEntity", UserEntity.class).list();
        }
    }

    @Override
    public UserEntity cariById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(UserEntity.class, id);
        }
    }

    @Override
    public void ubah(UserEntity user) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void hapus(int id) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            UserEntity user = session.get(UserEntity.class, id);
            if (user != null) session.remove(user);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public boolean cekUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Long jumlah = session.createQuery(
                "SELECT COUNT(u) FROM UserEntity u WHERE u.username = :uname", Long.class)
                .setParameter("uname", username)
                .uniqueResult();
            return jumlah > 0;
        }
    }

    @Override
    public UserEntity login(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery(
                "FROM UserEntity u WHERE u.username = :uname AND u.password = :pass", UserEntity.class)
                .setParameter("uname", username)
                .setParameter("pass", password)
                .uniqueResult();
        }
    }
    
}
