package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Da them tac gia: " + authorName);
        } else {
            System.out.println("Tac gia " + authorName + " da ton tai trong danh sach.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Da xoa tac gia: " + authorName);
        } else {
            System.out.println("Khong tim thay tac gia " + authorName + " de xoa.");
        }
    }

    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - Authors: " + authors + ": " + this.getCost() + " $";
    }
}