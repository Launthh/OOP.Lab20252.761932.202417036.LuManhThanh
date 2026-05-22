package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Da them san pham vao gio hang.");
        } else {
            System.out.println("San pham nay da co trong gio hang.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Da xoa san pham khoi gio hang.");
        } else {
            System.out.println("Khong tim thay san pham trong gio hang.");
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            if (media != null) {
                total += media.getCost();
            }
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tim thay san pham: " + media.toString());
                matchFound = true;
                break;
            }
        }
        if (!matchFound) {
            System.out.println("Khong tim thay san pham voi ID la: " + id);
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public void filterById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham nao co ID: " + id);
        }
    }

    public void filterByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham nao co tieu de chua: " + title);
        }
    }

    public void sortByTitleCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Da sap xep gio hang theo Tieu de roi den Gia.");
        this.print();
    }

    public void sortByCostTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Da sap xep gio hang theo Gia roi den Tieu de.");
        this.print();
    }
}