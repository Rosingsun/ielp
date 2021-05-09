package com.company.ielp.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.ielp.app.model.Translate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TranslateMapper extends BaseMapper<Translate> {

    List<Translate> getTranslateHistoryByUid(int userId);

}
