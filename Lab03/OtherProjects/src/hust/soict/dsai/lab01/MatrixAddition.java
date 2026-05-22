package hust.soict.dsai.lab01;

public class MatrixAddition {
    public static void main(String[] args) {
        // Khởi tạo ma trận A (ví dụ: ma trận 3x3)
        int[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Khởi tạo ma trận B (cùng kích thước 3x3 với A)
        int[][] matrixB = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Lấy số hàng và số cột của ma trận
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        // Tạo ma trận kết quả để lưu tổng
        int[][] resultMatrix = new int[rows][cols];

        // Thực hiện phép cộng hai ma trận
        // Công thức: C[i][j] = A[i][j] + B[i][j]
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        // In kết quả ra màn hình
        System.out.println("--- KẾT QUẢ CỘNG HAI MA TRẬN ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Dùng printf để căn lề cho các con số thẳng cột với nhau
                System.out.printf("%4d", resultMatrix[i][j]);
            }
            System.out.println(); // Xuống dòng khi hết một hàng
        }
    }
}