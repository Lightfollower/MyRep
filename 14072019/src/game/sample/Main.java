package Game.sample;

import Game.Game;
import Game.heroes.Assassin;
import Game.heroes.Doctor;
import Game.heroes.Hero;
import Game.heroes.Warrior;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    Game game = new Game(this);

    public TextArea log;



    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<String> heroes = FXCollections.observableArrayList("Warrior", "Assassin", "Doctor");
        ChoiceBox<String> choiceBox_1 = new ChoiceBox<>(heroes);
        ChoiceBox<String> choiceBox_2 = new ChoiceBox<>(heroes);
        HBox team_1 = new HBox();
        HBox team_2 = new HBox();
        Button addButton_1 = new Button("Add");
        Button addButton_2 = new Button("Add");
        Button start = new Button("Start");
        TextArea team_1TextArea = new TextArea();
        TextArea team_2TextArea = new TextArea();
        team_1TextArea.setPrefWidth(300);
        team_2TextArea.setPrefWidth(300);
        HBox lineup = new HBox(team_1TextArea, team_2TextArea);
        log = new TextArea();
        log.setPrefWidth(700);
        log.setPrefHeight(500);

        addButton_1.setOnAction(event -> {
            Hero hero;
            switch (choiceBox_1.getValue()) {
                case "Warrior":
                    hero = new Warrior(game, 250, "Nameless warrior from team 1", 50, 0, game.team1, game.team2);
                    game.addHeroInTeam_1(hero);
                    team_1TextArea.appendText(hero.toString() + "\n");
                    break;
                case "Assassin":
                    hero = new Assassin(game, 150, "Nameless Assassin from team 1", 70, 0, game.team1, game.team2);
                    game.addHeroInTeam_1(hero);
                    team_1TextArea.appendText(hero.toString() + "\n");
                    break;
                case "Doctor":
                    hero = new Doctor(game, 120, "NamelessHealer from team 1", 0, 60, game.team1, game.team2);
                    game.addHeroInTeam_1(hero);
                    team_1TextArea.appendText(hero.toString() + "\n");
                    break;
            }
        });
        addButton_2.setOnAction(event -> {
            Hero hero;
            switch (choiceBox_2.getValue()) {
                case "Warrior":
                    hero = new Warrior(game, 250, "Nameless warrior from team 2", 50, 0, game.team2, game.team1);
                    game.addHeroInTeam_2(hero);
                    team_2TextArea.appendText(hero.toString() + "\n");
                    break;
                case "Assassin":
                    hero = new Assassin(game, 150, "Nameless Assassin from team 2", 70, 0, game.team2, game.team1);
                    game.addHeroInTeam_2(hero);
                    team_2TextArea.appendText(hero.toString() + "\n");
                    break;
                case "Doctor":
                    hero = new Doctor(game, 120, "NamelessHealer from team 2", 0, 60, game.team2, game.team1);
                    game.addHeroInTeam_2(hero);
                    team_2TextArea.appendText(hero.toString() + "\n");
                    break;
            }
        });

        start.setOnAction(event -> {
            game.startGame();
        });


        team_1.getChildren().add(choiceBox_1);
        team_1.getChildren().add(addButton_1);
        team_2.getChildren().add(addButton_2);
        team_2.getChildren().add(choiceBox_2);

        FlowPane root = new FlowPane(10, 10, team_1, team_2, start,lineup, log);

        Scene scene = new Scene(root, 300, 250);
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("GoodbyeWorldBattle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
