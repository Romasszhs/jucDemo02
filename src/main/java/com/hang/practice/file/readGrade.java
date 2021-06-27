package com.hang.practice.file;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @author: hangshuo
 * @date: 2021/05/19 8:16
 * @Description:
 */

public class readGrade {
    public static void main(String[] args) throws Exception{
        File file = new File("./成绩/成绩.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line ;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] split = line.split(",");
            if (split[0]!=null){
                String filename = split[0].replaceAll(" +", "");
                File file1 = new File("./成绩/"+filename+".txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                Double v = Double.valueOf(split[1]) + Double.valueOf(split[2]) + Double.valueOf(split[3]);
                //double avg = (double) Math.round((v/3)*100)/100.0;
                DecimalFormat df = new DecimalFormat("#.##");
                double avg = Double.parseDouble(df.format(v / 3));
                String str = filename+"你好，你的语文成绩是"+Double.valueOf(split[1])
                        +"，你的数学成绩是"+Double.valueOf(split[2])
                        +"，你的英文成绩是"+Double.valueOf(split[3])
                        +"，你的平均分为"+ avg;
                bw.write(str);
                bw.flush();
                bw.close();
            }

        }


        br.close();
        fr.close();

    }


}
