package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    store.print();
                    handleStoreMenu();
                    break;
                case 2:
                    System.out.println("Tinh nang cap nhat cua hang dang duoc xay dung.");
                    break;
                case 3:
                    cart.print();
                    handleCartMenu();
                    break;
                case 0:
                    System.out.println("Cam on ban da su dung AIMS. Tam biet!");
                    exit = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void handleStoreMenu() {
        boolean back = false;
        while (!back) {
            storeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Nhap tieu de san pham de xem chi tiet: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        mediaDetailsMenu(media);
                    } else {
                        System.out.println("Khong tim thay san pham: " + title);
                    }
                    break;
                case 2:
                    System.out.println("Nhap tieu de san pham de them vao gio hang: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaAdd = store.searchByTitle(titleAdd);
                    if (mediaAdd != null) {
                        cart.addMedia(mediaAdd);
                    } else {
                        System.out.println("Khong tim thay san pham: " + titleAdd);
                    }
                    break;
                case 3:
                    System.out.println("Nhap tieu de san pham de phat: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = store.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof hust.soict.dsai.aims.media.Playable) {
                            ((hust.soict.dsai.aims.media.Playable) mediaPlay).play();
                        } else {
                            System.out.println("San pham nay khong ho tro phat.");
                        }
                    } else {
                        System.out.println("Khong tim thay san pham: " + titlePlay);
                    }
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof hust.soict.dsai.aims.media.Playable) {
                        ((hust.soict.dsai.aims.media.Playable) media).play();
                    } else {
                        System.out.println("San pham nay khong ho tro phat.");
                    }
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void handleCartMenu() {
        boolean back = false;
        while (!back) {
            cartMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Chon cach loc (1: Theo ID, 2: Theo Tieu de): ");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.println("Nhap ID can loc: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cart.filterById(id);
                    } else if (filterChoice == 2) {
                        System.out.println("Nhap Tieu de can loc: ");
                        String title = scanner.nextLine();
                        cart.filterByTitle(title);
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                case 2:
                    System.out.println("Chon cach sap xep (1: Theo Tieu de, 2: Theo Gia): ");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) {
                        cart.sortByTitleCost();
                    } else if (sortChoice == 2) {
                        cart.sortByCostTitle();
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                case 3:
                    System.out.println("Nhap tieu de san pham can xoa khoi gio: ");
                    String titleRemove = scanner.nextLine();
                    Media mediaRemove = cart.searchByTitle(titleRemove);
                    if (mediaRemove != null) {
                        cart.removeMedia(mediaRemove);
                    } else {
                        System.out.println("Khong tim thay san pham trong gio hang.");
                    }
                    break;
                case 4:
                    System.out.println("Nhap tieu de san pham de phat: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = cart.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof hust.soict.dsai.aims.media.Playable) {
                            ((hust.soict.dsai.aims.media.Playable) mediaPlay).play();
                        } else {
                            System.out.println("San pham nay khong ho tro phat.");
                        }
                    } else {
                        System.out.println("Khong tim thay san pham trong gio hang.");
                    }
                    break;
                case 5:
                    System.out.println("Da dat hang thanh cong! Gio hang da duoc lam trong.");
                    cart = new Cart();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        }
    }
}