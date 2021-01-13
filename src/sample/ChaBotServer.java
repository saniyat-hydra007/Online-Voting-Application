package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ChatBot {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server Started");
            ArrayList<ChatBotServerClient> chatBotServerClients = new ArrayList<>();

            while (true) {
                try {
                    Socket socket = server.accept();
                    ChatBotServerClient chatBotServerClient = new ChatBotServerClient(socket, chatBotServerClients);
                    chatBotServerClients.add(chatBotServerClient);
                    Thread clientThread = new Thread(chatBotServerClient);
                    clientThread.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
