package sample;

//homepage

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class Scene1 {

    public void vote1(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("congo.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
        try {
            FileWriter reader = new FileWriter("x.txt", true);
            reader.write("a" + "\n");
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public void vote2(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("congo.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

        try {
            FileWriter reader = new FileWriter("y.txt", true);
            reader.write("b" + "\n");
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public void vote3(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("congo.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

        try {
            FileWriter reader = new FileWriter("z.txt", true);
            reader.write("c" + "\n");
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
