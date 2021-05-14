package com.company.ielp.app;

import cn.hutool.core.lang.Validator;
import com.company.ielp.app.model.translate.Translate;
import com.company.ielp.app.model.translate.TranslateCollection;
import com.company.ielp.app.utils.CheckUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class UtilsTest {
    @Test
    public void ccNumberBeUsedTest() {
        boolean email = CheckUtil.isEmail("1@qq.com");
        System.out.println(email);
        email = CheckUtil.isEmail("21@421qqcom");
        System.out.println(email);
        email = CheckUtil.isEmail("1.qq@c.qq");
        System.out.println(email);
    }

    @Test
    public void huToolTest() {
        System.out.println(Validator.isEmail("21@421qqcom"));
        System.out.println(Validator.isEmail("1.qq@c.qq"));
        System.out.println(Validator.isEmail("1@qq.com"));
        System.out.println(Validator.isMobile("19858166666"));
    }

    @Test
    public void getTime() {
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void translateTest() {
        Translate t = new TranslateCollection();
    }

    @Test
    public void pathTest() {
    }

}
