package com.company.ielp.app.service.impl;

import com.company.ielp.app.mapper.TranslateMapper;
import com.company.ielp.app.model.Translate;
import com.company.ielp.app.model.User;
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
    public void translateWord(User user, String from, String to, String translatedWords) {
        Translate translate = new Translate();

        // 将一些数据放入
        translate.setLanguageFrom(from);
        translate.setLanguageTo(to);

        translate.setTranslatedWords(translatedWords);
        translate.setTranslatedTime(new Date());

        translate.setPicUrl("");
        translate.setUserId(user.getId());

        // 插入历史记录
        translateMapper.insert(translate);
    }
}
