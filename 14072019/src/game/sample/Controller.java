package Game.sample;

import Game.Game;
import Game.heroes.Assassin;
import Game.heroes.Doctor;
import Game.heroes.Hero;
import Game.heroes.Warrior;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextArea team_1;

    @FXML
    TextArea team_2;

    @FXML
    ChoiceBox<String> choiceBox_1;

    @FXML
    ChoiceBox<String> choiceBox_2;

    @FXML
    public VBox log;

    ObservableList<String> heroes = FXCollections.observableArrayList("Warrior", "Assassin", "Doctor");

    Game game = new Game(this);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox_1.setItems(heroes);
        choiceBox_2.setItems(heroes);
    }

    public void add_1() {
        if (choiceBox_1.getValue() != null) {
            Hero hero;
            switch (choiceBox_1.getValue()) {
                case "Warrior":
                    hero = new Warrior(game, 250, "Nameless warrior from team 1", 50, 0, game.team1, game.team2);
                    game.addHeroInTeam_1(hero);
                    break;
                case "Assassin":
                    hero = new Assassin(game, 150, "Nameless Assassin from team 1", 70, 0, game.team1, game.team2);
                    game.addHeroInTeam_1(hero);
                    break;
                case "Doctor":
                    hero = new Doctor(game, 120, "NamelessHealer from team 1", 0, 60, game.team1, game.team2);
                    game.addHeroInTeam_1(hero);
                    break;
            }
            team_1.appendText(choiceBox_1.getValue() + "\n");
        }
    }

    public void add_2() {
        if (choiceBox_2.getValue() != null) {
            Hero hero;
            switch (choiceBox_2.getValue()) {
                case "Warrior":
                    hero = new Warrior(game, 250, "Nameless warrior from team 2", 50, 0, game.team2, game.team1);
                    game.addHeroInTeam_2(hero);
                    break;
                case "Assassin":
                    hero = new Assassin(game, 150, "Nameless Assassin from team 2", 70, 0, game.team2, game.team1);
                    game.addHeroInTeam_2(hero);
                    break;
                case "Doctor":
                    hero = new Doctor(game, 120, "NamelessHealer from team 2", 0, 60, game.team2, game.team1);
                    game.addHeroInTeam_2(hero);
                    break;
            }
            team_2.appendText(choiceBox_2.getValue() + "\n");
        }
    }

    public void start() {
        game.startGame();
    }
}
