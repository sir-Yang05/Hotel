package roombooking;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.BookingService;

public class RoomBookingController {
    @FXML private ChoiceBox<String> roomTypeBox;
    @FXML private DatePicker checkinDatePicker;
    @FXML private DatePicker checkoutDatePicker;
    @FXML private ImageView roomImage;
    @FXML private Button backBtn;

    @FXML private void initialize() {
        roomTypeBox.getItems().addAll("Single","Double","Suite");
        roomTypeBox.setOnAction(e-> {
            String t = roomTypeBox.getValue().toLowerCase();
            Image img = new Image(getClass().getResourceAsStream("/images/"+t+".jpg"));
            roomImage.setImage(img);
        });
    }

    @FXML private void handleBook() {
        if (roomTypeBox.getValue()==null 
         || checkinDatePicker.getValue()==null 
         || checkoutDatePicker.getValue()==null) {
            new Alert(Alert.AlertType.WARNING, "请完整填写信息").show();
            return;
        }
        BookingService.addBooking(
            roomTypeBox.getValue(), 
            checkinDatePicker.getValue(), 
            checkoutDatePicker.getValue()
        );
        new Alert(Alert.AlertType.INFORMATION, "预订成功").show();
    }
    @FXML private void handleBack() { backBtn.getScene().getWindow().hide(); }
}
