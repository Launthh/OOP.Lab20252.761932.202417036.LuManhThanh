package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[]
                                    args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Lưu tạm title của dvd1
        String tmpTitle = dvd1.getTitle();

        // Gán title của dvd2 cho dvd1
        dvd1.setTitle(dvd2.getTitle());

        // Gán title đã lưu tạm cho dvd2
        dvd2.setTitle(tmpTitle);

    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();

        dvd.setTitle(title);

        dvd = new DigitalVideoDisc(oldTitle);
    }
}