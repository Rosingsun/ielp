package com.company.ielp.app.controller;

import com.company.ielp.app.model.User;
import com.company.ielp.app.model.translate.TranslateCollection;
import com.company.ielp.app.model.translate.TranslateHistory;
import com.company.ielp.app.service.TranslateCollectionService;
import com.company.ielp.app.service.TranslateHistoryService;
import com.company.ielp.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 为前端的用户操作提供接口
 * @author 幕冬儿
 */
@Slf4j
@RestController
public class UserController {

    final UserService userService;
    final TranslateHistoryService translateHistoryService;
    final TranslateCollectionService translateCollectionService;

    public UserController(
            UserService userService,
            TranslateHistoryService translateHistoryService,
            TranslateCollectionService translateCollectionService) {
        this.userService = userService;
        this.translateHistoryService = translateHistoryService;
        this.translateCollectionService = translateCollectionService;
    }

    /**
     * 跳转到登陆界面
     * @return 登陆界面
     */
    @GetMapping(value = {"/", "/loginPage"})
    public String loginPage() {
        return "login";
    }

    /**
     * 尝试登陆
     * @param user 根据前端自动获取user
     * @return 用户
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(User user) {
        log.info(user.toString());

        // 检查user中的账号密码是否存在于数据库
        // 然后……
        // 嗯

        return user.toString();
    }

    /**
     * 传入翻译并添加历史记录
     * @param t 翻译内容
     * @return 标识
     */
    @PostMapping("/translate")
    @ResponseBody
    public String translate(TranslateHistory t) {
        t.setTranslatedTime(new Date());
        translateHistoryService.translateWord(t);
        String s = String.format("翻译记录传入：{%s}", t);
        log.info(s);
        return s;
    }

    /**
     * 收藏历史记录
     * @param translateHistoryId 历史记录Id
     * @return 标识
     */
    @PostMapping("/collection")
    @ResponseBody
    public String collection(int translateHistoryId) {
        TranslateCollection translateCollection = translateCollectionService.collectionWord(translateHistoryId);
        String s = String.format("收藏记录：{%s}", translateCollection);
        log.info(s);
        return s;
    }
}
