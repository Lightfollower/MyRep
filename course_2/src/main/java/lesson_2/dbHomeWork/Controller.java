package lesson_2.dbHomeWork;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Controller {

    @FXML
    VBox log;

    @FXML
    TextField textField;

    @FXML
    HBox bottomPanel;

    private String qry;
    private String[] tokens;
    private ResultSet resultSet;

    public void executeQry() {
        qry = textField.getText();
        tokens = qry.split(" ");

        if (qry.startsWith("/цена")) {
            if (tokens.length == 1) {
                updateLog("Write something else in the request");
                return;
            }
            try {
                resultSet = DBService.getCostByTitle(tokens[1]);
                if (resultSet.next()) {
                    updateLog("Cost of " + tokens[1] + " : " + resultSet.getFloat(1));
                } else {
                    updateLog("there's no such thing");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (qry.startsWith("/сменитьцену")) {
            if (tokens.length == 3 && tokens[2].matches("^(0|[1-9]\\d*)(\\.\\d+)?$")) {
                try {
                    updateLog(DBService.changeCostByTitle(tokens[1], tokens[2]) == 1 ? "changes were successful" : "nothing changed");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                updateLog("Illegal query");
            }
        }

        if (qry.startsWith("/тц")) {
            if (tokens.length == 3 && (tokens[1].matches("^(0|[1-9]\\d*)(\\.\\d+)?$") && (tokens[2].matches("^(0|[1-9]\\d*)(\\.\\d+)?$")))) {
                try {
                    resultSet = DBService.getGoodsByPriceRange(tokens[1], tokens[2]);
                    if(resultSet.next()){
                        do {
                            updateLog(resultSet.getString(1) + " : " + resultSet.getString(2));
                        } while (resultSet.next());
                    } else {
                        updateLog("There is no products in this price range");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                updateLog("Illegal query");
            }
        }
        textField.clear();
        textField.requestFocus();
    }

    public void updateLog(String labelText) {
        Label label = new Label(labelText);
        VBox vBox = new VBox();
        vBox.getChildren().add(label);
        Platform.runLater(() -> log.getChildren().add(vBox));
    }

}
