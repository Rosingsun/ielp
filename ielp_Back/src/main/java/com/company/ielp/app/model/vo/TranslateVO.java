package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.dto.TranslateDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 翻译视图层
 * @author 幕冬
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TranslateVO extends BaseVO {
    private List<TranslateDTO> data;
}
