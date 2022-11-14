package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class FirstClient {
    //первый игрок
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            while (true) {
                System.out.println("New connection accepted");
                System.out.println(in.readLine());
                out.println("moscow");
                System.out.println(in.readLine());
                break;
            }
        } catch (IOException e) {
            out.println(e);
        }
    }
}
