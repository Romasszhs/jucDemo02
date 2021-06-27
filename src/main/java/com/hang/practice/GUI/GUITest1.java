package com.hang.practice.GUI;

import com.yzk18.GUI.GUI;
import com.yzk18.commons.IOHelpers;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author: hangshuo
 * @date: 2021/05/19 19:13
 * @Description:
 */

public class GUITest1 {
    public static void main(String[] args) {
        /*
        String s = GUI.buttonsBox("你好，请选择","zhangsan","lili");
        System.out.println(s);
        */
        /*
        String s = GUI.choiceBox("你好，请选择",new String[]{"zhangsan","lili"});
        System.out.println(s);
        */
        //LocalDate birthday = GUI.dateBox("请选择你的生日",LocalDate.of(2020,1,28 ));
        //System.out.println(birthday);
        /*
        String dirs = GUI.dirOpenBox("请选择打开的文件夹");
        System.out.println(dirs);

        String filedir = GUI.dirSaveBox("请选择保存的文件夹");
        System.out.println(filedir);
         */
        /*String pptfile = GUI.fileOpenBox("请选择一个ppt文件","txt","pptx");
        System.out.println(pptfile);*/

        System.out.println(GUI.getScreenWidth()+"-"+GUI.getScreenHeight());

        /*String comment = GUI.imgBox("这个图片是", "c:/Users/ONE/Desktop/02.png", "美", "不美");
        System.out.println(comment);*/

        //String name  = GUI.inputBox("you name ?");

        /*String[] strArray = GUI.loginBox("请登录");
        System.out.println(Arrays.toString(strArray));*/

        /*String[] strArray = GUI.multiInputBox("请输入详细信息", "name", "sex", "age", "birthday");
        System.out.println(Arrays.toString(strArray));*/

        /*String[] strArray = GUI.multiInputBox("请输入详细信息",new String[]{"sex","birthday"},new Object[]{Integer.valueOf("1"),LocalDate.of(2001,1,1)},new Class[]{Integer.class,LocalDate.class});
        System.out.println(Arrays.toString(strArray));*/

        /*System.out.println(GUI.okCancelBox("选择‘是’或'否'"));*/

        // java：大部分情况，main函数执行结束了程序就退出结束
        /*//显示“非确定性”进度对话框，非模态对话框。
        //Indeterminate “非确定性”
        GUI.showIndeterminateProgressDialog("正在导入"); // 非模态对话框，不用等对话框关闭，代码就继续往后运行
        for (int i = 0 ;i<5;i++){
            byte[] bytes = IOHelpers.readAllBytes("C:\\Users\\ONE\\Downloads/ideaIU-2020.1.4.exe");
            IOHelpers.writeAllBytes("复制出来的文件.exe",bytes);
        }
        GUI.closeIndeterminateProgressDialog();
        GUI.msgBox("导入成功");
        // java：大部分情况，main函数执行结束了程序就退出了*/

        //显示进度显示对话框，非模态对话框。
        //GUI.showProgressDialog("正在复制",5,1);
        for (int i = 0 ;i<5;i++){
            GUI.showProgressDialog("正在复制，第"+(i+1)+"次",5,i+1);
            byte[] bytes = IOHelpers.readAllBytes("C:\\Users\\ONE\\Downloads/ideaIU-2020.1.4.exe");
            IOHelpers.writeAllBytes("复制出来的文件.exe",bytes);
        }
        GUI.closeProgressDialog();
        GUI.msgBox("5个文件复制完成");
    }
}
