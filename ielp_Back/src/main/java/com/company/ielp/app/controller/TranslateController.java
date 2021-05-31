package com.company.ielp.app.controller;

import com.company.ielp.app.model.dto.TranslateDTO;
import com.company.ielp.app.model.params.TranslateParam;
import com.company.ielp.app.model.vo.BaseVO;
import com.company.ielp.app.model.vo.TranslateVO;
import com.company.ielp.app.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

/**
 * 提供翻译方案
 * @author 幕冬
 * @see TranslateDTO
 */
@Slf4j
@Controller
@RequestMapping("/translation")
public class TranslateController {

    final String TRANSLATE_SUCCESS = "翻译记录传入成功！";

    final String COLLECTION_SUCCESS = "翻译记录收藏成功！";

    final String GET_SUCCESS = "获取成功！";

    final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    /**
     * 传入翻译并添加历史记录
     * @param translateParam 翻译表单
     * @return 记录列表
     */
    @PostMapping("/translate")
    @ResponseBody
    public TranslateVO translate(TranslateParam translateParam) {
        return new TranslateVO(Collections.singletonList(translateService.translateWord(translateParam)), TRANSLATE_SUCCESS, BaseVO.SUCCESS);
    }

    /**
     * 收藏历史记录
     * @param translateHistoryId 历史记录Id
     * @return 记录列表
     */
    @PostMapping("/collection")
    @ResponseBody
    public TranslateVO collection(int translateHistoryId) {
        return new TranslateVO(Collections.singletonList(translateService.collectionWord(translateHistoryId)), COLLECTION_SUCCESS, BaseVO.SUCCESS);
    }

    /**
     * 收藏历史记录
     * @param userId 历史记录Id
     * @return 记录列表
     */
    @GetMapping("/get-histories")
    @ResponseBody
    public TranslateVO getHistories(int userId) {
        return new TranslateVO(translateService.getHistories(userId), COLLECTION_SUCCESS, BaseVO.SUCCESS);
    }

    /**
     * 收藏历史记录
     * @param userId 历史记录Id
     * @return 记录列表
     */
    @GetMapping("/getCollections")
    @ResponseBody
    public TranslateVO getCollections(int userId) {
        return new TranslateVO(translateService.getCollections(userId), GET_SUCCESS, BaseVO.SUCCESS);
    }
}