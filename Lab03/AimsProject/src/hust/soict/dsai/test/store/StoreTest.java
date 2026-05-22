package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Khởi tạo cửa hàng
        Store store = new Store();

        // Tạo một số DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        System.out.println("--- TESTING ADD METHOD ---");
        // Thêm DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // In ra để kiểm tra danh sách hiện tại
        store.print();

        System.out.println("\n--- TESTING REMOVE METHOD ---");
        // Xóa một DVD có trong cửa hàng
        store.removeDVD(dvd2); // Xóa Star Wars

        // Cố gắng xóa một DVD không có (hoặc đã bị xóa) trong cửa hàng
        store.removeDVD(dvd2);

        // In lại danh sách để kiểm tra xem mảng có bị lỗi khoảng trống không
        store.print();
    }
}