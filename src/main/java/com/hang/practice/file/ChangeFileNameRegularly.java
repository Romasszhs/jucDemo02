package com.hang.practice.file;

import com.yzk18.commons.IOHelpers;

import java.io.BufferedInputStream;
import java.io.File;
import java.util.Arrays;

/**
 * @author: hangshuo
 * @date: 2021/05/19 11:01
 * @Description:
 */

public class ChangeFileNameRegularly {
    public static void main(String[] args) {
        File file = new File("测试文件夹内容改名");
        File[] dirs = file.listFiles();
        for (File dir : dirs) {
            File[] files = dir.listFiles();
            for (File filetxt : files) {
                String filepath = filetxt.getPath();
                filepath = filepath.replace("\\","/");
                //System.out.println(filepath);
                String[] split = filepath.split("/");
                System.out.println(Arrays.toString(split));
                String foldername = split[1];
                String oldfilename = split[2];
                String newfilename = foldername+"-"+oldfilename;
                System.out.println(newfilename);
                File newFileLocation = new File("测试文件夹内容改名/output/"+foldername+File.separator+newfilename);
                System.out.println(newFileLocation);
                byte[] bytes = IOHelpers.readAllBytes(filetxt);// 读出源文件
                IOHelpers.writeAllBytes(newFileLocation,bytes); // 写入新文件
                //filetxt.renameTo(newFile);
            }
        }
    }
}
