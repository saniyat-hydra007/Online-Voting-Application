package sample;

//counter of entire vote

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scene4 {

    @FXML
    TextArea resultTa1;

    @FXML
    TextArea resultTa2;

    @FXML
    TextArea resultTa3;

    BufferedReader reader;

    {
        try {
            reader = new BufferedReader(new FileReader("x.txt"));
            int lines = 0;
            while (reader.readLine() != null)
            {
                lines++;
            }
            //resultTa1.setText(String.valueOf(lines));
            System.out.println(lines);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

