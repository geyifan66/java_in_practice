package com.ewan.io.bio.pool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServerThread {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(port);
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();//拿到socket
                //连接量大的时候 会拖垮cpu
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                    serverSocket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}