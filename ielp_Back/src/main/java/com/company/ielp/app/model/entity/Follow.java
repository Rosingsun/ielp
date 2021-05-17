package com.company.ielp.app.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Follow extends BaseEntity {
    int id;
    int u1;
    int u2;
}