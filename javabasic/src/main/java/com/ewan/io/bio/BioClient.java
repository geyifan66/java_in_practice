package com.ewan.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class BioClient {

    public static void main(String[] args) {
        Socket clientSocket = null;
        OutputStream outputStream = null;
        InputStream inputStream  = null;
        try{
            // 新建一个Socket请求
            clientSocket = new Socket("localhost",8080);
            System.out.println("Build the connection successfully!"+" ,"+new Date().toString());
            outputStream = clientSocket.getOutputStream();
            inputStream = clientSocket.getInputStream();
            byte[] buffer = new byte[1024];
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("Please input a String !"+" ,"+new Date().toString());
                String string = scanner.nextLine();
                if("end".equals(string)){
                    System.out.println("Client end"+" ,"+new Date().toString());
                    break;
                }
                outputStream.write(("This is a new request: "+string).getBytes());
                int length = 0;
                if ((length = inputStream.read(buffer)) > 0) {//阻塞
                }
                System.out.println("The response is:" + new String(buffer, 0, length)+" ,"+new Date().toString());
            }

        }catch (Exception e){

        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}