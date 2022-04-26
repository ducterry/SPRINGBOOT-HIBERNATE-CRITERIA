package com.ndangducbn.hibernate.mapper;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.ndangducbn.hibernate.dto.request.CreateCustomerRq;
import com.ndangducbn.hibernate.entity.Customer;
import com.ndangducbn.hibernate.utils.DateUtils;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class CustomerMapper {
    public static Customer toEntity(CreateCustomerRq request) {
        Customer entity = new Customer();
        BeanUtils.copyProperties(request, entity);

        entity.setFullTextSearch(request.getAddress() + " " + request.getEmail() + " " + request.getPhone());
        entity.setCreatDate(DateUtils.toZoneDateTime(new Date().getTime()));
        entity.setCreateBy("ADMIM");

        return entity;
    }
}
