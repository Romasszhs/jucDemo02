package com.hang.practice.file;

import com.yzk18.GUI.GUI;
import com.yzk18.commons.IOHelpers;

import java.io.File;
import java.util.Arrays;

/**
 * @author: hangshuo
 * @date: 2021/05/19 22:09
 * @Description:
 */

public class CopyDir {
    public static void main(String[] args) {
        String srcDir = GUI.dirOpenBox("选择源文件夹");
        String destDir = GUI.dirOpenBox("选择目标文件夹");

        File srcFile = new File(srcDir);
        File[] files = srcFile.listFiles();
        System.out.println(Arrays.toString(files));
        for (int i = 0; i < files.length; i++) {
            GUI.showProgressDialog("拷贝文件的进度",files.length,i+1);
            String destFileName = destDir+"/"+files[i].getName();
            byte[] bytes = IOHelpers.readAllBytes(files[i]);
            IOHelpers.writeAllBytes(destFileName,bytes);
        }
        GUI.closeProgressDialog();
        GUI.msgBox("拷贝完成");
        //String[] filesRecursively = IOHelpers.getFilesRecursively(srcDir);
        //System.out.println(Arrays.toString(filesRecursively));
    }
}
