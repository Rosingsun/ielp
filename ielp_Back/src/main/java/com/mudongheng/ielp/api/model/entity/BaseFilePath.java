package com.mudongheng.ielp.api.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年11月11日
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseFilePath extends BaseEntity {

    /**
     * 文件路径
     */
    protected String filePath;

}
