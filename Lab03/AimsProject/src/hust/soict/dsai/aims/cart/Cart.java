package hust.soict.dsai.aims.cart;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Hàm thêm đĩa
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        // Loop through each disc in the provided array
        for (DigitalVideoDisc disc : dvdList) {
            // Call the single-add method for each item
            this.addDigitalVideoDisc(disc);
        }

        System.out.println("The list of DVDs has been added to the cart.");
    }

    // Phương thức nạp chồng để thêm chính xác 2 đĩa DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Tái sử dụng phương thức thêm 1 đĩa cho đĩa thứ nhất
        this.addDigitalVideoDisc(dvd1);

        // Tái sử dụng phương thức thêm 1 đĩa cho đĩa thứ hai
        this.addDigitalVideoDisc(dvd2);

        System.out.println("Two DVDs have been added to the shopping cart");
    }

    // Hàm xóa đĩa
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) { // Tìm thấy đĩa cần xóa
                found = true;
                // Dồn các phần tử phía sau lên để lấp chỗ trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa tham chiếu ở phần tử cuối
                qtyOrdered--;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart");
        }
    }

    // Hàm tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD with ID " + id + " was found in the cart.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found match: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD with title '" + title + "' was found in the cart.");
        }
    }
}


