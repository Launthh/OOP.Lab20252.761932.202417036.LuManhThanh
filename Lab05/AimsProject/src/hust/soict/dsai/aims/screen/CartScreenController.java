package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediacategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotal;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    private FilteredList<Media> filteredItems;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        filteredItems = new FilteredList<>(this.cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredItems);

        // Disable buttons until a media item is selected.
        btnPlay.setDisable(true);
        btnRemove.setDisable(true);

        // Lắng nghe chọn dòng
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    updateButtonBar(newValue);
                }
        );

        // Binding tổng tiền
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) c -> {
            lblTotal.setText(String.format("%.2f $", cart.totalCost()));
        });
        lblTotal.setText(String.format("%.2f $", cart.totalCost()));

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> applyFilter());
        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> applyFilter());
        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> applyFilter());
    }

    void updateButtonBar(Media media) {
        btnRemove.setDisable(media == null);
        btnPlay.setDisable(!(media instanceof Playable));
    }

    private void applyFilter() {
        String filter = tfFilter.getText();
        if (filter == null || filter.trim().isEmpty()) {
            filteredItems.setPredicate(media -> true);
            return;
        }

        String normalizedFilter = filter.trim().toLowerCase();
        filteredItems.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(normalizedFilter);
            }
            return media.getTitle() != null && media.getTitle().toLowerCase().contains(normalizedFilter);
        });
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Cart is empty!");
            alert.setContentText("Please add some items to your cart before ordering.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Order placed successfully!");
            alert.showAndWait();
            cart.getItemsOrdered().clear();
        }
    }
}
