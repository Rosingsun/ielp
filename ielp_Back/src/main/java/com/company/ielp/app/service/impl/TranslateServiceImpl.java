package com.company.ielp.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.TranslateCollectionMapper;
import com.company.ielp.app.mapper.TranslateHistoryMapper;
import com.company.ielp.app.model.translate.Translate;
import com.company.ielp.app.model.translate.TranslateCollection;
import com.company.ielp.app.model.translate.TranslateHistory;
import com.company.ielp.app.service.TranslateService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TranslateServiceImpl implements TranslateService {

    final TranslateHistoryMapper translateHistoryMapper;
    final TranslateCollectionMapper translateCollectionMapper;

    public TranslateServiceImpl(TranslateHistoryMapper translateHistoryMapper, TranslateCollectionMapper translateCollectionMapper) {
        this.translateHistoryMapper = translateHistoryMapper;
        this.translateCollectionMapper = translateCollectionMapper;
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

    @Override
    public TranslateCollection collectionWord(int translateHistoryId) {
        // 提取
        Translate select = translateHistoryMapper.selectById(translateHistoryId);
        // 赋值
        TranslateCollection newCollection = new TranslateCollection(select);
        // 插入
        newCollection.setCollectionTime(new Date());
        translateCollectionMapper.insert(newCollection);
        return newCollection;
    }

    @Override
    public List<TranslateCollection> getCollectionsByUid(int userId) {
        QueryWrapper<TranslateCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return translateCollectionMapper.selectList(queryWrapper);
    }
}
