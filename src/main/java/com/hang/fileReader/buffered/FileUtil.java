package com.hang.fileReader.buffered;

import java.io.*;

/**
 * @author: hangshuo
 * @date: 2021/04/28 17:24
 * @Description:
 */

public class FileUtil {
    public byte[] getContent(String filePath){
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize>Integer.MAX_VALUE){
            System.out.println("FILE TOO BIG");
            return null;
        }

        FileInputStream fi = null;
        try {
            fi = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[(int)fileSize];
        int offset = 0;
        int numRead = 0;
        try {
            while (offset < buffer.length
                    && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
                offset += numRead;
            }
            // 确保所有数据均被读取
            if (offset != buffer.length) {
                throw new IOException("Could not completely read file " + file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buffer;
    }

    public static byte[] toByteArray(String filename) throws Exception {
        File file = new File(filename);
        if (!file.exists()){
            throw new FileNotFoundException(filename);
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream bi = null;
        try {
            bi = new BufferedInputStream(new FileInputStream(file));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = bi.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e){
            e.printStackTrace();
            throw e;
        } finally {
            bi.close();

            bos.close();
        }



    }
}
