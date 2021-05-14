package com.company.ielp.app.service;

import com.company.ielp.app.model.translate.TranslateCollection;
import com.company.ielp.app.model.translate.TranslateHistory;

import java.util.List;

/**
 * 为翻译操作提供相关服务
 * @author 幕冬儿
 *
 */
public interface TranslateService {

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

    /**
     * 收藏单词
     * @param translateHistoryId 在历史记录中的id
     */
    TranslateCollection collectionWord(int translateHistoryId);

    /**
     * 通过用户ID获取收藏单词
     * @param userId 用户记录
     * @return 收藏列表
     */
    List<TranslateCollection> getCollectionsByUid(int userId);

}
