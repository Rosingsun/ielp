package com.mudongheng.ielp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年11月22日
 */
@Data
@TableName(value ="dynamic_image")
@EqualsAndHashCode(callSuper = true)
public class DynamicImage extends BaseEntity {

    /**
     * 动态id
     */
    private Integer dynamicId;

    /**
     * 文件id
     */
    private Integer fileImageId;

}