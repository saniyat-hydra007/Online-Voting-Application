package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ChatBot {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4000);
            System.out.println("Server Connected");
            Socket socket = server.accept();
            System.out.println("Connected to Client");

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(o);
            writer.write("Bot-> Hello sir. For any information type:" + "\n" + "1.'how to vote' for voting procedude" + "\n");
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);

                writer.write(line + "\n");
                if(line.equals("hello")){
                    writer.write("Bot-> Hello,How Can I help You?" + "\n");
                }
                if(line.equals("hi")){
                    writer.write("Bot-> Hello,How Can I help You?" + "\n");
                }
                if(line.equals("how to vote")){
                    writer.write("Bot-> First type your NID card number properly." + "\n");
                }
                if(line.equals("how to see my information")){
                    writer.write("Bot->Enter your name" + "\n");
                }
                if(line.equals("hi")){
                    writer.write("Bot-> Hello,How Can I help You?" + "\n");
                }
                writer.flush();
                line = reader.readLine();

            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args) {
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
    }*/
}
