package com.mudongheng.ielp.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 幕冬
 * @since 2021年11月11日
 */
public interface FileService {

    // 创建文件
    void createFile(File file);

    // 创建图片
    void createImage(MultipartFile multipartFile) throws IOException;

    // 创建音乐
    void createMusic(MultipartFile multipartFile) throws IOException;

    // 根据图片id获取图片
    byte[] getImage(Integer id) throws IOException;

    // 根据音乐id获取音乐
    byte[] getMusic(Integer id) throws IOException;

}
