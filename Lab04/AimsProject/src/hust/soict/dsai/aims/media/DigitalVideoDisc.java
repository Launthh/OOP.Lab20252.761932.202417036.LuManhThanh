package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, 0, "");
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            System.out.println("ERROR: DVD " + this.getTitle() + " cannot be played because its length is 0 or less.");
        }
    }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }

    public DigitalVideoDisc(String title) {
        super();
        this.setTitle(title);
    }
}