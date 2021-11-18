package com.mudongheng.ielp.api.model.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="file_music")
@EqualsAndHashCode(callSuper = true)
public class FileMusic extends BaseEntity {

    /**
     * 文件路径
     */
    private String filePath;

}