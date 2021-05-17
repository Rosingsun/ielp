package com.company.ielp.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Follow extends BaseEntity {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer u1;
    private Integer u2;
}