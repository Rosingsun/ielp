package com.company.ielp.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.ielp.app.mapper.TranslateHistoryMapper;
import com.company.ielp.app.model.dto.TranslateDTO;
import com.company.ielp.app.model.entity.TranslateHistory;
import com.company.ielp.app.model.params.TranslateParam;
import com.company.ielp.app.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TranslateServiceImpl implements TranslateService {

    private final static String PATH_NAME = "D:\\缓存\\ielp\\pictureUrl\\";

    final TranslateHistoryMapper translateHistoryMapper;

    public TranslateServiceImpl(TranslateHistoryMapper translateHistoryMapper) {
        this.translateHistoryMapper = translateHistoryMapper;
    }

    private List<TranslateDTO> getHistoriesByUid(int userId, boolean isCollection) {
        // 新建查询
        QueryWrapper<TranslateHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        if (isCollection) {
            queryWrapper.eq("is_collection", true);
        }
        // 查询，包装，返回
        return toTranslateDTOList(translateHistoryMapper.selectList(queryWrapper));
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
    public TranslateDTO translateWord(TranslateParam translateParam) {
        TranslateHistory history = new TranslateHistory();
        TranslateDTO translateDTO = new TranslateDTO();
        // 插入历史记录
        BeanUtils.copyProperties(translateParam, history);
        log.info("传入翻译记录：{}", history);
        translateHistoryMapper.insert(history);
        // 转换为DTO
        BeanUtils.copyProperties(history, translateDTO);
        return translateDTO;
    }

    @Override
    public TranslateDTO collectionWord(int translateHistoryId) {

        TranslateHistory history = translateHistoryMapper.selectById(translateHistoryId);
        history.setIsCollection(true);
        log.info("收藏记录：{}", history);
        translateHistoryMapper.updateById(history);

        // 转换为DTO
        // 我开始考虑这个转换为DTO是否有必要了……
        // 但为了分层，好像，确实有那么点必要
        TranslateDTO translateDTO = new TranslateDTO();
        BeanUtils.copyProperties(history, translateDTO);
        return translateDTO;
    }

    @Override
    public List<TranslateDTO> getHistories(int userId) {
        return getHistoriesByUid(userId, false);
    }

    @Override
    public List<TranslateDTO> getCollections(int userId) {
        return getHistoriesByUid(userId, true);
    }

}
