package com.company.ielp.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.TranslateHistoryMapper;
import com.company.ielp.app.mapper.TranslateWordPictureMapper;
import com.company.ielp.app.model.dto.TranslateDTO;
import com.company.ielp.app.model.entity.TranslateHistory;
import com.company.ielp.app.model.entity.TranslateWordPicture;
import com.company.ielp.app.model.params.TranslateParam;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.utils.PictureFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TranslateServiceImpl implements TranslateService {

    private final static String PATH_NAME = "D:\\缓存\\ielp\\pictureUrl\\";

    final TranslateHistoryMapper translateHistoryMapper;
    final TranslateWordPictureMapper translateWordPictureMapper;

    public TranslateServiceImpl(TranslateHistoryMapper translateHistoryMapper, TranslateWordPictureMapper translateWordPictureMapper) {
        this.translateHistoryMapper = translateHistoryMapper;
        this.translateWordPictureMapper = translateWordPictureMapper;
    }

    private List<TranslateDTO> toTranslateDTOList(List<TranslateHistory> histories) {
        List<TranslateDTO> list = new ArrayList<>();
        // 在对付大数据的时候这个真的有必要吗？
        // 值得考虑
        for (TranslateHistory history : histories) {
            TranslateDTO dto;
            BeanUtils.copyProperties(history, dto = new TranslateDTO());
            list.add(dto);
        }
        return list;
    }

    @Override
    public List<TranslateDTO> getTranslateHistoryByUid(int userId) {
        QueryWrapper<TranslateHistory> queryWrapper = new QueryWrapper<>();
        // 需要使用数据库中的名称
        queryWrapper.eq("user_id", userId);

        return toTranslateDTOList(translateHistoryMapper.selectList(queryWrapper));
    }

    @Override
    public TranslateDTO translateWord(TranslateParam translateParam) {
        TranslateHistory history = new TranslateHistory();
        TranslateDTO translateDTO = new TranslateDTO();
        // 插入历史记录
        BeanUtils.copyProperties(translateParam, history);
        translateHistoryMapper.insert(history);

        // 转换为DTO
        BeanUtils.copyProperties(history, translateDTO);
        return translateDTO;
    }

    @Override
    public TranslateDTO collectionWord(int translateHistoryId) {


        TranslateHistory history = translateHistoryMapper.selectById(translateHistoryId);

        history.setIsCollection(true);

        translateHistoryMapper.updateById(history);


        // 转换为DTO
        // 我开始考虑这个转换为DTO是否有必要了……
        // 但为了分层，好像，确实有那么点必要
        TranslateDTO translateDTO = new TranslateDTO();
        BeanUtils.copyProperties(history, translateDTO);
        return translateDTO;
    }

    @Override
    public List<TranslateDTO> getCollectionsByUid(int userId) {
        QueryWrapper<TranslateHistory> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("user_id", userId).eq("is_collection", 1);

        return toTranslateDTOList(translateHistoryMapper.selectList(queryWrapper));
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
