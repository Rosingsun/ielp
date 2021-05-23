package com.company.ielp.app.service;

import com.company.ielp.app.model.dto.TranslateDTO;
import com.company.ielp.app.model.params.TranslateParam;

import java.util.List;

/**
 * 为翻译操作提供相关服务
 * @author 幕冬儿
 *
 */
public interface TranslateService {

    /**
     * 翻译记录传入
     * @param translateParam 翻译记录
     */
    TranslateDTO translateWord(TranslateParam translateParam);

    /**
     * 收藏单词
     * @param translateHistoryId 在历史记录中的id
     */
    TranslateDTO collectionWord(int translateHistoryId);

    /**
     * 通过用户ID获取收藏单词
     * @param userId 用户记录
     * @return 收藏列表
     */
    List<TranslateDTO> getCollectionsByUid(int userId);


    // 有一个功能是，通过单词获取图片，但目前考虑的是图片部署到哪里
    // 这个功能作为一个保留项目吧

}