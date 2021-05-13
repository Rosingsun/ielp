package com.company.ielp.app.service;

import com.company.ielp.app.model.translate.TranslateCollection;

import java.util.List;

public interface TranslateCollectionService {

    /**
     * 收藏单词
     * @param translateHistoryId 在历史记录中的id
     */
    TranslateCollection collectionWord(int translateHistoryId);

    List<TranslateCollection> getCollectionsByUid(int userId);

}
