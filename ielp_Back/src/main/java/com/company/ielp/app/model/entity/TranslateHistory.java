package com.company.ielp.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.company.ielp.app.model.dto.TranslateDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 翻译历史记录
 * @author 幕冬儿
 * @see TranslateDTO
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TranslateHistory extends BaseEntity {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private String languageFrom;
    private String languageTo;
    private String translatedWord;
    private String picUrl;
    private Integer userId;
    private Boolean isCollection = false;
}