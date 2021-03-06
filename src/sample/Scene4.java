package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

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

    public void srbutton(){
        BufferedReader reader;
        BufferedReader reader2;
        BufferedReader reader3;
        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        {
            try {
                reader = new BufferedReader(new FileReader("x.txt"));
                reader2 = new BufferedReader(new FileReader("y.txt"));
                reader3 = new BufferedReader(new FileReader("z.txt"));

                while (reader.readLine() != null)
                {
                    l1++;
                }
                while (reader2.readLine() != null)
                {
                    l2++;
                }
                while (reader3.readLine() != null)
                {
                    l3++;
                }
                reader.close();
                reader2.close();
                reader3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ta1.setText(l1+" ");
        ta2.setText(l2+" ");
        ta3.setText(l3+" ");
    }

    public void home(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}
