package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.entity.DynamicInteraction;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DynamicInteractionVO extends BaseVO {
    public DynamicInteractionVO() {

    }

    public DynamicInteractionVO(List<DynamicInteraction> data, String msg, Integer state) {
        super(msg, state);
        this.data = data;
    }

    private List<DynamicInteraction> data;
}
