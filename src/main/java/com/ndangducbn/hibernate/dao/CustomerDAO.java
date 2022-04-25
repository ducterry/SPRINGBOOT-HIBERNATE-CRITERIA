package com.ndangducbn.hibernate.dao;

import com.ndangducbn.hibernate.entity.Customer;
import org.hibernate.Criteria;

import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer> {

    public List<Customer> getListCustomer() {
        Criteria criteria = this.getCriteria();

        return criteria.list();
    }
}
