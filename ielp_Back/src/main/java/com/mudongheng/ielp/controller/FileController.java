package com.mudongheng.ielp.controller;

import com.mudongheng.ielp.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 幕冬
 * @since 2021年11月16日
 */
@Slf4j
@RestController
@RequestMapping("/api/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    // 创建图片
    @PostMapping("/create-image")
    public void createImage(@RequestBody MultipartFile multipartFile) throws IOException {
        log.info("创建图片：{}", multipartFile.getOriginalFilename());
        fileService.createImage(multipartFile);
    }

    // 创建音乐
    @PostMapping("/create-music")
    public void createMusic(@RequestBody MultipartFile multipartFile) throws IOException {
        log.info("创建音乐：{}", multipartFile.getOriginalFilename());
        fileService.createMusic(multipartFile);
    }

    // 根据图片id获取图片
    @PostMapping(value = "/get-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@RequestBody Integer id) throws IOException {
        log.info("获取图片 id：{}", id);
        return fileService.getImage(id);
    }

    // 根据音乐id获取音乐
    @PostMapping(value = "/get-music")
    public byte[] getMusic(@RequestBody Integer id) throws IOException {
        log.info("获取音乐 id：{}", id);
        return fileService.getMusic(id);
    }
}
