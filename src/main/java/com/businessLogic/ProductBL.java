package com.businessLogic;


import com.javaBean.Category;
import com.javaBean.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class ProductBL {

    private SessionFactory sessionFactory;

    public ProductBL(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    public List<Product> findAll() {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<Product> query = session.createQuery("select a from Product a ", Product.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Product> findAllByIdCategory(int id) {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<Product> query = session.createQuery("select a from Product a where a.category.id = :id", Product.class).setParameter("id", id);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Product> findAllByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<Product> query = session.createQuery("select a from Product a where a.title like concat('%',:title, '%')", Product.class).setParameter("title", title);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Product findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<Product> query = session.createQuery("select a from Product a where a.id = :id", Product.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
