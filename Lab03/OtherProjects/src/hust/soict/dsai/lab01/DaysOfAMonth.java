package hust.soict.dsai.lab01;

import java.util.Scanner;

public class DaysOfAMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = -1;
        int year = -1;

        System.out.println("--- CHƯƠNG TRÌNH TÍNH SỐ NGÀY CỦA THÁNG ---");

        // Vòng lặp lấy thông tin tháng và năm hợp lệ
        while (true) {
            // Xử lý nhập tháng
            if (month == -1) {
                System.out.print("Nhập tháng (1-12, tên Tiếng Anh, viết tắt, hoặc 3 chữ cái): ");
                String monthInput = scanner.nextLine().trim().toLowerCase();
                month = getMonthNumber(monthInput);

                if (month == -1) {
                    System.out.println("Lỗi: Tháng không hợp lệ! Vui lòng nhập lại.");
                    continue; // Quay lại đầu vòng lặp
                }
            }

            // Xử lý nhập năm
            if (year == -1) {
                System.out.print("Nhập năm (số nguyên không âm, đầy đủ chữ số, VD: 1999): ");
                String yearInput = scanner.nextLine().trim();

                // Kiểm tra xem năm có chứa toàn chữ số hay không
                if (!yearInput.matches("\\d+")) {
                    System.out.println("Lỗi: Năm không hợp lệ! Vui lòng chỉ nhập số.");
                    continue;
                }

                year = Integer.parseInt(yearInput);
            }

            // Nếu cả tháng và năm đều đã hợp lệ thì thoát vòng lặp nhập liệu
            break;
        }

        // Kiểm tra năm nhuận
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Tính số ngày trong tháng
        int days = 0;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = isLeapYear ? 29 : 28;
                break;
        }

        // In kết quả
        System.out.println("\nKết quả: Tháng " + month + " năm " + year + " có " + days + " ngày.");

        scanner.close();
    }

    // Hàm phụ trợ để chuyển đổi chuỗi nhập vào thành số thứ tự của tháng (1-12)
    private static int getMonthNumber(String input) {
        switch (input) {
            case "1": case "jan": case "jan.": case "january": return 1;
            case "2": case "feb": case "feb.": case "february": return 2;
            case "3": case "mar": case "mar.": case "march": return 3;
            case "4": case "apr": case "apr.": case "april": return 4;
            case "5": case "may": return 5;
            case "6": case "jun": case "jun.": case "june": return 6;
            case "7": case "jul": case "jul.": case "july": return 7;
            case "8": case "aug": case "aug.": case "august": return 8;
            case "9": case "sep": case "sep.": case "september": return 9;
            case "10": case "oct": case "oct.": case "october": return 10;
            case "11": case "nov": case "nov.": case "november": return 11;
            case "12": case "dec": case "dec.": case "december": return 12;
            default: return -1; // Trả về -1 nếu không khớp với bất kỳ định dạng nào
        }
    }
}