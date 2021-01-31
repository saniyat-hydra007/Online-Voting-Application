package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    @FXML
    public TextField tf1;

    @FXML
    public TextArea ta1;


    public void on() {
        String data = tf1.getText();
        try {
            FileInputStream f = new FileInputStream("A.txt");
            Scanner reader2 = new Scanner(f);

            while (reader2.hasNext()) {

                String s = reader2.nextLine();
                String str[] = s.split(",");

                if (data.equals(str[3])) {
                    ta1.setText("Name: " + str[0] + "\n" + "Father's Name: " + str[1] + "\n" + "Mother's Name: " + str[2] + "\n"+ "NID Number: " + str[3] + "\n" + "Date Of Birth: " + str[4] + "\n" );
                    tf1.clear();
                }
            }
            reader2.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void next(javafx.event.ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("scene5.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void result(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void bot(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}
