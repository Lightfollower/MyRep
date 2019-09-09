package lesson_2.Client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.setTitle("chat 2k19");
        Scene scene = new Scene(root, 350, 370);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            if(controller.socket != null && !controller.socket.isClosed()) {
                try {
                    controller.out.writeUTF("/end");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Platform.exit();
                System.exit(0);
            }
        });

    }

//    @Override
//    public void stop() throws Exception {
//        try {
//            controller.out.writeUTF("/end");
//        } catch (Exception e){
//
//        }
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
