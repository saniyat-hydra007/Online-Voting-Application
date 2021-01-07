package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Scene2 {
    @FXML
    TextField tf11;

    @FXML
    TextField tf12;

    public void logIn(){
        String data = tf11.getText();
        String data2 = tf12.getText();

        try {
            FileInputStream f = new FileInputStream("B.txt");
            Scanner reader2 = new Scanner(f);

            while (reader2.hasNext()) {

                String s = reader2.nextLine();
                String str[] = s.split(" ");

                if (data.equals(str[0]) && data2.equals(str[1])) {
                    System.out.println("hey");
                }
            }
            reader2.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }



}
