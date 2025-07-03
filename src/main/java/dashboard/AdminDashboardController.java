package dashboard;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminDashboardController {
    @FXML private Button manageRoomsBtn;
    @FXML private Button manageUsersBtn;
    @FXML private Button orderSearchBtn;
    @FXML private Button chatBotBtn;
    @FXML private Button backBtn;

    @FXML private void handleManageRooms() throws IOException {
        navigate("/roombooking/RoomBooking.fxml");
    }
    @FXML private void handleManageUsers() throws IOException {
        navigate("/adduser/AddUser.fxml");
    }
    @FXML private void handleOrderSearch() throws IOException {
        navigate("/ordersearch/OrderSearch.fxml");
    }
    @FXML private void handleChatBot() throws IOException {
        navigate("/chat/ChatBot.fxml");
    }
    @FXML private void handleBack() throws IOException {
        navigate("/login/Login.fxml");
    }

    private void navigate(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(new Scene(root, 900, 700));
    }
}
