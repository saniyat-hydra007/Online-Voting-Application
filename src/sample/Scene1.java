package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Scene1 {

    public void vote1(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

        try {
            FileInputStream f = new FileInputStream("c.txt");
            Scanner reader2 = new Scanner(f);

            String search = reader2.toString();

            while (reader2.hasNextLine()){

                String s = reader2.nextLine();
                String str[] = s.split(" ");

                System.out.println(str[0]);

                int i=Integer.parseInt(str[0]);
                i++;
                System.out.println(i);

                String s2=String.valueOf(i);

            }
            reader2.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }

    }

    public void vote2(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void vote3(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}
