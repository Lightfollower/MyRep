package lesson_6.Client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Main extends Application {
    Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Lesson_6/Client/sample.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        primaryStage.setTitle("chat 2k19");
        Scene scene = new Scene(root, 350, 370);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        controller.out.writeUTF("/end");
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
