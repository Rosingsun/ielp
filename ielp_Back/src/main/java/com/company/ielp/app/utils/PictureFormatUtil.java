package com.company.ielp.app.utils;

public class PictureFormatUtil {
    public static boolean isPicture(String fileName) {
        return fileName.contains(".jpg") || fileName.contains(".png");
    }

    public static String picFormat(String fileName) {
        if (fileName.contains(".jpg")) {
            return ".jpg";
        } else if (fileName.contains(".png")) {
            return ".png";
        }
        return null;
    }
}
