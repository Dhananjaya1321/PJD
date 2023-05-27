package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LogInFormController {

    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private JFXButton btnLogIn;

    @FXML
    void btnLogInOnAction(ActionEvent event) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        System.out.println(userName);
        System.out.println(password);

        Parent load = FXMLLoader.load(getClass().getResource("../view/HomeForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(load);

    }
}
