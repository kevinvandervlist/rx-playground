package nl.sogyo.learnrx.data.V2;

import java.util.ArrayList;
import java.util.List;

public class Boxart {

    public final String url;
    public final int width;
    public final int height;

    public Boxart(int width, int height, String url) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public static List<Boxart> boxartFactory(Boxart... boxarts) {
        List<Boxart> boxes = new ArrayList<>(boxarts.length);
        for(int i = 0; i < boxarts.length; i++) {
            boxes.add(boxarts[i]);
        }
        return boxes;
    }
}
