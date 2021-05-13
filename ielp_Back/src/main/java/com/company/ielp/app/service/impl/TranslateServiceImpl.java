package com.company.ielp.app.service.impl;

import com.company.ielp.app.mapper.TranslateMapper;
import com.company.ielp.app.model.Translate;
import com.company.ielp.app.service.TranslateService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TranslateServiceImpl implements TranslateService {

    final TranslateMapper translateMapper;

    public TranslateServiceImpl(TranslateMapper translateMapper) {
        this.translateMapper = translateMapper;
    }

    @Override
    public List<Translate> getTranslateHistoryByUid(int userId) {
        return translateMapper.getTranslateHistoryByUid(1);
    }

    @Override
    public void translateWord(Translate translate) {
        // 插入历史记录
        translateMapper.insert(translate);
    }
}
