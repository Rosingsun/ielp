package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="test_word")
@EqualsAndHashCode(callSuper = true)
public class TestWord extends BaseEntity {

}