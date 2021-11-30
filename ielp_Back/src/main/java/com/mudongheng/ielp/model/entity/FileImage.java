package com.mudongheng.ielp.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="file_image")
@EqualsAndHashCode(callSuper = true)
public class FileImage extends BaseFilePath {



}