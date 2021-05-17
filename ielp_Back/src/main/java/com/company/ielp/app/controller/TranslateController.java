package com.company.ielp.app.controller;

import com.company.ielp.app.model.dto.TranslateDTO;
import com.company.ielp.app.model.entity.TranslateWordPicture;
import com.company.ielp.app.model.params.TranslateParam;
import com.company.ielp.app.model.vo.TranslateVO;
import com.company.ielp.app.service.TranslateService;
import com.company.ielp.app.utils.PictureFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Date;

/**
 * 提供翻译方案
 * @author 幕冬
 * @see TranslateDTO
 */
@Slf4j
@Controller
@RequestMapping("/translation")
public class TranslateController {

    final TranslateService translateService;

    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    /**
     * 传入翻译并添加历史记录
     * @param translateParam 翻译表单
     * @return 标识
     */
    @PostMapping("/translate")
    @ResponseBody
    public TranslateVO translate(TranslateParam translateParam) {


        TranslateDTO translateDTO = translateService.translateWord(translateParam);
        String s = String.format("翻译记录传入：{%s}", translateDTO);
        log.info(s);

        TranslateVO vo = new TranslateVO();
        vo.setTime(new Date());
        vo.setMsg("翻译记录传入成功！");
        vo.setState(200);
        vo.setData(Collections.singletonList(translateDTO));

        return vo;
    }

    /**
     * 收藏历史记录
     * @param translateHistoryId 历史记录Id
     * @return 标识
     */
    @PostMapping("/collection")
    @ResponseBody
    public TranslateVO collection(int translateHistoryId) {
        TranslateDTO translateDTO = translateService.collectionWord(translateHistoryId);
        String s = String.format("收藏记录：{%s}", translateDTO);
        log.info(s);

        TranslateVO vo = new TranslateVO();
        vo.setTime(new Date());
        vo.setMsg("翻译记录收藏成功！");
        vo.setState(500);
        vo.setData(Collections.singletonList(translateDTO));

        return vo;
    }

    /**
     * 前端接口，上传词图关系
     *
     * @param word 单词
     * @param picture 图像
     * @return 上传信息
     */
    @PostMapping("/upload")
    @ResponseBody
    public String uploadWordPicture(String word, MultipartFile picture) {
        String s = picture.getOriginalFilename();

        if (s == null) {
            return "未进行任何操作！";
        }

        if (PictureFormatUtil.isPicture(s)) {
            TranslateWordPicture wordPicture = translateService.uploadWordPicture(word, picture);
            // 应该有一些识图功能，不过应该不关我事了
            // 神奇的数据学习
            return "上传词图关系：" + wordPicture;
        } else {
            return "传入文件格式错误！";
        }
    }
}