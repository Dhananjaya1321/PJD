package controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.Customer;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Pane1Controller implements Initializable {
    public AnchorPane pane1;
    public ComboBox cmbGender;
    public TextField txtName;
    public TextField txtAddress;
    public JFXDatePicker txtDOB;
    public TableView tblView;
    public TableColumn colName;
    public TableColumn colGender;
    public TableColumn colAddress;
    public TableColumn colDOB;
    ObservableList<Customer> customers = FXCollections.observableArrayList();

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String dob = String.valueOf(txtDOB.getValue());
        String gender = String.valueOf(cmbGender.getValue());

        System.out.println(name);
        System.out.println(address);
        System.out.println(dob);
        System.out.println(gender);

        customers.add(new Customer(name,address,gender,dob));

        tblView.setItems(customers);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbGender.getItems().addAll("male", "Female");

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
    }
}
