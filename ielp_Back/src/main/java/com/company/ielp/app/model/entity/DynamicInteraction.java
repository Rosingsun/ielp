package com.company.ielp.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 与的动态互动
 *
 * @author 幕冬儿
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DynamicInteraction extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Boolean isLike;
    private Boolean isComment;
    private String commentInfo;
    private Integer dynamicId;
    private Integer userId;

}
