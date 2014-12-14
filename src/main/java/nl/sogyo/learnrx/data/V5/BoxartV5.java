package nl.sogyo.learnrx.data.V5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxartV5 {

    public final Integer videoId;
    public final String url;
    public final int width;
    public final int height;

    public BoxartV5(int videoId, int width, int height, String url) {
        this.videoId = videoId;
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public static List<BoxartV5> boxartFactory(BoxartV5... boxarts) {
        List<BoxartV5> boxes = new ArrayList<>(boxarts.length);
        Collections.addAll(boxes, boxarts);
        return boxes;
    }
}
