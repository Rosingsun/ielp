package com.company.ielp.app.service;

import com.company.ielp.app.model.translate.TranslateHistory;

import java.util.List;

public interface TranslateHistoryService {
    /**
     * 根据用户ID获取所有历史记录
     * @param userId 用户ID
     * @return 历史记录列表
     */
    List<TranslateHistory> getTranslateHistoryByUid(int userId);

    void translateWord(TranslateHistory translateHistory);


}
