package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Xóa toàn bộ các nét vẽ (hình tròn con) trên bảng
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        // Tạo một hình tròn nhỏ màu đen tại tọa độ con chuột đang kéo
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        // Thêm hình tròn đó vào vùng vẽ
        drawingAreaPane.getChildren().add(newCircle);
    }
}