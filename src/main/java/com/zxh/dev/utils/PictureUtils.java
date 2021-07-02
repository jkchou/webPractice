package com.zxh.dev.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PictureUtils {
    private static Byte[] bytes;

    public static Byte[] getPicByte(String file) throws IOException {
        //InputStream is = new FileInputStream(file);
        InputStream is = PictureUtils.class.getResourceAsStream(file);
        int available = is.available();
        bytes = new Byte[available];
        for (int i = 0; i < available; i++) {
            bytes[i] = (byte) is.read();
        }
        return bytes;
    }
}