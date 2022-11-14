package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080);) {
            int clients = 1;
            String city = null;
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    if (clients == 1) {

                        System.out.println("New connection accepted");
                        out.println("???");
                        city = in.readLine();
                        System.out.println("You entered: " + city);
                        out.println("OK");

                    } else if (clients > 1) {
                        out.println(city);

                        String newCity = in.readLine();
                        int cityLength = city.length();
                        char first = city.charAt(cityLength - 1);
                        char next = newCity.charAt(0);
                        if (first == next) {
                            System.out.println("You entered: " + newCity);
                            out.println("OK");
                            city = newCity;
                        } else {
                            System.out.println("You entered: " + newCity);
                            out.println("NOT OK");
                        }
                    }
                    clients++;


                }
            }
        } catch (IOException e) {
            System.out.println("Can't start the server " + e);
        }
    }
}