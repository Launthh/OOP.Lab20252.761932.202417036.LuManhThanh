import java.util.Scanner;

public class StarTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập chiều cao n
        System.out.print("Nhập chiều cao của tam giác (n): ");
        int n = scanner.nextInt();

        // Vòng lặp chính quản lý số hàng (từ 1 đến n)
        for (int i = 1; i <= n; i++) {

            // Vòng lặp 1: In ra các khoảng trắng ở đầu mỗi hàng
            // Hàng thứ i sẽ có (n - i) khoảng trắng
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Vòng lặp 2: In ra các dấu sao
            // Hàng thứ i sẽ có (2*i - 1) dấu sao
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            // Xuống dòng sau khi vẽ xong một hàng
            System.out.println();
        }

        scanner.close();
    }
}