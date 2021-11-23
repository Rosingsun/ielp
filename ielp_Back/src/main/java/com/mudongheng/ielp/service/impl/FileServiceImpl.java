package com.mudongheng.ielp.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.io.FileUtil;
import com.mudongheng.ielp.config.FilePathConfig;
import com.mudongheng.ielp.mapper.FileImageMapper;
import com.mudongheng.ielp.mapper.FileMusicMapper;
import com.mudongheng.ielp.model.entity.FileImage;
import com.mudongheng.ielp.model.entity.FileMusic;
import com.mudongheng.ielp.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author 幕冬
 * @since 2021年11月11日
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    private final static String FILE_PATH_DIRECTORY = "/cache/.ielp";

    private final FileImageMapper fileImageMapper;

    private final FileMusicMapper fileMusicMapper;

    private final FilePathConfig filePathConfig;

    public FileServiceImpl(FileImageMapper fileImageMapper, FileMusicMapper fileMusicMapper, FilePathConfig filePathConfig) {
        this.fileImageMapper = fileImageMapper;
        this.fileMusicMapper = fileMusicMapper;
        this.filePathConfig = filePathConfig;
    }


    @Override
    public void createFile(File file) {
        FileUtil.createTempFile("test", "txt", new File(FILE_PATH_DIRECTORY), false);
    }

    @Override
    public void createImage(MultipartFile multipartFile) throws IOException {
        String date = DatePattern.PURE_DATETIME_FORMAT.format(new Date());
        File file = new File(filePathConfig.getPath() + "/" + date + "-" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        FileImage fileImage = new FileImage();
        fileImage.setFilePath(file.getPath());
        fileImageMapper.insert(fileImage);
    }

    @Override
    public void createMusic(MultipartFile multipartFile) throws IOException {
        String date = DatePattern.PURE_DATETIME_FORMAT.format(new Date());
        File file = new File(filePathConfig.getPath() + "/" + date + ".jpg");
        multipartFile.transferTo(file);
        FileMusic fileMusic = new FileMusic();
        fileMusic.setFilePath(file.getPath());
        fileMusicMapper.insert(fileMusic);
    }

    @Override
    public byte[] getImage(Integer id) throws IOException {
        FileImage fileImage = fileImageMapper.selectById(id);
        try (FileInputStream fileInputStream = new FileInputStream(fileImage.getFilePath())) {
            return fileInputStream.readAllBytes();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public byte[] getMusic(Integer id) throws IOException {
        FileMusic fileMusic = fileMusicMapper.selectById(id);
        try (FileInputStream fileInputStream = new FileInputStream(fileMusic.getFilePath())) {
            return fileInputStream.readAllBytes();
        } catch (IOException e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}
