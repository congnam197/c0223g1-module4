package com.example.product_management.repository.impl;

import com.example.product_management.model.Product;
import com.example.product_management.repository.ConnectionUtils;
import com.example.product_management.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT = "from Product";
    private static final String FIND_PRODUCT_BY_ID = "from Product where id =:id";
    private static final String FIND_PRODUCT_BY_NAME = "from Product where name like concat('%',:name,'%')";
    private static final String FIND_ID_PRODUCT = "select id from Product";

    @Override
    public List<Product> findAll() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCT).getResultList();
    }

    @Override
    public void add(Product product) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            session.save(product);
            transactional.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(Integer id) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Product> productTypedQuery = session.createQuery(FIND_PRODUCT_BY_ID);
        productTypedQuery.setParameter("id", id);
        return productTypedQuery.getSingleResult();
    }


    @Override
    public void update(Integer id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(product);
            transaction.commit();
            ConnectionUtils.getEntityManager().clear();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(Integer id) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            Product product = findById(id);
            session.remove(product);
            transactional.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Product> productTypedQuery = session.createQuery(FIND_PRODUCT_BY_NAME);
        productTypedQuery.setParameter("name", name);
        return productTypedQuery.getResultList();
    }

    @Override
    public boolean checkId(Integer id) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Integer> integerTypedQuery = session.createQuery(FIND_ID_PRODUCT);
        List<Integer> list = integerTypedQuery.getResultList();
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }
}
