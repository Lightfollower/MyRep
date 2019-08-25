package lesson_6.Client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Controller {
    public Application application;

    @FXML
    VBox VboxChat;

    @FXML
    TextField textField;

    @FXML
    Button btn1;

    @FXML
    HBox bottomPanel;

    @FXML
    HBox upperPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordFiled;

    String nick;

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    private boolean isAuthorized;

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    public void setAuthorized(boolean isAuthorized) {

        this.isAuthorized = isAuthorized;
        if (!isAuthorized) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
        } else {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
        }
    }

    public void connect() {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {

                try {
                    while (true) {
                        String str = in.readUTF();
                        VBox vBox = new VBox();

                        if (str.startsWith("/authok")) {
                            setAuthorized(true);
                            nick = str.split(" ")[1];
                            Label label = new Label("you're: " + nick + "\n");
                            vBox.getChildren().add(label);
                            Platform.runLater(() -> VboxChat.getChildren().add(vBox));
                            break;
                        } else {
                            Label label = new Label(str + "\n");
                            vBox.getChildren().add(label);
                            Platform.runLater(() -> VboxChat.getChildren().add(vBox));
                        }
                    }

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/serverClosed")) {
                            setAuthorized(false);
                            break;
                        }
                        Platform.runLater(() -> {

                            Label label = new Label(str + "\n");
                        VBox vBox = new VBox();
                        if (str.startsWith(nick)) {
                            vBox.setAlignment(Pos.TOP_RIGHT);
                        } else {
                            vBox.setAlignment(Pos.TOP_LEFT);
                        }
                        vBox.getChildren().add(label);
//                        new Thread(() -> VboxChat.getChildren().add(vBox)).start();
//                        Пока Controller выполняет какой-то метод, не произойдёт обновления окна.
//                        Созданный объект Runnable так и не будет запущен, будет вызван метод run() из специально созданного потока.
                            VboxChat.getChildren().add(vBox);
                        });
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg() {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tryToAuth() {

        if (socket == null || socket.isClosed()) {
            connect();
        }

        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordFiled.getText());
            loginField.clear();
            passwordFiled.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
