package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Scene4 {

    @FXML
    public TextArea ta1;

    @FXML
    public TextArea ta2;

    @FXML
    public TextArea ta3;

                BufferedReader reader = new BufferedReader(new FileReader("x.txt"));
                int lines = 0;
                while (reader.readLine() != null)
                {
                    lines++;
                }
                ta1.setText(lines+" ");
                System.out.println(lines);
                reader.close();


}
