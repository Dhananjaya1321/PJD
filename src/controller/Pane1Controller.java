package controller;

import com.jfoenix.controls.JFXDatePicker;
import db.DBConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import view.tm.Customer;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

       /* System.out.println(name);
        System.out.println(address);
        System.out.println(dob);
        System.out.println(gender);*/

        customers.add(new Customer(name, address, gender, dob));


        try {

            Connection connection = DBConnector.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (name,address,dob,gender) VALUES (?,?,?,?)");
            preparedStatement.setObject(1, name);
            preparedStatement.setObject(2, address);
            preparedStatement.setObject(3, dob);
            preparedStatement.setObject(4, gender);
            preparedStatement.executeUpdate();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


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

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String dob = String.valueOf(txtDOB.getValue());
        String gender = String.valueOf(cmbGender.getValue());

        try {
            Connection connection = DBConnector.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customers SET address=?,dob=?,gender=? WHERE name=?");
            preparedStatement.setObject(1,address);
            preparedStatement.setObject(2,dob);
            preparedStatement.setObject(3,gender);
            preparedStatement.setObject(4,name);

            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String name = txtName.getText();

        try {

            Connection connection = DBConnector.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customers WHERE name=?");

            preparedStatement.setObject(1,name);

            int isDeleted = preparedStatement.executeUpdate();
            if (isDeleted > 0) {
                System.out.println("Success fully deleted");
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnAllOnAction(ActionEvent actionEvent) {
        try {
            Connection connection = DBConnector.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customers");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
