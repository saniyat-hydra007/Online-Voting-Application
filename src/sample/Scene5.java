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

public class Scene5 {

    @FXML
    private TextField tf1;

    @FXML
    private TextField tf2;


    @FXML
    void login(javafx.event.ActionEvent event) throws IOException {
        String data = tf1.getText();
        String data2 = tf2.getText();

        try {
            FileInputStream f = new FileInputStream("C.txt");

            Scanner reader2 = new Scanner(f);

            while (reader2.hasNext()) {

                String s = reader2.nextLine();
                String str[] = s.split(" ");


                if (data.equals(str[0]) && data2.equals(str[1])) {
                    Parent tableViewParent = FXMLLoader.load(getClass().getResource("scene6.fxml"));
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

}
