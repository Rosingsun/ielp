package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.dto.DynamicDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DynamicVO extends BaseVO {
    public DynamicVO() {

    }

    public DynamicVO(List<DynamicDTO> data, String msg, Integer state) {
        super(msg, state);
        this.data = data;
    }

    private List<DynamicDTO> data;
}
