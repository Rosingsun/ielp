package com.mudongheng.ielp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年11月22日
 */
@Data
@TableName(value ="dynamic_music")
@EqualsAndHashCode(callSuper = true)
public class DynamicMusic extends BaseEntity {

    /**
     * 动态id
     */
    private Integer dynamicId;

    /**
     * 音乐文件id
     */
    private Integer fileMusicId;

}