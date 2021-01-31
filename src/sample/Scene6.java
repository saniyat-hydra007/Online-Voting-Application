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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Scene6 {

    @FXML
    private TextField tf1;

    @FXML
    private TextArea ta1;


    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @FXML
    void get() {

        int n = getRandomNumber(1,300); // The line number
        try{
            String line = Files.readAllLines(Paths.get("D.txt")).get(n);
            ta1.setText(line);
        }
        catch(IOException e){
            System.out.println(e);
        }

    }


    @FXML
    void submit(javafx.event.ActionEvent event) throws IOException {
        String data4=tf1.getText().trim();

        try {
            FileInputStream f = new FileInputStream("D.txt");
            Scanner reader2 = new Scanner(f);

            String search = reader2.toString();

            while (reader2.hasNextLine()){

                String s = reader2.nextLine();
                String str[] = s.split(" ");

                if (data4.equals(str[0].trim())) {
                     Parent tableViewParent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
                    Scene tableViewScene = new Scene(tableViewParent);

                    //This line gets the Stage information
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    window.setScene(tableViewScene);
                    window.show();
                }
            }
            reader2.close();
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

}
