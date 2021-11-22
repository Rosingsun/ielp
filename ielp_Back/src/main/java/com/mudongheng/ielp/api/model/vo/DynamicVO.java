package com.mudongheng.ielp.api.model.vo;

import com.mudongheng.ielp.api.model.entity.Dynamic;
import lombok.Data;

import java.util.List;

/**
 * @author 幕冬
 * @since 2021年11月22日
 */
@Data
public class DynamicVO {

    private Dynamic dynamic;

    private List<Integer> imageIdList;

    private Integer musicId;

}
