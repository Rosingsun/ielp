package com.company.ielp.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.company.ielp.app.model.dto.TranslateDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户收藏
 * @author 幕冬儿
 * @see TranslateDTO
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TranslateCollection extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private String languageFrom;
    private String languageTo;
    private String translatedWords;
    private String picUrl;
    private Integer userId;
}
