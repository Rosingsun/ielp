package com.mudongheng.ielp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author 幕冬
 * @since 2021年11月11日
 */
@Configuration
@ConfigurationProperties(prefix = "mudongheng")
public class FilePathConfig {

    public final static String UI_URL = "https://blog.mudongheng.com/";

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws Exception {
        File file = new File(path);
        if (file.isDirectory()) {
            this.path = path;
        } else if (file.mkdir()){
            this.path = path;
        } else {
            throw new Exception("文件路径配置错误");
        }
    }
}