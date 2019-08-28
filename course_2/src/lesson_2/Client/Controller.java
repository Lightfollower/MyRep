package lesson_2.Client;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;


public class Controller {

    @FXML
    VBox VboxChat;

    @FXML
    TextField textField;

    @FXML
    Button btn1;

    @FXML
    Button btn2;

    @FXML
    HBox bottomPanel;

    @FXML
    HBox upperPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordFiled;

    private String nick;

    Socket socket;
    private DataInputStream in;
    DataOutputStream out;

    private String historyFileName = "history.txt";
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;

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
            fileWriter = new FileWriter(historyFileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something wrong with your file.");
        }
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {

                try {
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/authok")) {
                            setAuthorized(true);
                            nick = str.split(" ")[1];
                            updateChatTextArea("you're: " + nick + "\n");
                            fileReader = new FileReader(historyFileName);
                            bufferedReader = new BufferedReader(fileReader);
                            for (int i = 0; i < 100; i++) {
                                if(bufferedReader.ready())
                                updateChatTextArea(bufferedReader.readLine());
                            }
                            bufferedReader.close();
                            fileReader.close();
                            break;
                        } else {
                            updateChatTextArea(str + "\n");
                        }
                    }

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/serverClosed")) {
                            setAuthorized(false);
                            break;
                        }

                        if (str.startsWith("/changeOk")) {
                            String[] tokens = str.split(" ");
                            nick = tokens[1];
                            updateChatTextArea("you're: " + nick + "\n");
                            continue;
                        } else if (str.equals("/nickChangeDenied")) {
                            updateChatTextArea("no seats, all tickets sold");
                            continue;
                        }
                        updateChatTextArea(str + "\n");
                        bufferedWriter.write(str + "\r\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        fileWriter.close();
                        bufferedWriter.close();
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

    public void changeNick() {
        try {
            out.writeUTF("/newNick " + textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateChatTextArea(String text) {
        Label label = new Label(text);
        VBox vBox = new VBox();
        if (text.startsWith(nick + ": ")) {
            vBox.setAlignment(Pos.TOP_RIGHT);
        }
        vBox.getChildren().add(label);
        Platform.runLater(() -> VboxChat.getChildren().add(vBox));
    }

    public void closeOutput() throws IOException{
        bufferedWriter.close();
        fileWriter.close();
    }

//    public void tryToReg() {
//        if (socket == null || socket.isClosed()) {
//            connect();
//        }
//
//        try {
//            out.writeUTF("/reg " + loginField.getText() + " " + passwordFiled.getText());
//            loginField.clear();
//            passwordFiled.clear();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
