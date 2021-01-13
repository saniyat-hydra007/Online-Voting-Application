package sample;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ChatBotServerClient implements Runnable{
    private BufferedWriter writer;
    private BufferedReader reader;
    ArrayList <ChatBotServerClient> chatBotServerClients;
    String clientName;

    ChatBotServerClient(Socket socket, ArrayList<ChatBotServerClient> chatBotServerClients){
        try {
            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);

            clientName = reader.readLine();

            this.chatBotServerClients = chatBotServerClients;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String clientData =  reader.readLine() + "\n";
            clientData = clientName + " writes: " + clientData;

            while (clientData != null){
                for(ChatBotServerClient chatBotServerClient : chatBotServerClients){
                    synchronized (chatBotServerClient.writer) {
                        chatBotServerClient.writer.write(clientData);
                        chatBotServerClient.writer.flush();
                    }
                }
                clientData =  reader.readLine() + "\n";
                clientData = clientName + " writes: " + clientData;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
