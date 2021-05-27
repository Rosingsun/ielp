package com.company.ielp.app.model.dto;

import com.company.ielp.app.model.entity.Dynamic;
import com.company.ielp.app.model.entity.DynamicInteraction;
import com.company.ielp.app.model.entity.TranslateHistory;
import lombok.Data;

import java.util.List;

/**
 * 动态信息类，包含一条动态与它的评论们
 *
 * @author 幕冬儿
 * @see TranslateHistory
 */
@Data
public class DynamicDTO {

    public DynamicDTO(Dynamic dynamic) {
        this.dynamic = dynamic;
    }

    public DynamicDTO(Dynamic dynamic, List<DynamicInteraction> list) {
        this.dynamic = dynamic;
        this.list = list;
    }

    private Dynamic dynamic;

    private List<DynamicInteraction> list;

}
