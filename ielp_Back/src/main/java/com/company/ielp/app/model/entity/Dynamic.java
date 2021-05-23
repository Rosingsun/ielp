package com.company.ielp.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户动态
 *
 * @author 幕冬儿
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Dynamic extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer history;
    private String info;
    private Integer like;
    private Integer comment;
    private Integer userId;

    public void addLike() {
        like += 1;
    }

    public void addComment() {
        comment += 1;
    }

}
