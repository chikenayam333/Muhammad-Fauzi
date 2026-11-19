/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tambalbanservice.muhammadfauzi;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StikerDaoImpl implements StikerDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void simpan(StikerEntity stiker) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.persist(stiker);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<StikerEntity> semua() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM StikerEntity", StikerEntity.class).list();
        }
    }

    @Override
    public StikerEntity cariById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(StikerEntity.class, id);
        }
    }

    @Override
    public void ubah(StikerEntity stiker) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(stiker);
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
            StikerEntity stiker = session.get(StikerEntity.class, id);
            if (stiker != null) session.remove(stiker);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}