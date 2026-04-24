package hust.soict.dsai.aims;

public class Aims {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // Tạo các đối tượng DVD mới và thêm chúng vào giỏ hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // In ra tổng chi phí của các mặt hàng trong giỏ
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // ---------------------------------------------------
        // PHẦN CODE CHO MỤC 11: KIỂM TRA TÍNH NĂNG XÓA
        // ---------------------------------------------------
        System.out.println("\n--- Bắt đầu test xóa đĩa ---");

        // Gọi hàm xóa đĩa dvd2 (Star Wars) khỏi giỏ hàng
        anOrder.removeDigitalVideoDisc(dvd2);

        // In lại tổng tiền xem đã trừ đi giá trị của đĩa bị xóa chưa
        System.out.println("Total Cost after removing is: ");
        System.out.println(anOrder.totalCost());
    }
}