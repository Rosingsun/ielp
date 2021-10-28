package com.mudongheng.ielp.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 幕冬
 * @since 2021年10月24日
 */
@Data
@TableName(value ="translate_history")
@EqualsAndHashCode(callSuper = true)
public class TranslateHistory extends BaseEntity {

    /**
     * 用户id（谁翻译的）
     */
    private Integer userId;

    /**
     * 翻译内容（我想翻译的内容）
     */
    private String translatedWord;

    /**
     * 是否收藏
     */
    private Boolean isCollection;

}