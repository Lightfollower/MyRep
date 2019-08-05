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
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Lesson_6/Client/sample.fxml"));

    Controller controller =   loader.getController();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = loader.load(getClass().getResource("/Lesson_6/Client/sample.fxml"));
        primaryStage.setTitle("chat 2k19");
        Scene scene = new Scene(root, 350, 370);
        primaryStage.setScene(scene);
        primaryStage.show();
//        primaryStage.setOnCloseRequest(event -> {
//            try {
//                controller.out.writeUTF("/end");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
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
