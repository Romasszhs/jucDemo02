package com.hang.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class clientA {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1",3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date()+": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e){
                        long l = System.currentTimeMillis();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
