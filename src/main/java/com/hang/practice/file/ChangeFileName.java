package com.hang.practice.file;

import com.yzk18.commons.IOHelpers;

import javax.xml.bind.SchemaOutputResolver;
import java.io.File;

/**
 * @author: hangshuo
 * @date: 2021/05/19 13:59
 * @Description:
 */

public class ChangeFileName {
    public static void main(String[] args) {
        File file = new File("./测试文件夹内容改名/output/");
        File[] dirs = file.listFiles();
        for (File dir : dirs) {
            for (File file1 : dir.listFiles()) {
                System.out.println(file1.getName());
                String[] split = file1.getName().split("-");
                System.out.println(split[0]);
                String dirName = split[0];
                System.out.println(split[1]);
                String filename = split[1];
                File file2 = new File("./测试文件夹内容改名/output2/" + dirName + File.separator + filename);
                byte[] bytes = IOHelpers.readAllBytes(file1);
                IOHelpers.writeAllBytes(file2,bytes);
            }
        }

    }
}
