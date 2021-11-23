package com.mudongheng.ielp.mapper;

import com.mudongheng.ielp.model.entity.DynamicImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 幕冬
 * @since 2021年11月22日
 */
@Mapper
public interface DynamicImageMapper extends BaseMapper<DynamicImage> {

    List<Integer> listImageFileIdByDynamicId(Integer id);

}




