package com.company.ielp.app.service;

import com.company.ielp.app.model.Translate;
import com.company.ielp.app.model.User;

import java.util.List;

public interface TranslateService {
    /**
     * 根据用户ID获取所有历史记录
     * @param userId 用户ID
     * @return 历史记录列表
     */
    List<Translate> getTranslateHistoryByUid(int userId);

    void translateWord(User user, String from, String to, String translatedWords);

}
