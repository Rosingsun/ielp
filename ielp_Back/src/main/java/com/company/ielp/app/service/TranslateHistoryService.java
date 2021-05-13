package com.company.ielp.app.service;

import com.company.ielp.app.model.translate.TranslateHistory;

import java.util.List;

/**
 * 为翻译操作提供相关服务，主要面向翻译历史记录
 * @author 幕冬儿
 * @see com.company.ielp.app.service.impl.TranslateHistoryServiceImpl
 */
public interface TranslateHistoryService {
    /**
     * 根据用户ID获取所有历史记录
     * @param userId 用户ID
     * @return 历史记录列表
     */
    List<TranslateHistory> getTranslateHistoryByUid(int userId);

    /**
     * 翻译记录传入
     * @param translateHistory 翻译记录
     */
    void translateWord(TranslateHistory translateHistory);


}
