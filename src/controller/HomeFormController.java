package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class HomeFormController {


    public BorderPane fulPane;
    public AnchorPane centerPane;

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/LogInForm.fxml"));
        fulPane.getChildren().clear();
        fulPane.getChildren().add(load);
    }

    @FXML
    void btnOneOnAction(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/Pane1.fxml"));
        centerPane.getChildren().clear();
        fulPane.setCenter(load);
    }

    @FXML
    void btnThreeOnAction(ActionEvent event) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/Pane3.fxml"));
        centerPane.getChildren().clear();
        fulPane.setCenter(load);
    }


    public void btnTwoOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/Pane2.fxml"));
        centerPane.getChildren().clear();
        fulPane.setCenter(load);
    }
}
