package com.company.ielp.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.TranslateHistoryMapper;
import com.company.ielp.app.model.translate.TranslateHistory;
import com.company.ielp.app.service.TranslateHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslateHistoryServiceImpl implements TranslateHistoryService {

    final TranslateHistoryMapper translateHistoryMapper;

    public TranslateHistoryServiceImpl(TranslateHistoryMapper translateHistoryMapper) {
        this.translateHistoryMapper = translateHistoryMapper;
    }

    @Override
    public List<TranslateHistory> getTranslateHistoryByUid(int userId) {
        QueryWrapper<TranslateHistory> queryWrapper = new QueryWrapper<>();
        // 需要使用数据库中的名称
        queryWrapper.eq("user_id", userId);
        return translateHistoryMapper.selectList(queryWrapper);
    }

    @Override
    public void translateWord(TranslateHistory translateHistory) {
        // 插入历史记录
        translateHistoryMapper.insert(translateHistory);
    }
}
