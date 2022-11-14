package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.System.out;

public class ThirdClient {
    //третий игрок
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
                out.println("warsaw");
                System.out.println(in.readLine());
                break;
            }
        } catch (IOException e) {
            out.println(e);
        }
    }
}
