package sample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ChatBotServer {
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
            writer.write("Bot-> Hello sir. For any information type:" + "\n" + "1.'how to vote' for voting procedude" + "\n" + "1.'how to see my information' for see your information" + "\n");
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
                    writer.write("Bot-> First type your NID card number properly." + "\n" + "Then Click on 'Vote', and this will open a page with list of candidates." + "\n" + "Select your favourable candidate sign and press it. Then your vote is done" + "\n");
                }
                if(line.equals("how to see my information")){
                    writer.write("Bot-> First type your NID card number properly." + "\n" + "Then Click on 'Information', and then you can see your all your information." +"\n");
                }
                if(line.equals("how many times can I vote?")){
                    writer.write("Bot-> You can only vote for one times." + "\n");
                }
                if(line.equals("thank you")){
                    writer.write("Bot-> Welcome. Have a nice day!" + "\n");
                }
                writer.flush();
                line = reader.readLine();

            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
