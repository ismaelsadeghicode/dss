package com.mapsa.dss.sales.dao;

import com.mapsa.dss.sales.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Product> findAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Product");
        List<Product> products = query.list();
        session.flush();
        return products;
    }

    @Override
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class,id);
        session.flush();
        return product;
    }

    @Override
    public void insertProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        session.flush();
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        session.flush();
    }

    @Override
    public void deleteProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
