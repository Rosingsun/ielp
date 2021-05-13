package com.company.ielp.app.service;

import com.company.ielp.app.model.translate.TranslateCollection;

import java.util.List;

/**
 * 为翻译操作提供相关服务，主要面向收藏记录
 * @author 幕冬儿
 * @see com.company.ielp.app.service.impl.TranslateCollectionServiceImpl
 */
public interface TranslateCollectionService {

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
