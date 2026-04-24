package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    // Mảng chứa các DVD có sẵn trong cửa hàng
    private DigitalVideoDisc[] itemsInStore;
    // Biến đếm số lượng đĩa hiện có
    private int qtyInStore;
    // Hằng số quy định số lượng tối đa cửa hàng có thể chứa
    public static final int MAX_NUMBERS_IN_STORE = 100;

    // Constructor khởi tạo mảng
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];
        qtyInStore = 0;
    }

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_NUMBERS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            // Kiểm tra xem đĩa có tồn tại trong cửa hàng không
            if (itemsInStore[i] == dvd) {
                // Dịch chuyển các phần tử phía sau lên trước để lấp chỗ trống
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                // Xóa tham chiếu ở phần tử cuối và giảm số lượng
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("The DVD '" + dvd.getTitle() + "' has been removed from the store.");
                found = true;
                break; // Thoát vòng lặp sau khi xóa thành công
            }
        }
        if (!found) {
            System.out.println("The DVD '" + dvd.getTitle() + "' is not found in the store.");
        }
    }

    // (Tùy chọn) Phương thức in danh sách cửa hàng để dễ quan sát khi test
    public void print() {
        System.out.println("***********************STORE INVENTORY***********************");
        if (qtyInStore == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("*************************************************************");
    }
}