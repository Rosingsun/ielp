package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="test_read")
@EqualsAndHashCode(callSuper = true)
public class TestRead extends BaseEntity {

}