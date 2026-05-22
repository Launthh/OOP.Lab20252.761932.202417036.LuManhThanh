package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1); // Thay doi thanh addMedia

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2); // Thay doi thanh addMedia

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3); // Thay doi thanh addMedia

        // Test the print method
        cart.print();

        // Test the search methods here
        System.out.println("\n--- Testing Search Methods ---");

        // Test tim kiem theo ID
        cart.searchById(1);
        cart.searchById(10);

        System.out.println();

        // Test tim kiem theo Title
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Lion");
        cart.searchByTitle("Batman");
    }
}