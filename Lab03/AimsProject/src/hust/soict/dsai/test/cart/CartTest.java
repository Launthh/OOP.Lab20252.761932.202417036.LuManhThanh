package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();

        // To-do: Test the search methods here
        System.out.println("\n--- Testing Search Methods ---");

        // Test tìm kiếm theo ID đúng và sai (Giả sử ID được tự động cấp từ 1, 2, 3...)
        cart.searchById(1);
        cart.searchById(10); // Trường hợp không tìm thấy

        System.out.println();

        // Test tìm kiếm theo Title
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Lion"); // Tìm kiếm một phần của tên
        cart.searchByTitle("Batman"); // Trường hợp không tìm thấy
    }
}