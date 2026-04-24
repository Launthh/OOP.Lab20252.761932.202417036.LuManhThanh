package hust.soict.dsai.lab01;

import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] my_array1 = {1789, 2035, 1899, 1456, 2013};

        System.out.println("Mảng ban đầu: " + Arrays.toString(my_array1));

        Arrays.sort(my_array1);

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(my_array1));
        int sum = 0;

        for (int num : my_array1) {
            sum += num;
        }

        double average = (double) sum / my_array1.length;

        System.out.println("Tổng các phần tử: " + sum);
        System.out.println("Giá trị trung bình: " + average);
    }
}