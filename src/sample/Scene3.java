package sample;

//client messenger

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Scene3 {

    @FXML
    TextField msgTextField;

    @FXML
    Button sendButton;

    @FXML
    TextArea allTextArea;

    private BufferedWriter writer;
    private BufferedReader reader;

    public Scene3(){
        String myName = "Client";

        try {
            Socket socket = new Socket("127.0.0.1", 4000);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);


            Thread t = new Thread(){
                public void run(){
                    try{
                        String line = reader.readLine() + "\n";
                        while (line != null){
                            allTextArea.appendText(line);
                            line = reader.readLine() + "\n";
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void msgSend(){
        try {

            String msg = msgTextField.getText() + "\n";
            msgTextField.setText("");
            writer.write(msg);
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void back(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}

