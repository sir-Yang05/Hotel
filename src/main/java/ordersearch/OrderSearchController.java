package ordersearch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Booking;
import service.BookingService;
import util.Session;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderSearchController {
    @FXML private TableView<Booking> ordersTable;
    @FXML private TableColumn<Booking,Integer> idCol;
    @FXML private TableColumn<Booking,String> roomCol;
    @FXML private TableColumn<Booking,java.time.LocalDate> checkinCol;
    @FXML private TableColumn<Booking,java.time.LocalDate> checkoutCol;
    @FXML private TableColumn<Booking,String> userCol;
    @FXML private TextField searchField;
    @FXML private Button backBtn;

    @FXML public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        roomCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        checkinCol.setCellValueFactory(new PropertyValueFactory<>("checkinDate"));
        checkoutCol.setCellValueFactory(new PropertyValueFactory<>("checkoutDate"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        loadData();
    }

    private void loadData() {
        List<Booking> list = Session.getRole()==Session.Role.ADMIN
            ? BookingService.getAll()
            : BookingService.getByUser();
        ordersTable.setItems(FXCollections.observableArrayList(list));
    }

    @FXML private void handleSearch() {
        String term = searchField.getText().toLowerCase();
        List<Booking> filtered = ordersTable.getItems().stream()
            .filter(b -> b.getRoomType().toLowerCase().contains(term))
            .toList();
        ordersTable.setItems(FXCollections.observableArrayList(filtered));
    }

    @FXML private void handleBack() throws IOException {
        String fxml = Session.getRole()==Session.Role.ADMIN 
            ? "/dashboard/AdminDashboard.fxml" 
            : "/dashboard/Dashboard.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(new Scene(root, 900, 700));
    }
}
