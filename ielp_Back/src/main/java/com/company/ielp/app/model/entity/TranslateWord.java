package com.company.ielp.app.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 翻译单词
 * @author 幕冬儿
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TranslateWord extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String word;
    private String translation;
    private String picture_url;
    private String lyric;
    private Integer uid;
}
