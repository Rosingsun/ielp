package com.company.ielp.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.TranslateCollectionMapper;
import com.company.ielp.app.mapper.TranslateHistoryMapper;
import com.company.ielp.app.model.translate.Translate;
import com.company.ielp.app.model.translate.TranslateCollection;
import com.company.ielp.app.service.TranslateCollectionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TranslateCollectionServiceImpl implements TranslateCollectionService {

    final TranslateCollectionMapper translateCollectionMapper;
    final TranslateHistoryMapper translateHistoryMapper;

    public TranslateCollectionServiceImpl(TranslateCollectionMapper translateCollectionMapper, TranslateHistoryMapper translateHistoryMapper) {
        this.translateCollectionMapper = translateCollectionMapper;
        this.translateHistoryMapper = translateHistoryMapper;
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
