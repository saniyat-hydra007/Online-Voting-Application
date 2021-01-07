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
                String str[] = s.split(" ");
//                System.out.println(s);
//                System.out.println(str[1]);

                if (data.equals(str[1])) {
                    ta1.setText(s);

                }
            }
            reader2.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void next(javafx.event.ActionEvent event) throws IOException {
        String data = tf1.getText();
        try {
            FileInputStream f = new FileInputStream("A.txt");
            Scanner reader2 = new Scanner(f);

            String search = reader2.toString();

            while (reader2.hasNextLine()) {

                String s = reader2.nextLine();
                String str[] = s.split(" ");

                if (data.equals(str[1].trim())) {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);

                    //This line gets the Stage information
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    window.setScene(tableViewScene);
                    window.show();
                }
            }
            reader2.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void result(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}
