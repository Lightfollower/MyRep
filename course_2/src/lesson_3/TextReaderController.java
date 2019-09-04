package lesson_3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TextReaderController implements Initializable {

    public ListView textList;
    @FXML
    VBox textArea;

    @FXML
    Button nextPage;

    private BufferedReader bufferedReader;
    private StringBuilder page;
    Label label;

    VBox vBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            bufferedReader = new BufferedReader(new FileReader("F:\\IdeaProjects\\course_2\\src\\lesson_3\\txtfile.txt"));
            page = new StringBuilder();
            updateTextArea(loadPageFromFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateTextArea(String text) {
        label = new Label(text);
        vBox = new VBox();
        Platform.runLater(() -> textArea.getChildren().add(label));
    }

    public String loadPageFromFile() throws IOException {
        for (int i = 0; i < 1800; i++) {
            page.append((char) bufferedReader.read());
        }
        return page.toString();
    }

    public void nextPage() throws IOException {
        updateTextArea(loadPageFromFile());
    }

    public void closeStream() throws IOException {
        bufferedReader.close();
    }

}
