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
    private final int PAGESIZE = 1800;
    @FXML
    VBox textArea;

    @FXML
    Button nextPage;

    @FXML
    TextField pageNumber;

    Label label;
    VBox vBox;

    private int pageN = 1;
    private RandomAccessFile randomAccessFile;
    private byte[] bytes;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            randomAccessFile = new RandomAccessFile("src/resources/lesson_3/Bigtextfile.txt", "r");
            bytes = new byte[PAGESIZE];
            updateTextArea(loadPageFromFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTextArea(String text) {
        System.out.println(text);
        label = new Label(text);
        vBox = new VBox();
        Platform.runLater(() -> textArea.getChildren().add(label));
    }

    public String loadPageFromFile() throws IOException {
        randomAccessFile.seek((pageN - 1)*PAGESIZE );
        randomAccessFile.read(bytes);
        return new String(bytes);
    }

    public void nextPages() throws IOException {
        pageN = Integer.parseInt(pageNumber.getText());
        updateTextArea(loadPageFromFile());
    }

    public void closeStream() throws IOException {
        randomAccessFile.close();
    }

}
