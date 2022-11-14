package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080);) {
            try (Socket clientSocket = serverSocket.accept();
                 // OutputStreamWriter out = new OutputStreamWriter(clientSocket.getOutputStream());
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                int client = 1;
                while (true) {

                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.write("you are client number " + client+ " ");
                    client++;
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                }
            }
        } catch (IOException e) {
            System.out.println("You have problems:" + e);
        }
    }
}