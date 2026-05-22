package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length);
        } else {
            System.out.println("ERROR: Track " + this.title + " cannot be played because its length is 0 or less.");
        }
    }
}