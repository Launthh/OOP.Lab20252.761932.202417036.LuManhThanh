package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMediaCompare {
    public static void main(String[] args) {
// Tao mot danh sach cac Media
        List<Media> collection = new ArrayList<Media>();

        // Tao cac doi tuong thuoc 3 loai khac nhau
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", 19.95f);
        Book book = new Book("Star Wars", "Science Fiction", 24.95f);
        CompactDisc cd = new CompactDisc("Aladin", "Animation", 18.99f, 87, "John Musker", "Various");

        // Them vao danh sach
        collection.add(dvd);
        collection.add(book);
        collection.add(cd);

        // In danh sach ban dau
        System.out.println("--- Danh sach truoc khi sap xep ---");
        for (Media m : collection) {
            System.out.println(m.toString());
        }

        // Sap xep theo Tieu de roi den Gia
        System.out.println("\n--- Sap xep theo Tieu de roi den Gia ---");
        Collections.sort(collection, Media.COMPARE_BY_TITLE_COST);
        for (Media m : collection) {
            System.out.println(m.toString());
        }

        // Sap xep theo Gia roi den Tieu de
        System.out.println("\n--- Sap xep theo Gia roi den Tieu de ---");
        Collections.sort(collection, Media.COMPARE_BY_COST_TITLE);
        for (Media m : collection) {
            System.out.println(m.toString());
        }
    }
}