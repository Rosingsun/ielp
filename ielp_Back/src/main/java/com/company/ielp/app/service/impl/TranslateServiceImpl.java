package com.company.ielp.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.TranslateCollectionMapper;
import com.company.ielp.app.mapper.TranslateHistoryMapper;
import com.company.ielp.app.mapper.TranslateWordPictureMapper;
import com.company.ielp.app.model.translate.Translate;
import com.company.ielp.app.model.translate.TranslateCollection;
import com.company.ielp.app.model.translate.TranslateHistory;
import com.company.ielp.app.model.translate.TranslateWordPicture;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.utils.PictureFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TranslateServiceImpl implements TranslateService {

    private final static String PATH_NAME = "D:\\缓存\\ielp\\pictureUrl\\";

    final TranslateHistoryMapper translateHistoryMapper;
    final TranslateCollectionMapper translateCollectionMapper;
    final TranslateWordPictureMapper translateWordPictureMapper;

    public TranslateServiceImpl(TranslateHistoryMapper translateHistoryMapper, TranslateCollectionMapper translateCollectionMapper, TranslateWordPictureMapper translateWordPictureMapper) {
        this.translateHistoryMapper = translateHistoryMapper;
        this.translateCollectionMapper = translateCollectionMapper;
        this.translateWordPictureMapper = translateWordPictureMapper;
    }

    @Override
    public List<TranslateHistory> getTranslateHistoryByUid(int userId) {
        QueryWrapper<TranslateHistory> queryWrapper = new QueryWrapper<>();
        // 需要使用数据库中的名称
        queryWrapper.eq("user_id", userId);
        return translateHistoryMapper.selectList(queryWrapper);
    }

    @Override
    public void translateWord(TranslateHistory translateHistory) {
        // 插入历史记录
        translateHistoryMapper.insert(translateHistory);
    }

    @Override
    public TranslateCollection collectionWord(int translateHistoryId) {
        // 提取
        Translate select = translateHistoryMapper.selectById(translateHistoryId);
        // 赋值
        TranslateCollection newCollection = new TranslateCollection(select);
        // 插入
        newCollection.setCollectionTime(new Date());
        translateCollectionMapper.insert(newCollection);
        return newCollection;
    }

    @Override
    public List<TranslateCollection> getCollectionsByUid(int userId) {
        QueryWrapper<TranslateCollection> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return translateCollectionMapper.selectList(queryWrapper);
    }

    @Override
    public TranslateWordPicture uploadWordPicture(String word, MultipartFile picture) {

        TranslateWordPicture translateWordPicture = new TranslateWordPicture();

        log.info("存入词图关系：{} <-> {}", picture.getOriginalFilename(), word);

        if (!picture.isEmpty()) {
            String originalFilename = picture.getOriginalFilename();
            try {
                assert originalFilename != null;
                String s = PictureFormatUtil.picFormat(originalFilename);
                String path = PATH_NAME + word + s;
                // 上传图片
                picture.transferTo(new File(path));
                translateWordPicture.setWord(word);
                translateWordPicture.setPictureUrl(path);
                // 记录
                translateWordPictureMapper.insert(translateWordPicture);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return translateWordPicture;
    }
}
