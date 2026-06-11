package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Đọc file giao diện FXML
        Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/globalict/javafx/Painter.fxml"));

        // Đặt giao diện vào một Scene và hiển thị trên cửa sổ (Stage)
        Scene scene = new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}