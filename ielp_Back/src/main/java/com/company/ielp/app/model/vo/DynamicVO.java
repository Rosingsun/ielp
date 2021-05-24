package com.company.ielp.app.model.vo;

import com.company.ielp.app.model.entity.Dynamic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DynamicVO extends BaseVO {
    List<Dynamic> data;
}
