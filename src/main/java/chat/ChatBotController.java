package chat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ChatBotController {
    @FXML private TextArea chatArea;
    @FXML private TextField inputField;
    @FXML private Button backBtn;

    @FXML private void handleSend() {
        String msg = inputField.getText();
        if (!msg.isBlank()) {
            chatArea.appendText("You: " + msg + "\n");
            chatArea.appendText("Bot: Echo -> " + msg + "\n");
            inputField.clear();
        }
    }

    @FXML private void handleBack() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/dashboard/Dashboard.fxml"));
        Stage stage = (Stage) backBtn.getScene().getWindow();
        stage.setScene(new Scene(root, 900, 700));
    }
}
