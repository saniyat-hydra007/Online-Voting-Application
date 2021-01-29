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
    private TextArea ta1;

    @FXML
    private TextField tf2;

    @FXML
    private TextField tf3;

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @FXML
    void login(javafx.event.ActionEvent event) throws IOException {
        String data = tf1.getText();
        String data2 = tf2.getText();
        String data3 = tf3.getText();

        try {
            FileInputStream f = new FileInputStream("C.txt");

            Scanner reader2 = new Scanner(f);

            while (reader2.hasNext()) {

                String s = reader2.nextLine();
                String str[] = s.split(" ");

//                String s4=String.valueOf(getRandomNumber(1,300));
//
//                ta1.setText(str2[Integer.parseInt(s4)]);
//
//                System.out.println(str2[Integer.parseInt(s4)]);

                if (data.equals(str[0]) && data2.equals(str[1])) {
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

}
