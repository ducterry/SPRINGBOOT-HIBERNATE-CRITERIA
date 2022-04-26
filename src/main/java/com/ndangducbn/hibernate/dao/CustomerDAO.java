package com.ndangducbn.hibernate.dao;

import com.ndangducbn.hibernate.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO {
    private final SessionFactory sessionFactory;

    public CustomerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> getListCustomer() {
        Criteria criteria = this.sessionFactory
                .getCurrentSession()
                .createCriteria(CustomerDAO.class);

        return criteria.list();
    }

    public Customer detailCustomer(String customerId) {
        Criteria criteria = this.sessionFactory
                .getCurrentSession()
                .createCriteria(CustomerDAO.class);

        criteria.add(Restrictions.eq("id", customerId));
        Object object = criteria.uniqueResult();

        if (object != null) {
            return (Customer) object;
        }
        return null;
    }
}
