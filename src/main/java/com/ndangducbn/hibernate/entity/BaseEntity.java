package com.ndangducbn.hibernate.entity;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BaseEntity {
    private String createBy;
    private String modifiedBy;
    private ZonedDateTime creatDate;
    private ZonedDateTime modifiedDate;
}
