package com.hillel.lesson27;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerMain {
    private static String localEncoding = "windows-1251";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Server is listening on port 8081");

            Socket client = serverSocket.accept();
            System.out.println("Connected to client");

            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, localEncoding));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, localEncoding), true);

            printWriter.println("Server welcomes you, User!");

            String message = null;
            while ((message = bufferedReader.readLine()) != null) {
                if (hasRussianLetters(message)) {
                    printWriter.println("Що таке паляниця?");
                    message = bufferedReader.readLine();
                    if (isNotRussianSpy(message)) {
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm:ss");
                        printWriter.println(now.format(formatter));
                    } else {
                        printWriter.println("Not this time, ruski shpion!");
                    }
                    break;
                } else {
                    System.out.println(message);
                }
            }
            System.out.println("Client was disconnected from the server");

        } catch (IOException e) {
            System.out.println("Error occurred during listening/accepting the connection or reading data.");
            e.printStackTrace();
        }
    }

    private static boolean hasRussianLetters(String message) {
        String messageCheck = message.toLowerCase();
        return messageCheck.contains("ъ") || messageCheck.contains("ы") || messageCheck.contains("ё");
    }

    private static boolean isNotRussianSpy(String message) {
        String messageCheck = message.toLowerCase();
        return messageCheck.equals("khlib") || messageCheck.equals("hlib") || messageCheck.equals("хліб");
    }
}
