package com.mudongheng.ielp.api.mapper;

import com.mudongheng.ielp.api.model.entity.DynamicMusic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 幕冬
 * @since 2021年11月22日
 */
@Mapper
public interface DynamicMusicMapper extends BaseMapper<DynamicMusic> {

    Integer getMusicFileIdByDynamicId(Integer id);

}




