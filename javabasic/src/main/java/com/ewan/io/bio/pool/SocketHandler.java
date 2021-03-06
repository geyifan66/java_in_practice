package com.ewan.io.bio.pool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {
    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket=socket;
    }

    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = in.read(buffer)) > 0) {//阻塞
                System.out.println("input is:" + new String(buffer, 0, length));
                out = socket.getOutputStream();
                out.write("success".getBytes());
                System.out.println("end");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}