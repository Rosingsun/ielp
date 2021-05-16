package com.company.ielp.app.service;

import com.company.ielp.app.model.dto.TranslateDTO;
import com.company.ielp.app.model.entity.TranslateWordPicture;
import com.company.ielp.app.model.params.TranslateParam;
import org.springframework.web.multipart.MultipartFile;

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
    List<TranslateDTO> getTranslateHistoryByUid(int userId);

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

    /**
     * 传入词图关系，并将其存入数据库
     * 可以通过不断传入完善数据库
     * @param word 词语
     * @param picture 图片
     * @return 词图关系
     */
    TranslateWordPicture uploadWordPicture(String word, MultipartFile picture);

    // 有一个功能是，通过单词获取图片，但目前考虑的是图片部署到哪里
    // 这个功能作为一个保留项目吧

}
