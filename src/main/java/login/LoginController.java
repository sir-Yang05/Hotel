package login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Session;
import java.io.IOException;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML private void handleLogin() throws IOException {
        String u = usernameField.getText();
        String p = passwordField.getText();
        if ("admin".equals(u) && "admin".equals(p)) {
            Session.setUser(u, Session.Role.ADMIN);
            navigate("/dashboard/AdminDashboard.fxml");
        } else if (!u.isEmpty() && !p.isEmpty()) {
            Session.setUser(u, Session.Role.USER);
            navigate("/dashboard/Dashboard.fxml");
        } else {
            new Alert(Alert.AlertType.WARNING, "请输入用户名和密码").show();
        }
    }

    @FXML private void handleRegister() throws IOException {
        navigate("/adduser/AddUser.fxml");
    }

    private void navigate(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Stage stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(new Scene(root, 900, 700));
    }
}
